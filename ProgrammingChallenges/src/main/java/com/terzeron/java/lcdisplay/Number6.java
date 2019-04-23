/**
 * 
 */
package com.terzeron.java.lcdisplay;

/**
 * @author terzeron
 *
 */
public class Number6 extends Number {
	public Number6(int size) {
		super(size);
	}
	
	public void draw() {
		drawTopHorizontalLine();
		drawLeftTopVerticalLine();
		drawMiddleHorizontalLine();
		drawLeftBottomVerticalLine();
		drawRightBottomVerticalLine();
		drawBottomHorizontalLine();
	}
}
