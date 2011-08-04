/**
 * 
 */
package net.terzeron.challenges.lcdisplay;

/**
 * @author terzeron
 *
 */
public class Number4 extends Number {
	public Number4(int size) {
		super(size);
	}
	
	public void draw() {
		drawLeftTopVerticalLine();
		drawRightTopVerticalLine();
		drawMiddleHorizontalLine();
		drawRightBottomVerticalLine();
	}
}
