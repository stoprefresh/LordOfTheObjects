package com.skilldistillery.lordoftheobjects;

import java.util.Scanner;

public class ShipGame {
	private boolean gameOver;
	private int difficutly;
	private boolean playerTurn;
	private int turnCount;
	private Player playerOne;
	private ShipRoomHostile hostileRoom;
	private ShipRoomSafe safeRoom;
	private ShipEscapePod escapeRoom;
	
	public ShipGame() {
		gameOver = false;
		playerTurn = true;
		turnCount = 0;
	}
	
	public void playerCreate(Scanner input) {
		System.out.println("Welcome to the Game");
		System.out.println("Please enter your name: ");
		playerOne = new Player(input.nextLine());
		System.out.println("Please select a difficulty level(1-3): ");
		difficutly = input.nextInt();
		System.out.println(playerOne.toString());
		
	}
	
	

	public void generateRoom(int difficulty) {
		double randomDiff = Math.random() * 100;
		
		switch(difficulty) {
		
		case 1:
			if(randomDiff < 25) {
				safeRoom = new ShipRoomSafe();
			}
			else {
				hostileRoom = new ShipRoomHostile();
			}
			break;
		case 2:
			if (randomDiff < 20) {
				safeRoom = new ShipRoomSafe();
			}
			else {
				hostileRoom = new ShipRoomHostile();
			}
			break;
		case 3:
			if (randomDiff < 15) {
				safeRoom = new ShipRoomSafe();
			}
			else {
				hostileRoom = new ShipRoomHostile();
			}
			break;
			default:
				safeRoom = new ShipRoomSafe();
		}
	}
	
	
	

	public boolean getGameOver() {
		return gameOver;
	}
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	public int getDifficutly() {
		return difficutly;
	}
	public void setDifficutly(int difficutly) {
		this.difficutly = difficutly;
	}
	public boolean getPlayerTurn() {
		return playerTurn;
	}
	public void setPlayerTurn(boolean playerTurn) {
		this.playerTurn = playerTurn;
	}
	public int getTurnCount() {
		return turnCount;
	}
	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
