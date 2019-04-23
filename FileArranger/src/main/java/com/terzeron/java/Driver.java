/**
 * 
 */

package com.terzeron.java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author terzeron
 *
 */
public class Driver {
	private static String dataFileName = "data.txt";
	private static String dirDelimiter = "/";
	
	public static ArrayList<String> scanDir(String dirPath) {
		System.out.println("scanDir(" + dirPath + ")");
		ArrayList<String> fileNameList = new ArrayList<String>();
		File dir = new File(dirPath);
		String[] children = dir.list();
		dir = null;
		if (children != null) {
			for (int i = 0; i < children.length; i++) {
				File f = new File(dirPath + dirDelimiter + children[i]);
				if (f.isFile()) {
					String fileName = children[i].toLowerCase();
					if (!fileName.endsWith(".pdf")) {
						continue;
					}
					// extract file name from file path
					fileNameList.add(dirPath + dirDelimiter + children[i]);
					System.out.print(".");
					//System.out.println(children[i]);
				}
			}
			System.out.println("");
		}
		
		return fileNameList; 
	} 
	
	public static void main(String [] args) throws IOException {
		String dirPath;
		if (System.getProperty("os.name").equals("Windows 7")) {
			dirPath = "F:\\tech";
			dirDelimiter = "\\";
		} else {
			dirPath = "/Users/terzeron/Dropbox/test";
			dirDelimiter = "/";
		}
		ArrayList<String> fileNameList = scanDir(dirPath);
		
		FeedVector feedVector = new FeedVector();
		feedVector.generate(fileNameList, dataFileName);
		fileNameList.clear();
		fileNameList = null;
		feedVector = null;
		
		DataReader dr = new DataReader();
		dr.read(dataFileName);
		String[] rowNames = dr.getRowNames();
		//String[] colNames = dr.getColNames();
		double[][] data = dr.getData();
		dr = null;

		//ArrayList<Integer>[] kcluster = Clusters.makeKMCluster(data, 3);
		//Clusters.printKMClust(kcluster, rowNames);
		Bicluster hcluster = Clusters.makeHCluster(data);
		Clusters.printHClust(hcluster, rowNames, 0);
	}
}
