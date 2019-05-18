package com.skilldistillery.lordoftheobjects;

public class Player extends Character {

	
	private double shieldStr;
	private int score;
	private boolean win;
	
	


	public Player(String name) {
		this.alive = true;
		this.health = 100;
		this.name = name;
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
