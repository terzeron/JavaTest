package net.terzeron.app;

import org.junit.Assert;
import org.junit.Test;

public class BiclusterTest {

	@Test
	public final void testBiclusterDoubleArrayInteger() {
		double[] vec = { 1.0, 2.0, 3.0 };
		Integer id = 3;
		Bicluster bi = new Bicluster(vec, id);
		Assert.assertTrue(bi.vec == vec);
		Assert.assertTrue(bi.left == null);
		Assert.assertTrue(bi.right == null);
		Assert.assertTrue(bi.id == id);
		Assert.assertTrue(bi.distance == Bicluster.DEFAULT_DISTANCE);
	}

	@Test
	public final void testBiclusterDoubleArrayBiclusterBiclusterDoubleInteger() {
		double[] vec = { 1.0, 2.0, 3.0 };
		Integer id = 3;
		Bicluster left = new Bicluster(vec, 1);
		Bicluster right = new Bicluster(vec, 2);
		double distance = 0.5;
		Bicluster bi = new Bicluster(vec, left, right, distance, id);
		Assert.assertTrue(bi.vec == vec);
		Assert.assertTrue(bi.left == left);
		Assert.assertTrue(bi.right == right);
		Assert.assertTrue(bi.id == id);
		Assert.assertTrue(bi.distance == distance);
	}

}
