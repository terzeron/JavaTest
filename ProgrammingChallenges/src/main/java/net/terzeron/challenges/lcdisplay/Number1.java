/**
 * 
 */
package net.terzeron.challenges.lcdisplay;

/**
 * @author terzeron
 *
 */
public class Number1 extends Number {
	public Number1(int size) {
		super(size);
	}
	
	public void draw() {
		drawRightTopVerticalLine();
		drawRightBottomVerticalLine();
	}
}
