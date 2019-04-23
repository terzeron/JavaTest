package com.terzeron.java.minesweeper;
/**
 * 
 */

/**
 * @author terzeron
 *
 */
public class Square {
	private boolean isMine;
	private int nearMineCount;
	
	public Square() {
		isMine = false;
		nearMineCount = 0;
	}
	
	/**
	 * @return the isMine
	 */
	public boolean isMine() {
		return isMine;
	}

	/**
	 * @param isMine the isMine to set
	 */
	public void putMine() {
		this.isMine = true;
	}

	/**
	 * @return the nearMineCount
	 */
	public int getNearMineCount() {
		return nearMineCount;
	}

	public void incrementNearMineCount() {
		nearMineCount++;
	}
}
