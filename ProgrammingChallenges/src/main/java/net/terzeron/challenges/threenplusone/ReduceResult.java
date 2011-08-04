/**
 * 
 */
package net.terzeron.challenges.threenplusone;

/**
 * @author terzeron
 *
 */
public class ReduceResult {
	private int n;
	private int count;
	
	public ReduceResult(int n) {
		this.n = n;
		count = 0;
	}
	
	public int getCount() {
		return count;
	}
	
	public void incrementCount() {
		count++;
	}
	
	public int getN() {
		return n;
	}
	
	public void setN(int n) {
		this.n = n;
	}
}
