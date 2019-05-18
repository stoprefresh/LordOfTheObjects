package com.skilldistillery.lordoftheobjects;

public class HostileChar extends Character{

	private int enemyType;
	private String enemyIdent;
	
	


	public HostileChar(){
		
		name = "[Enemy:] ";
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
		name += "";
		
		
	}
	public void createAlien() {
		enemyIdent = " - Alien";
		name += "Unkown";
		
		
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
