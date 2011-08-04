package net.terzeron.app;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ClustersTest {

	private boolean compareIntegerArrayListArray(ArrayList<Integer>[] a, ArrayList<Integer>[] b) {
		if (a.length != b.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i].size() != b[i].size()) {
				return false;
			}
			for (int j = 0; j < a[i].size(); j++) {
				if (a[i].get(j) != b[i].get(j)) {
					System.out.println("diff at " + i);
					return false;
				}
			}
		}
		return true;
	}
	
	@Test
	public final void testMakeKMCluster() {
		double[][] rows = { { 9.0, 8.0, 6.0, 4.0 }, 
				{ 2.0, 5.0, 6.0, 0.0 }, { 7.0, 8.0, 9.0, 5.0 } };
		int k = 2;
		ArrayList<Integer>[] clust = Clusters.makeKMCluster(rows, k);
		ArrayList<Integer>[] resultClust = new ArrayList[2];
		ArrayList<Integer>tempList = new ArrayList<Integer>();
		tempList.add(0);
		tempList.add(1);
		tempList.add(2);
		tempList.add(0);
		tempList.add(1);
		tempList.add(2);
		resultClust[0] = tempList;
		resultClust[1] = new ArrayList<Integer>();
		Assert.assertTrue(compareIntegerArrayListArray(clust, resultClust));
	}
	
	private boolean compareBicluster(Bicluster a, Bicluster b) {
		if (a == null && b == null) {
			return true;
		}
		if (a.vec.length != b.vec.length) {
			return false;
		}
		for (int i = 0; i < a.vec.length; i++) {
			if (a.vec[i] != b.vec[i]) {
				return false;
			}
		}
		if (!compareBicluster(a.left, b.left)) {
			return false;
		}
		if (!compareBicluster(a.right, b.right)) {
			return false;
		}
		if (a.id != b.id) {
			return false;
		}
		if (a.distance != b.distance) {
			return false;
		}
		return true;
	}
	
	/*
	private void printBicluster(Bicluster a) {
		if (a == null) {
			return;
		}
		System.out.println(a.id + ": " + a.distance);
		for (int i = 0; i < a.vec.length; i++) {
			System.out.print(a.vec[i] + " ");
		}
		System.out.println("");
		if (a.left != null) {
			System.out.println(a.id + " -- Left --");
			printBicluster(a.left);
			System.out.println(a.id + " -- Left --");
		}
		if (a.right != null) {
			System.out.println(a.id + " -- Right --");
			printBicluster(a.right);
			System.out.println(a.id + " -- Right --");
		}
		if (a.left != null || a.right != null) {
			System.out.println("\n");
		}
	}
	*/

	@Test
	public final void testMakeHCluster() {
		double[][] rows = { { 9.0, 8.0, 6.0, 4.0 }, 
				{ 2.0, 5.0, 6.0, 0.0 }, { 7.0, 8.0, 9.0, 5.0 } };
		Bicluster bi = Clusters.makeHCluster(rows);
		double[] vec1 = { 5.0, 6.5, 6.75, 2.25 };
		double[] vec2 = { 8.0, 8.0, 7.5, 4.5 };
		Bicluster left = new Bicluster(rows[1], null, null, 1.0, 1);
		Bicluster rightLeft = new Bicluster(rows[0], null, null, 1.0, 0);
		Bicluster rightRight = new Bicluster(rows[2], null, null, 1.0, 2);
		Bicluster right = new Bicluster(vec2, rightLeft, rightRight, 0.0, -1);
		Bicluster resultBi = new Bicluster(vec1, left, right, 0.25, -2);
		Assert.assertTrue(compareBicluster(bi, resultBi));
	}
}
