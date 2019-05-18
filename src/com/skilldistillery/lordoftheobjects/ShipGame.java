package com.skilldistillery.lordoftheobjects;

import java.util.Scanner;

public class ShipGame {
	private boolean gameOver;
	private int difficutly;
	private boolean playerTurn;
	private int turnCount;
	private Player playerOne;
	
	
	public ShipGame(boolean gameOver, boolean playerTurn, int turnCount) {
		this.gameOver = false;
		this.playerTurn = true;
		this.turnCount = 0;
		
	}
	
	public void playerCreate(Scanner input) {
		System.out.println("Welcome to the Game");
		System.out.println("Please enter your name: ");
		playerOne = new Player(input.nextLine());
		System.out.println("Please select a difficulty level(1-3): ");
		difficutly = input.nextInt();
		System.out.println(playerOne.toString());
		
	}
	

	

	public boolean isGameOver() {
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
	public boolean isPlayerTurn() {
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
