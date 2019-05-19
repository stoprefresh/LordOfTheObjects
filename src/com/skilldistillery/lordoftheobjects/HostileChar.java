package com.skilldistillery.lordoftheobjects;

public class HostileChar extends Character{

	private int enemyType;
	private String enemyIdent;
	
	
	
	public HostileChar(){
		
		setName("[Enemy:]");
		enemyType = (int)Math.random() * 2;
		
		switch(enemyType) {
		
		case 1:
			createHuman();
			
			break;
		case 2:
			createAlien();
			
			break;
		default:
		
		}	
	}
	
	
	
	public void createHuman() {
		enemyIdent = " - Humanoid";
		setName(getName() + " Space Pirate" + enemyIdent);
		setOutputDamage(10);
		setHitChance(.6);
		
		
	}
	public void createAlien() {
		enemyIdent = " - Alien";
		setName(getName() + " Unkown" + enemyIdent);
		setOutputDamage(15);
		setHitChance(.4);
		
	}
	
	
	public int getEnemyType() {
		return enemyType;
	}
	
	
	public void setEnemyType(int enemyType) {
		this.enemyType = enemyType;
	}
	
	
	public String getEnemyIdent() {
		return enemyIdent;
	}
	
	
	public void setEnemyIdent(String enemyIdent) {
		this.enemyIdent = enemyIdent;
	}
}
