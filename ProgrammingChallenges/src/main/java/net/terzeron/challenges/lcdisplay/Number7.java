/**
 * 
 */
package net.terzeron.challenges.lcdisplay;

/**
 * @author terzeron
 *
 */
public class Number7 extends Number {
	public Number7(int size) {
		super(size);
	}
	
	public void draw() {
		drawTopHorizontalLine();
		drawRightTopVerticalLine();
		drawRightBottomVerticalLine();
	}
}
