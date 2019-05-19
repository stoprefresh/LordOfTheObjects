package com.skilldistillery.lordoftheobjects;

import java.util.Scanner;

public class ShipGame {
	private boolean gameOver;
	protected int difficutly;
	private boolean charHit;
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

	public void generateRoom(int difficulty) {
		double randomDiff = Math.random() * 100;

		switch (difficulty) {

		case 1:
			if (randomDiff < 25) {
				safeRoom = new ShipRoomSafe(difficulty);
				safeRoom.setIsSafe(true);
			} else {
				hostileRoom = new ShipRoomHostile(difficulty);
			}
			break;

		case 2:
			if (randomDiff < 20) {
				safeRoom = new ShipRoomSafe(difficulty);
				safeRoom.setIsSafe(true);
			} else {
				hostileRoom = new ShipRoomHostile(difficulty);
			}
			break;

		case 3:
			if (randomDiff < 15) {
				safeRoom = new ShipRoomSafe(difficulty);
				safeRoom.setIsSafe(true);
			} else {
				hostileRoom = new ShipRoomHostile(difficulty);
			}
			break;
		default:
			safeRoom = new ShipRoomSafe(difficulty);
			safeRoom.setIsSafe(true);
		}
	}

	public void gameTurn(Scanner kb) {
		turnCount = 0;
		int totalHostiles = hostileRoom.getActiveHostile().length;
		int playerChoice = 0;

		while (totalHostiles > 0) {
			playerChoice = playerChoiceFight(totalHostiles, kb);
			if (playerChoice == 1) {
				if (characterHit(playerOne.getHitChance())) {
					for (int i = 0; i < totalHostiles; i++) {
						if (hostileRoom.getActiveHostile()[i] != null) {
							hostileRoom.getActiveHostile()[i] = null;
							playerOne.setScore(1);
							System.out.println("Enemy killed");
							break;
						}
					}
				}
			}
		}
		while (playerChoice != 2 && safeRoom.getIsSafe() == true) {
			playerChoice = playerChoiceSafe(kb);
			if (playerChoice == 1) {
				System.out.println("Recharging shields");
				System.out.println("******************");
				playerOne.setShieldStr(100);
			}
		}
	}

	public boolean characterHit(double hitChance) {

		if (hitChance > (Math.random())) {
			charHit = true;
			System.out.println("Hit");
		} else {
			charHit = false;
			System.out.println("Miss");
		}
		return charHit;
	}

	public int playerChoiceSafe(Scanner kb) {
		System.out.println("The space is clear of hostiles.");
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("__________________________");
		System.out.println("1.{Re-charge shields}");
		System.out.println("2.{Exit}");

		int choiceSelection = kb.nextInt();

		return choiceSelection;
	}

	public int playerChoiceFight(int totalHostiles, Scanner kb) {

		System.out.println("There are currently " + totalHostiles + " hostiles in this room.");
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("__________________________");
		System.out.println("1.{Attack}");
		System.out.println("2.{Run}");
		int choiceSelection = kb.nextInt();

		return choiceSelection;
	}

	public void playerCreate(Scanner input) {
		System.out.println("Welcome to the Game");
		System.out.println("Please enter your name: ");
		playerOne = new Player(input.nextLine());
		System.out.println("Please select a difficulty level(1-3): ");
		difficutly = input.nextInt();
		System.out.println(playerOne.toString());
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public ShipRoomHostile getHostileRoom() {
		return hostileRoom;
	}

	public void setHostileRoom(ShipRoomHostile hostileRoom) {
		this.hostileRoom = hostileRoom;
	}

	public ShipRoomSafe getSafeRoom() {
		return safeRoom;
	}

	public void setSafeRoom(ShipRoomSafe safeRoom) {
		this.safeRoom = safeRoom;
	}

	public ShipEscapePod getEscapeRoom() {
		return escapeRoom;
	}

	public void setEscapeRoom(ShipEscapePod escapeRoom) {
		this.escapeRoom = escapeRoom;
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
