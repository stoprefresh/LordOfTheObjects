package com.skilldistillery.lordoftheobjects;

public class Character {
	protected int health;
	protected String name;
	protected boolean alive;
	private int stance;
//	protected Weapon weapon;
	
	

	public Character() {
		health = 100;
		alive = true;
		
	}
	public int getStance() {
		return stance;
	}
	
	public void setStance(int stance) {
		this.stance = stance;
	}
	
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
	
	
//	public Character() {}
	
	
	
	

}
