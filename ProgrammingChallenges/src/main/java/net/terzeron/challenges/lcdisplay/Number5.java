/**
 * 
 */
package net.terzeron.challenges.lcdisplay;

/**
 * @author terzeron
 *
 */
public class Number5 extends Number {
	public Number5(int size) {
		super(size);
	}
	
	public void draw() {
		drawTopHorizontalLine();
		drawLeftTopVerticalLine();
		drawMiddleHorizontalLine();
		drawRightBottomVerticalLine();
		drawBottomHorizontalLine();
	}
}
