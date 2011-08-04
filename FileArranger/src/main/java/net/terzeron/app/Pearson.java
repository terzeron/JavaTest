/**
 * 
 */
package net.terzeron.app;

/**
 * @author terzeron
 *
 */ 
public class Pearson {
	private static double getSum(double[] v) {
		double sum = 0.0;
		for (int i = 0; i < v.length; i++) {
			sum += v[i];
		}
		return sum;
	}

	private static double getSquareSum(double[] v) {
		double sum = 0.0;
		for (int i = 0; i < v.length; i++) {
			sum += Math.pow(v[i], 2);
		}
		return sum;
	}
	
	public static double getScore(double[] v1, double[] v2) {
		double sum1 = getSum(v1);
		double sum2 = getSum(v2);
		double sum1sq = getSquareSum(v1);
		double sum2sq = getSquareSum(v2);
		
		double productSum = 0.0;
		for (int i = 0; i < v1.length; i++) {
			productSum += v1[i] * v2[i];
		}
		
		double num = productSum - (sum1 * sum2 / v1.length);
		double den = Math.sqrt((sum1sq - Math.pow(sum1, 2) / v1.length) * (sum2sq - Math.pow(sum2, 2) / v1.length));
		
		if (den == 0.0) {
			return 0.0;
		}
		return 1.0 - num / den;
	}
}
