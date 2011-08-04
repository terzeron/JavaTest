/**
 * 
 */
package net.terzeron.challenges.lcdisplay;

/**
 * @author terzeron
 *
 */
public class Number3 extends Number {
	public Number3(int size) {
		super(size);
	}
	
	public void draw() {
		drawTopHorizontalLine();
		drawRightTopVerticalLine();
		drawMiddleHorizontalLine();
		drawRightBottomVerticalLine();
		drawBottomHorizontalLine();
	}
}
