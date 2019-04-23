/**
 * 
 */
package com.terzeron.java.lcdisplay;

/**
 * @author terzeron
 *
 */
public class Number0 extends Number {
	public Number0(int size) {
		super(size);
	}
	
	public void draw() {
		drawTopHorizontalLine();
		drawLeftTopVerticalLine();
		drawRightTopVerticalLine();
		drawLeftBottomVerticalLine();
		drawRightBottomVerticalLine();
		drawBottomHorizontalLine();
	}
}
