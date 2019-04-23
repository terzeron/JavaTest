package com.terzeron.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReader {
	private String[] rowNames;
	private String[] colNames;
	private double[][] data;
	
	public void read(String dataFileName) {
		System.out.println("read(" + dataFileName + ")");
		
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> lines = new ArrayList<String>();

		// first line
		try {
			fr = new FileReader(dataFileName);
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			if (line != null) { 
				colNames = line.trim().split("\t");
			
				// next lines
				while ((line = br.readLine()) != null) {
					lines.add(line);
				}
			}
			br.close();
			fr.close();
			br = null;
			fr = null;
		} catch (FileNotFoundException e) {
			System.err.println("can't find such a file '" + dataFileName + "'");
			return;
		} catch (IOException e) {
			System.out.println("IOException at " + dataFileName);
			return;
		} 
			
		String[] tokens;
		rowNames = new String[lines.size()];
		data = new double[lines.size()][colNames.length];
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			tokens = line.trim().split("\t");
			rowNames[i] = tokens[0];
			for (int j = 0; j < tokens.length - 1; j++) {
				data[i][j] = Double.parseDouble(tokens[j + 1]);
			}
		} 
	}
	
	public String[] getRowNames() {
		return rowNames;
	}
	
	public String[] getColNames() {
		return colNames;
	}
	
	public double[][] getData() {
		return data;
	}
}
