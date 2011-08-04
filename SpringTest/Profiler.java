/*
 * Profiler.java  v1.0  2011. 04. 05 
 * 
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nhncorp.adbsp.profiler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONObject;

import com.nhncorp.adbsp.config.ConfigHandler;
import com.nhncorp.adbsp.config.PackageInfo;
import com.nhncorp.adbsp.config.TemplateInfo;
import com.nhncorp.adbsp.extractor.DataExtractor;
import com.nhncorp.adbsp.storage.StorageManager;
import com.nhncorp.adbsp.ui.UITemplateHandler;
import com.nhncorp.adbsp.util.JSONtoFmModel;
import com.nhncorp.adbsp.util.LogRuntimeException;

import freemarker.log.Logger;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;


/**
 * @author terzeron
 */
public class Profiler {
//	private class ProfilerTemplateExceptionHandler implements TemplateExceptionHandler {
//		public void handleTemplateException(TemplateException te, Environment env, Writer out) throws TemplateException {
//			throw te;
//		}
//	}
	
	private final Log log = LogFactory.getLog(Profiler.class.getClass());
	private HashMap<Integer, Long> profileDataMap = null;
	
	// UIGenerator.java에서 복사한 코드 
	private static Map<String, Object> convertJSONObjectToMapAddUIConfig(String pkgName, String tplName, String json) {
		Map<String, Object> contentMap = JSONtoFmModel.convertJSONObjectToMap(json);
		Map<String, String> packageCommonInfos = ConfigHandler.getInstance().getPackageInfo(pkgName).getUIProperties();
		if (packageCommonInfos != null) {
			contentMap.put("PackageCommonInfos", packageCommonInfos);
		}
		// package ID, template ID 추가
		PackageInfo pkgInfo = ConfigHandler.getInstance().getPackageInfo(pkgName);
		contentMap.put("PackageID", Integer.toString(pkgInfo.getId()));
		contentMap.put("TemplateID", Integer.toString(pkgInfo.getTemplateInfo(tplName).getId()));
		
		return contentMap;
	}
	
	public static void main(String[] args) {
		Profiler profiler = new Profiler();
		String pkg = "Subway";
		String tpl = "SubwayInfo";
		profiler.run(pkg, tpl);
	}
	
	public Profiler() {
		profileDataMap = new HashMap<Integer, Long>();
	}
	
