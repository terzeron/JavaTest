/**
 * 
 */
package com.terzeron.java.lcdisplay;

/**
 * @author terzeron
 *
 */
public class Display {
	public static void print(Number[] numberArr, int size) {
		for (int i = 0; i < size * 2 + 3; i++) {
			for (int k = 0; k < numberArr.length; k++) {
				numberArr[k].printOneLine(i);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		char c;
		int size = 2;
		Number x = null;
		//char[] numberCharArr = {'1', '2', '3', '4', '5'};
		char[] numberCharArr = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
		int length = numberCharArr.length;
		Number[] numberArr = new Number[length];

		for (int i = 0; i < length; i++) {
			c = numberCharArr[i];
			switch (c) {
			case '1':
				x = new Number1(size);
				break;
			case '2':
				x = new Number2(size);
				break;
			case '3':
				x = new Number3(size);
				break;
			case '4':
				x = new Number4(size);
				break;
			case '5':
				x = new Number5(size);
				break;
			case '6':
				x = new Number6(size);
				break;
			case '7':
				x = new Number7(size);
				break;
			case '8':
				x = new Number8(size);
				break;
			case '9':
				x = new Number9(size);
				break;
			case '0':
				x = new Number0(size);
				break;
			}
			x.draw();
			numberArr[i] = x;
		}
		
		print(numberArr, size);
	}
}
