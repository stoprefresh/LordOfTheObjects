package com.skilldistillery.lordoftheobjects;

public class Character {
	private int health;
	private String name;
	private boolean alive;
	private int stance;
	private int outputDamage;
	private double hitChance;
//	protected Weapon weapon;
	
	

	
	public Character() {
		health = 100;
		alive = true;
		
	}
	
	
	
	public int getOutputDamage() {
		return outputDamage;
	}

	public void setOutputDamage(int outputDamage) {
		this.outputDamage = outputDamage;
	}

	public double getHitChance() {
		return hitChance;
	}

	public void setHitChance(double hitChance) {
		this.hitChance = hitChance;
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
		this.health = this.health - health;
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
	
	

	
	
	
	

}
