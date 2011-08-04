package net.terzeron.challenges.minesweeper;
/**
 * 
 */

/**
 * @author terzeron
 *
 */
public class MineField {
	private int n;
	private int m;
	
	private Square[][] mineField;

	public MineField(int n, int m) {
		this.n = n;
		this.m = m;
		mineField = new Square[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mineField[i][j] = new Square();
			}
		}
	}
	
	/**
	 * @return the n
	 */
	public int getN() {
		return n;
	}

	/**
	 * @return the m
	 */
	public int getM() {
		return m;
	}
	
	public boolean isMine(int i, int j) {
		return mineField[i][j].isMine();
	}
	
	public void putMine(int i, int j) {
		mineField[i][j].putMine();
	}
	
	public void incrementNearMineCount(int i, int j) {
		mineField[i][j].incrementNearMineCount();
	}
	
	public void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mineField[i][j].isMine()) {
					System.out.print("*");
				} else {
					System.out.print(mineField[i][j].getNearMineCount());
				}
			}
			System.out.println("");
		}
	}
}
