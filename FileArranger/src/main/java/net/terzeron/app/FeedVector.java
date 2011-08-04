package net.terzeron.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.itextpdf.text.exceptions.InvalidPdfException;

public class FeedVector {
	public ArrayList<String> getWords(String text) {
		//System.out.println("getWords()");
		ArrayList<String> words = new ArrayList<String>();
		String lowerText = text.toLowerCase();
		String[] wordArr = 
			lowerText.split("[\\p{Punct}\\p{Blank}\\p{Cntrl}]+");
		String pattern = "^\\p{Digit}+$";
		for (String word : wordArr) {
			if (!word.equals("") && word.matches(pattern) == false) {
				words.add(word);
			}
		}
		return words;
	}
	
	public HashMap<String, Integer> getWordCounts(String fileName) throws IOException {
		//System.out.println("getWordCounts(" + fileName + ")");
		
		StringBuffer text = new StringBuffer();
		// add file name redundantly 
		for (int i = 0; i < 50; i++) {
			text.append(fileName + " ");
		}
		HashMap<String, Integer> wc = new HashMap<String, Integer>();

		PdfTextExtractor extractor = new PdfTextExtractor();
		String str = "";
		try {
			str = extractor.getText(fileName);
		} catch (InvalidPdfException e) {
			System.out.println("\nInvalidPdfException at " + fileName);
		}
		extractor = null;
		//System.out.println("### text=" + text + "###");
		
		// extract a list of words
		//System.out.println(str);
		ArrayList<String> words = getWords(str + text.toString());
		for (String word : words) {
		    if (wc.containsKey(word)) {
		    	wc.put(word, wc.get(word) + 1);
		    } else {
		    	wc.put(word, 1);
		    } 
		}
		words.clear();
		words = null;
		return wc;
	}
	
	public void generate(ArrayList<String> fileNameList, String dataFileName) {
		System.out.println("generate()");
		
		HashMap<String, Integer> apCount = 
			new HashMap<String, Integer>();
		HashMap<String, HashMap<String, Integer>> wordCounts = 
			new HashMap<String, HashMap<String, Integer>>();
		
		for (String fileName: fileNameList) {
			System.out.print(".");
			//System.out.println(fileName);
			HashMap<String, Integer> wc;
			try {
				wc = getWordCounts(fileName);
			} catch (IOException e) {
				System.out.println("IOException at " + fileName);
				continue;
			}
			wordCounts.put(fileName, wc);
			//System.out.println("wordCounts[" + fileName + "] <-- " + wc);
			for (Entry<String, Integer> entry : wc.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();
				if (!apCount.containsKey(key)) {
					apCount.put(key, 0);
					//System.out.println("\tapCount[" +  key + "] <-- " + 0);
				}
				if (value > 0) {
					apCount.put(key, apCount.get(key) + 1);
					//System.out.println("\tapCount[" + key + "] <-- " + apCount.get(key));
				}
			}
			wc.clear();
			wc = null;
		}
		System.out.println("");

		ArrayList<String> wordList = new ArrayList<String>();
		for (Entry<String, Integer> entry : apCount.entrySet()) {
			double frac = (double) entry.getValue() / fileNameList.size();
			if (frac > 0.1 && frac < 0.9) {
				wordList.add(entry.getKey());
			}
		}
		apCount.clear();
		apCount = null;
		
		File file = new File(dataFileName);
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			file = null;
			for  (String word : wordList) {
				fw.write("\t" + word);
			}
			fw.write("\n");
			for (Entry<String, HashMap<String, Integer>> entry : wordCounts.entrySet()) {
				fw.write(entry.getKey());
				HashMap<String, Integer> wc = entry.getValue();
				for (String word : wordList) {
					if (wc.containsKey(word)) {
						fw.write("\t" + wc.get(word));
					} else {
						fw.write("\t0");
					}
				}
				fw.write("\n");
			}
			fw.close();
		} catch (IOException e) {
			System.out.println("IOException at " + dataFileName);
			return;
		} finally {
			wordCounts.clear();
			wordCounts = null;
			wordList.clear();
			wordList = null;
		}
	}
}
