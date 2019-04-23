/**
 * 
 */
package com.terzeron.java.lcdisplay;

/**
 * @author terzeron
 *
 */
public class Number1 extends Number {
	public Number1(int size) {
		super(size);
	}
	
	public void draw() {
		drawRightTopVerticalLine();
		drawRightBottomVerticalLine();
	}
}
