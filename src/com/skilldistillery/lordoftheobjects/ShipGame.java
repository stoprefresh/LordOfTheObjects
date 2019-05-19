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
	private ShipEscapePod escapeRoom;
	private HostileChar enemyChar;

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
				hostileRoom = new ShipRoomHostile(difficulty);
				hostileRoom.setIsSafe(true);
			} else {
				hostileRoom = new ShipRoomHostile(difficulty);
			}
			break;

		case 2:
			if (randomDiff < 20) {
				hostileRoom = new ShipRoomHostile(difficulty);
				hostileRoom.setIsSafe(true);
			} else {
				hostileRoom = new ShipRoomHostile(difficulty);
			}
			break;

		case 3:
			if (randomDiff < 15) {
				hostileRoom = new ShipRoomHostile(difficulty);
				hostileRoom.setIsSafe(true);
			} else {
				hostileRoom = new ShipRoomHostile(difficulty);
			}
			break;
		default:
			hostileRoom = new ShipRoomHostile(difficulty);
			hostileRoom.setIsSafe(true);
		}
	}

	public void gameTurn(Scanner kb, int count) {
		turnCount = 0;
		int playerChoice = 0;
		int totalHostiles = hostileRoom.getActiveHostile().length;

		if (playerOne.getScore() == 3) {
			System.out.println("You win!");
			gameOver = true;
		}
		if (count < totalHostiles) {
			playerChoice = playerChoiceFight(totalHostiles, kb);
			if (playerChoice == 1) {
				for (int i = 0 + count; i < totalHostiles; i++) {
					if (characterHit(playerOne.getHitChance(), hostileRoom.getActiveHostile()[i].getName())) {
						if (hostileRoom.getActiveHostile()[i] != null) {

							if (characterHit(hostileRoom.getActiveHostile()[i].getHitChance(),
							    playerOne.getName())) {
								System.out.println();
								System.out.println();
								turnCount++;

								if (playerOne.getShieldStr() <= 0) {
									playerOne.setHealth(hostileRoom.getActiveHostile()[i].getOutputDamage());
								} else {
									playerOne.setShieldStr(hostileRoom.getActiveHostile()[i].getOutputDamage());
								}
							}
							hostileRoom.getActiveHostile()[i] = null;
							playerOne.setScore(1);
							System.out.println("**************");
							System.out.println("*Enemy killed*");
							System.out.println("**************");
							
							count++;
							totalHostiles = totalHostiles - 1;
							gameTurn(kb, count);
						}

					} 
				}

			}
		}
		while (playerChoice != 2 && hostileRoom.getIsSafe() == true) {
			playerChoice = playerChoiceSafe(kb);
			if (playerChoice == 1) {
				System.out.println("Recharging shields");
				System.out.println("******************");
				playerOne.setShieldStr(100);
			}
		}

	}

	public boolean characterHit(double hitChance, String name) {

		if (hitChance > (Math.random())) {
			charHit = true;
			System.out.println();
			System.out.println(name + " has been Hit");
			System.out.println();
		} else {
			charHit = false;
			System.out.println();
			System.out.println(name + " was Missed");
			System.out.println();
		}
		return charHit;
	}

	public int playerChoiceSafe(Scanner kb) {
		System.out.println("The space is clear of hostiles.");
		System.out.println();
		System.out.println("Current Health: " + playerOne.getHealth());
		System.out.println("Current Shield: " + playerOne.getShieldStr());
		System.out.println("Current Score: " + playerOne.getScore());
		System.out.println("---------------------------------");
		System.out.println("What would you like to do?");
		System.out.println("__________________________");
		System.out.println("1.{Re-charge shields}");
		System.out.println("2.{Exit}");

		int choiceSelection = kb.nextInt();

		return choiceSelection;
	}

	public int playerChoiceFight(int totalHostiles, Scanner kb) {
		System.out.println();
		System.out.println("There are currently " + totalHostiles + " hostiles in this room.");
		System.out.println();
		System.out.println("Current Health: " + playerOne.getHealth());
		System.out.println("Current Shield: " + playerOne.getShieldStr());
		System.out.println("Current Score: " + playerOne.getScore());
		System.out.println("---------------------------------");
		System.out.println("What would you like to do?");
		System.out.println("__________________________");
		System.out.println("1.{Attack}");
		System.out.println("2.{Run}");
		int choiceSelection = kb.nextInt();
		System.out.println();
		System.out.println();
		return choiceSelection;
	}

	public void playerCreate(Scanner input) {
		System.out.println("Welcome to the Game");
		System.out.println("Please enter your name: ");
		playerOne = new Player(input.nextLine());
		System.out.println("Please select a difficulty level(1-3): ");
		difficutly = input.nextInt();
		System.out.println(playerOne.getName() + " be careful and attempt to exit the ship.");
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
