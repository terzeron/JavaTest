/**
 * 
 */
package net.terzeron.app;

/**
 * @author terzeron
 *
 */
public class Tanamoto {
	public static double getScore(double[] a, double[] b) {
		int c1 = 0;
		int c2 = 0;
		int shr = 0;
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0.0) {
				c1 += 1;
			}
			if (b[i] != 0.0) {
				c2 += 1;
			}
			if (a[i] != 0.0 && b[i] != 0.0) {
				shr += 1;
			}
		}
		
		if (c1 == 0 && c2 == 0 && shr == 0) {
			return 1.0;
		}
		
		return (1.0 - ((double) shr / (c1 + c2 - shr)));
	}
}
