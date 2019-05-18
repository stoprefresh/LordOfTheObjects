package com.skilldistillery.lordoftheobjects;

public class Player extends Character {

	
	private double shieldStr;
	private int score;
	private boolean win;
	private boolean instantKill;
	


	public Player(String name) {
		instantKill = true;
		this.name = name;
		shieldStr = 100;
	}
	
	
	
	public double getShieldStr() {
		return shieldStr;
	}
	public void setShieldStr(double shieldStr) {
		this.shieldStr = shieldStr;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isWin() {
		return win;
	}
	public void setWin(boolean win) {
		this.win = win;
	}
	
	
	
	
}
