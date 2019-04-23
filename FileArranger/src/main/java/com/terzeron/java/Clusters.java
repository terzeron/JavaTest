/**
 * 
 */
package com.terzeron.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author terzeron
 *
 */
public abstract class Clusters {
	private static double getMin(double[][] rows, int j) {
		double min = rows[0][0];
		for (int i = 0; i < rows.length; i++) {
			if (rows[i][j] < min) {
				min = rows[i][j];
			}
		}
		return min;
	}
	
	private static double getMax(double[][] rows, int j) {
		double max = rows[0][0];
		for (int i = 0; i < rows.length; i++) {
			if (rows[i][j] > max) {
				max = rows[i][j];
			}
		}
		return max;
	}
	
	private static double getDistance(double[] a, double[] b) {
		//return Pearson.getScore(a, b);
		return Tanamoto.getScore(a, b);
	}
	
	private static double[] getMidVector(double[] a, double[] b) {
		double[] mid = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			mid[i] = (a[i] + b[i]) / 2.0;
		}
		return mid;
	}
	
	public static ArrayList<Integer>[] makeKMCluster(double[][] rows, int k) {
		int rowSize = rows.length;
		int colSize = rows[0].length;
		double[][] ranges = new double[colSize][2];
		double[][] clusters = new double[k][colSize]; 
		
		// determine the minimum and maximum values for each points
		for (int j = 0; j < colSize; j++) {
			ranges[j][0] = getMin(rows, j);
			ranges[j][1] = getMax(rows, j);
		}
		
		// create k randomly placed centeroids
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < colSize; j++) {
				clusters[i][j] = Math.random() * (ranges[j][1] - ranges[j][0]) + ranges[j][0]; 
			}
		}
		
		ArrayList<Integer>[] bestMatches = new ArrayList[k];
		for (int i = 0; i < k; i++) {
			bestMatches[i] = new ArrayList<Integer>();
		}
		ArrayList<Integer>[] lastMatches = null;
		for (int t = 0; t < 100; t++) {
			//System.out.println("Iteration " + t);
			
			// find which centroid is the closest for each row
			for (int i = 0; i < rowSize; i++) {
				double[] row = rows[i];
				int bestMatch = 0;
				for (int j = 0; j < k; j++) {
					double d = getDistance(clusters[j], row);
					if (d < getDistance(clusters[bestMatch], row)) {
						bestMatch = j;
					}
				}
				bestMatches[bestMatch].add(i);
			}
			
			// if the results are the same as last time, this is complete
			if (bestMatches == lastMatches) {
				break;
			}
			lastMatches = bestMatches;
			
			// move the centroids to the average of their members
			for (int i = 0; i < k; i++) {
				double[] avgs = new double[colSize]; 
				for (int j = 0; j < colSize; j++) {
					avgs[j] = 0.0;
				}
				if (bestMatches[i].size() > 0) {
					for (int rowid = 0; rowid < bestMatches[i].size(); rowid++) {
						for (int m = 0; m < rows[rowid].length; m++) {
							avgs[m] += rows[rowid][m];
						}
					}
					for (int j = 0; j < avgs.length; j++) {
						avgs[j] /= bestMatches[i].size();
					}
					clusters[i] = avgs;
				}
			}
		}
		
		return bestMatches;
	}
	
	public static Bicluster makeHCluster(double[][] rows) {
		System.out.println("makeHCluster()");
		
		HashMap<Pair, Double> distances = new HashMap<Pair, Double>();
		int currentClustId = -1;
		
		// clusters are initially just the rows
		LinkedList<Bicluster> clust = new LinkedList<Bicluster>();
		for (int i = 0; i < rows.length; i++) {
			clust.add(new Bicluster(rows[i], i));
		}
		
		while (clust.size() > 1) {
			Pair lowestPair = new Pair(0, 1);
			double closest = getDistance(clust.get(0).vec, clust.get(1).vec);
			
			// loop through every pair looking for the smallest distance
			for (int i = 0; i < clust.size(); i++) {
				for (int j = i + 1; j < clust.size(); j++) {
					// distances is the cache of distance calculations
					Pair pair = new Pair(clust.get(i).id, clust.get(j).id);
					//System.out.println(i + ":" + clust.get(i).id + " " + j + ":" + clust.get(j).id);
					if (!distances.containsKey(pair)) {
						distances.put(pair, getDistance(clust.get(i).vec, clust.get(j).vec)); 
					}
					double d = distances.get(pair);
					
					if (d < closest) {
						closest = d;
						lowestPair = new Pair(i, j);
					}
				}
			}
			System.out.print(".");
			
			// calculate the average of the two clusters
			int len = clust.get(0).vec.length;
			double[] mergeVec = new double[len];
			mergeVec = getMidVector(clust.get(lowestPair.left).vec, clust.get(lowestPair.right).vec);
			
			// create the new cluster
			Bicluster newCluster = new Bicluster(mergeVec, clust.get(lowestPair.left), clust.get(lowestPair.right), closest, currentClustId);
			mergeVec = null;
			
			// cluster ids that weren't in the original set are negative
			currentClustId -= 1;
			clust.remove(lowestPair.right);
			clust.remove(lowestPair.left);
			clust.add(newCluster);
		}
		System.out.println("");
		
		return clust.get(0);
	}
	
	public static void printKMClust(ArrayList<Integer>[] clust, String[] rowNames) {
		for (int i = 0; i < clust.length; i++) {
			Iterator<Integer> it = clust[i].iterator();
			while (it.hasNext()) {
				Integer num = it.next();
				System.out.println(rowNames[num]);
			}
			System.out.println("");
		}
	}
	
	public static void printHClust(Bicluster clust, String[] rowNames, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(" ");
		}
		if (clust.id < 0) {
			// negative id means that this is branch
			System.out.println("- " + clust.distance);
		} else {
			// positive id means that this is an endpoint
			if (rowNames == null) {
				System.out.println(clust.id);
			} else {
				System.out.println(rowNames[clust.id]);
			}
		}
		
		// now print the right and left branches
		if (clust.left != null) {
			printHClust(clust.left, rowNames, n + 1);
		}
		if (clust.right != null) {
			printHClust(clust.right, rowNames, n + 1);
		}
	}
}
