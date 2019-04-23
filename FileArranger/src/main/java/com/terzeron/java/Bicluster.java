/**
 * 
 */
package com.terzeron.java;

/**
 * @author terzeron 
 *
 */
public class Bicluster {
	public double[] vec;
	public Bicluster left;
	public Bicluster right;
	public double distance;
	public Integer id;
	public static final double DEFAULT_DISTANCE = 1.0;
	
	public Bicluster(double[] vec, Integer id) {
		this.left = null;
		this.right = null;
		this.vec = vec;
		this.id = id;
		this.distance = DEFAULT_DISTANCE;
	}
	public Bicluster(double[] vec, Bicluster left, Bicluster right, double distance, Integer id) {
		this.left = left;
		this.right = right;
		this.vec = vec;
		this.id = id;
		this.distance = distance;
	}
}
