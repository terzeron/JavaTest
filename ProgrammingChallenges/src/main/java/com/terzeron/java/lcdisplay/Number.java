package com.terzeron.java.lcdisplay;

public abstract class Number {
	private int unitSize;
	private char[][] number;
	
	public Number(int unitSize) {
		this.unitSize = unitSize;
		number = new char[unitSize * 2 + 3][unitSize + 2];
		for (int i = 0; i < unitSize * 2 + 3; i++) {
			for (int j = 0; j < unitSize + 2; j++) {
				number[i][j] = ' ';
			}
		}
	}
	
	public int getSize() {
		return unitSize;
	}
	
	public void drawTopHorizontalLine() {
		for (int j = 1; j < unitSize + 1; j++) {
			number[0][j] = '-';
		}
	}
	
	public void drawMiddleHorizontalLine() {
		for (int j = 1; j < unitSize + 1; j++) {
			number[unitSize + 1][j] = '-';
		}
	}
	
	public void drawBottomHorizontalLine() {
		for (int j = 1; j < unitSize + 1; j++) {
			number[unitSize * 2 + 2][j] = '-';
		}
	}
	
	public void drawLeftTopVerticalLine() {
		for (int i = 1; i < unitSize + 1; i++) {
			number[i][0] = '|';
		}
	}
	
	public void drawRightTopVerticalLine() {
		for (int i = 1; i < unitSize + 1; i++) {
			number[i][unitSize + 1] = '|';
		}
	}
	
	public void drawLeftBottomVerticalLine() {
		for (int i = unitSize + 2; i < unitSize * 2 + 2; i++) {
			number[i][0] = '|';
		}
	}
	
	public void drawRightBottomVerticalLine() {
		for (int i = unitSize + 2; i < unitSize * 2 + 2; i++) {
			number[i][unitSize + 1] = '|';
		}
	}
	
	public abstract void draw();
	
	public void print() {
		for (int i = 0; i < unitSize * 2 + 3; i++) {
			for (int j = 0; j < unitSize + 2; j++) {
				System.out.print(number[i][j]);
			}
			System.out.println("");
		}
	}
	
	public void printOneLine(int rowNum) {
		for (int j = 0; j < unitSize + 2; j++) {
			System.out.print(number[rowNum][j]);
		}
	}
}