	private int getNumLines(String tplFilePath) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(tplFilePath));
		} catch (FileNotFoundException e) {
			log.error("can't find such a file '" + tplFilePath + "'", e);
		}
		int numLines = 0;
		try {
			while (br.readLine() != null) {
				numLines++;
			}
		} catch (IOException e) {
			log.error("can't read data from file", e);
		}
		return numLines;
	}
	
	private void run(String pkg, String tpl) {
		int cnt = 1;
		
		//
		// extraction
		//
		
		// 아래는 extract() 함수 내부 코드를 복사한 것임 
		//TestUtil.extract("Attraction", "AttractionList", 1);
		
		StorageManager storageManager = 
			new StorageManager(ConfigHandler.getInstance().getCommonInfo("StorageDirectory"));
		storageManager.deleteData(ConfigHandler.UNIT_TEMPLATE, pkg, tpl);
		
		DataExtractor dataExtractor = new DataExtractor();
		JSONObject templateDefinition = 
			(JSONObject) dataExtractor.getDataExtractDefinitions(ConfigHandler.UNIT_TEMPLATE, pkg, tpl);
		dataExtractor.extractData(templateDefinition, DataExtractor.MODE_NORMAL, null, cnt);
		
		//
		// UI rendering
		//
		
		// 아래는 render() 함수와 그 함수가 호출하는 process() 함수의 내부 코드를 복사하여 변경한 것  
		//TestUtil.render("Attraction", "AttractionList");
	
		// json 파일을 하나만 읽어들여 문자열로 저장 
		File jsonFile = storageManager.getJsonFileList(pkg, tpl).iterator().next();
		log.info(jsonFile);
		String content;
		try {
			content = FileUtils.readFileToString(jsonFile);
		} catch (IOException e) {
			throw new LogRuntimeException(log, "Error in reading file: " + jsonFile, e);
		}
		
		// data를 map 형태로 변환 
		Map<String, Object> dataModelMap = convertJSONObjectToMapAddUIConfig(pkg, tpl, content);
		Object odid = dataModelMap.get("DID");
		if (odid == null) {
			throw new LogRuntimeException(log, "There is no DID in json content");
		}
		
		// 템플릿 파일의 크기를 0에서부터 한 라인씩 늘려가면서 어디에서 가장 많은 시간이 소요되는지 확인한다.
		// 라인 단위로 읽어들이다보면 실패할 수도 있으니 그런 라인은 건너뛰고 process()가 유효한 값을
		// 반환하는 지점들을 기록한다. 사이즈가 변하는 파일은 이름을 계속 바꿔가면서 테스트하면 된다.
		TemplateInfo tplInfo = ConfigHandler.getInstance().getPackageInfo(pkg).getTemplateInfo(tpl);
		String tplFileName = tplInfo.getValue(ConfigHandler.REQUIRED_UITEMPLATEFILE);
		String tplFilePath = Profiler.class.getClass().getResource(UITemplateHandler.TEMPLATE_FILE_PATH + "/" + tplFileName).getPath();
		log.info(tplFileName);

		String line;
		String postfix = ".temp";
		String tempFileName = tplFileName + postfix;
		String tempFilePath = tplFilePath + postfix;
		//log.info(line);
		log.info(tempFileName);
		log.info(tempFilePath);
		
		int numLines = getNumLines(tplFilePath);

		//  test template loading
		StringWriter out0 = new StringWriter();
		Configuration cfg0 = new Configuration();
		final String TEMPLATE_FILE_PATH = "/packages";
		cfg0.setClassForTemplateLoading(Profiler.class, TEMPLATE_FILE_PATH);
		cfg0.setObjectWrapper(ObjectWrapper.DEFAULT_WRAPPER);
		cfg0.setCacheStorage(new freemarker.cache.MruCacheStorage(0, 0));  
		cfg0.clearTemplateCache();
		//cfg.setTemplateExceptionHandler(new ProfilerTemplateExceptionHandler());
		cfg0.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		try {
			Logger.selectLoggerLibrary(Logger.LIBRARY_NONE);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Template template0 = cfg0.getTemplate(tplFileName);
			template0.process(dataModelMap, out0);
			template0 = null;
			out0.flush();
		} catch (freemarker.core.ParseException e) {
			//log.info("can't parse the template, lineCnt=" + lineCnt);
			System.out.print('-');
		} catch (freemarker.core.InvalidReferenceException e) {
			//log.info("can't use template, lineCnt=" + lineCnt);
			//e.printStackTrace();
			System.out.print('!');
		} catch (freemarker.template.TemplateException e) {
			log.info("can't use tempalte, lineCnt=");
		} catch (IOException e) {
			log.info("can't write the data, lineCnt=");
		}

			
		
		int numTries = 10;
		for (int i = 0; i < numTries; i++) {
			//System.out.println("i=" + i);
			for (int numCopyLines = 1; numCopyLines <= numLines; numCopyLines++) {
				//System.out.println("j=" + j);
				// open original template file
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(tplFilePath));
				} catch (FileNotFoundException e) {
					log.error("can't find such a file '" + tplFilePath + "'", e);
				}
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter(tempFilePath + "." + numCopyLines));
				} catch (IOException e) {
					log.error("can't open file '" + tempFilePath + "' for writing", e);
				}
				
				// read the original and write the copy line-by-line
				int lineCnt = 0;
				try {
					while ((line = br.readLine()) != null && lineCnt < numCopyLines) {
						bw.write(line + "\n");
						lineCnt++;
					}
				} catch (IOException e) {
					log.error("can't read data from the file", e);
				} finally {
					IOUtils.closeQuietly(br);
					IOUtils.closeQuietly(bw);
				}
				
				long startTime = System.currentTimeMillis();

				StringWriter out = new StringWriter();
				Configuration cfg = new Configuration();
				final String TEMPLATE_FILE_PATH0 = "/packages";
				cfg.setClassForTemplateLoading(Profiler.class, TEMPLATE_FILE_PATH0);
				cfg.setObjectWrapper(ObjectWrapper.DEFAULT_WRAPPER);
				//cfg.setCacheStorage(new freemarker.cache.MruCacheStorage(0, 0));  
				//cfg.clearTemplateCache();
				//cfg.setTemplateExceptionHandler(new ProfilerTemplateExceptionHandler());
				cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
				try {
					Logger.selectLoggerLibrary(Logger.LIBRARY_NONE);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				long midTime = 0;
				try {
					Template template = cfg.getTemplate(tempFileName + "." + numCopyLines);
					midTime = System.currentTimeMillis();
					template.process(dataModelMap, out);
					template = null;
					out.flush();
				} catch (freemarker.core.ParseException e) {
					//log.info("can't parse the template, lineCnt=" + lineCnt);
					System.out.print('-');
					continue;
				} catch (freemarker.core.InvalidReferenceException e) {
					//log.info("can't use tempalte, lineCnt=" + lineCnt);
					//e.printStackTrace();
					System.out.print('!');
					continue;
				} catch (freemarker.template.TemplateException e) {
					log.info("can't use tempalte, lineCnt=" + lineCnt);
				} catch (IOException e) {
					log.info("can't write the data, lineCnt=" + lineCnt);
				}
				
				long endTime = System.currentTimeMillis();
				// 성능이 같으면 스킵, parse 에러가 나온 곳도 스킵
				// 라인 넘버를 key로 해서 수행 시간을 누적값으로 저장할 것 (루프 밖에서 평균값을 구하면 됨)
					
				long elapseTime = endTime - startTime;
				System.out.println((startTime % 100) + ", " + (midTime % 100) + ", " + (endTime % 100) + ", " + elapseTime);
				//System.out.print(elapseTime);
				//System.out.print(", ");
				int key = lineCnt;
				long value = 0;
				if (profileDataMap.containsKey(key)) {
					value = profileDataMap.get(key) + elapseTime; 
				} else {
					value = elapseTime;
				}
				profileDataMap.put(key, value);
				//System.out.print('.');
				// 성능 평가에 오차가 크게 문제가 되면 수회 반복하여 평균값을 구한다. 
			}
			System.out.println("");
		}		
		
		Set<Map.Entry<Integer, Long>> set = profileDataMap.entrySet();
		for (Map.Entry<Integer, Long> me : set) {
			System.out.println(me.getKey() + ":" + (me.getValue() / (double) numTries));
		}
	}
}
