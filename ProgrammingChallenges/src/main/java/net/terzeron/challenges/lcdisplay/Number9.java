/**
 * 
 */
package net.terzeron.challenges.lcdisplay;

/**
 * @author terzeron
 *
 */
public class Number9 extends Number {
	public Number9(int size) {
		super(size);
	}
	
	public void draw() {
		drawTopHorizontalLine();
		drawLeftTopVerticalLine();
		drawRightTopVerticalLine();
		drawMiddleHorizontalLine();
		drawRightBottomVerticalLine();
		drawBottomHorizontalLine();
	}
}
