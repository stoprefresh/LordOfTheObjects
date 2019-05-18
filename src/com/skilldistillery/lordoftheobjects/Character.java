package com.skilldistillery.lordoftheobjects;

public class Character {
	protected int health;
	protected String name;
	protected boolean alive;
	protected boolean rangeWeapon;
	
	
	
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public boolean isRangeWeapon() {
		return rangeWeapon;
	}
	public void setRangeWeapon(boolean rangeWeapon) {
		this.rangeWeapon = rangeWeapon;
	}
	
//	public Character() {}
	
	
	
	

}
