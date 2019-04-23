/**
 * 
 */
package com.terzeron.java.lcdisplay;

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
