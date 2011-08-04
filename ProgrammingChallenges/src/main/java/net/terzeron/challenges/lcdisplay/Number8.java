/**
 * 
 */
package net.terzeron.challenges.lcdisplay;

/**
 * @author terzeron
 *
 */
public class Number8 extends Number {
	public Number8(int size) {
		super(size);
	}
	
	public void draw() {
		drawTopHorizontalLine();
		drawLeftTopVerticalLine();
		drawRightTopVerticalLine();
		drawMiddleHorizontalLine();
		drawLeftBottomVerticalLine();
		drawRightBottomVerticalLine();
		drawBottomHorizontalLine();
	}
}
