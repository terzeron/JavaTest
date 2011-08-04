/**
 * 
 */
package net.terzeron.challenges.lcdisplay;

/**
 * @author terzeron
 *
 */
public class Number2 extends Number {
	public Number2(int size) {
		super(size);
	}
	
	public void draw() {
		drawTopHorizontalLine();
		drawRightTopVerticalLine();
		drawMiddleHorizontalLine();
		drawLeftBottomVerticalLine();
		drawBottomHorizontalLine();
	}
}
