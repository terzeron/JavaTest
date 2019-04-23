package com.terzeron.java.minesweeper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author terzeron
 *
 */
public class FieldGenerator {
	private MineField mineField;
	
	public FieldGenerator(int n, int m) {
		mineField = new MineField(n, m);
	}
	
	public void initialize(String[] lines) {
		for (int i = 0; i < mineField.getN(); i++) {
			for (int j = 0; j < mineField.getM(); j++) {
				if (lines[i].charAt(j) == '*') {
					mineField.putMine(i, j);
				}
			}
		}
	}
	
	public void generate() {
		int n = mineField.getN();
		int m = mineField.getM();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mineField.isMine(i, j) == false) {
					// left
					if (j > 0 && mineField.isMine(i, j - 1)) {
						mineField.incrementNearMineCount(i, j);
					}
					// left-top
					if (j > 0 && i > 0 && mineField.isMine(i - 1, j - 1)) {
						mineField.incrementNearMineCount(i, j);
					}
					// top
					if (i > 0 && mineField.isMine(i - 1, j)) {
						mineField.incrementNearMineCount(i, j);
					}
					// top-right
					if (j < m - 1 && i > 0 && mineField.isMine(i - 1, j + 1)) {
						mineField.incrementNearMineCount(i, j);
					}
					// right
					if (j < m - 1 && mineField.isMine(i, j + 1)) {
						mineField.incrementNearMineCount(i, j);
					}
					// right-bottom
					if (j < m - 1 && i < n - 1 && mineField.isMine(i + 1, j + 1)) {
						mineField.incrementNearMineCount(i, j);
					}
					// bottom
					if (i < n - 1 && mineField.isMine(i + 1, j)) {
						mineField.incrementNearMineCount(i, j);
					}
					// bottom-left
					if (j > 0 && i < n - 1 && mineField.isMine(i + 1, j - 1)) {
						mineField.incrementNearMineCount(i, j);
					}
				}
			}
		}
	}
	
	public void print(int num) {
		System.out.println("Field #" + num + ":");
		mineField.print();
		System.out.println("");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int num = 1; true; num++) {
			// first line
			String line = in.readLine();
			String[] tokens = line.split(" ");
			int n = Integer.parseInt(tokens[0]);
			int m = Integer.parseInt(tokens[1]);
			if (n == 0 && m == 0) {
				break;
			}
			
			// next lines
			String[] lines = new String[n];
			for (int i = 0; i < n && (line = in.readLine()) != null; i++) {
				lines[i] = line;
			}
	
			FieldGenerator fieldGenerator = new FieldGenerator(n, m);
			fieldGenerator.initialize(lines);
			fieldGenerator.generate();
			fieldGenerator.print(num);
		}
	}
}
