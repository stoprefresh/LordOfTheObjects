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

		if (playerOne.getScore() == 6) {
			printEndGameMessage();
			gameOver = true;
		}
		if (count < totalHostiles) {
			playerChoice = playerChoiceFight(totalHostiles, kb);
			if (playerChoice == 1) {
				for (int i = 0 + count; i < totalHostiles; i++) {
					if (characterHit(playerOne.getHitChance(), hostileRoom.getActiveHostile()[i].getName())) {
						if (hostileRoom.getActiveHostile()[i] != null) {

							if (characterHit(.86,
							    playerOne.getName())) {
								System.out.println();
								System.out.println();
								turnCount++;

								if (playerOne.getShieldStr() <= 0) {
									playerOne.setHealth(20);
								} else {
									playerOne.setShieldStr(20);
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
				System.out.println("******************");
			}
		}

	}
	
	
	
	public void printEndGameMessage() {
		System.out.println();
		System.out.println();
		System.out.println("You've saved the ship from being overrun.");
		System.out.println();
		System.out.println("Unfortunately you were the only survivor.");
		System.out.println("With no hope for being saved, you pass out after watching");
		System.out.println("the life support systems fail.");
		System.out.println();
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
		System.out.println("______________________________");
		System.out.println("| What would you like to do? |");
		System.out.println("______________________________");
		System.out.println("1.{Re-charge shields}");
		System.out.println("2.{Exit}");
		int choiceSelection = kb.nextInt();
		System.out.println("__________________________________________");
		
		return choiceSelection;
	}

	public int playerChoiceFight(int totalHostiles, Scanner kb) {
		System.out.println("__________________________________________");
		System.out.println("You have entered a new section of the ship");
		System.out.println();
		System.out.println();
		System.out.println("There are currently " + totalHostiles + " hostiles in this room.");
		System.out.println();
		System.out.println("Current Health: " + playerOne.getHealth());
		System.out.println("Current Shield: " + playerOne.getShieldStr());
		System.out.println("Current Score: " + playerOne.getScore());
		System.out.println("______________________________");
		System.out.println("| What would you like to do? |");
		System.out.println("______________________________");
		System.out.println("         1.{Attack}");
		System.out.println("         2.{Run}");
		System.out.println("______________________________");
		int choiceSelection = kb.nextInt();
		System.out.println();
		System.out.println();
		return choiceSelection;
	}

	public void playerCreate(Scanner input) {
		System.out.println("**************************************");
		System.out.println("********* New message incoming *******");
		System.out.println("********* * * * * * * * * * * ********");
		System.out.println("**************************************");
		System.out.println("********* * * * * * * * * * * ********");
		System.out.println("**************************************");
		System.out.println("********* * * * * * * * * * * ********");
		System.out.println("**************************************");
		System.out.println("********* * * * * * * * * * * ********");
		System.out.println("**************************************");
		System.out.println("******** You are the only one ********");
		System.out.println("******** still picking up the ********");
		System.out.println("******** communications.      ********");
		System.out.println("**************************************");
		System.out.println("******** Your ship has been   ********");
		System.out.println("******** boarded by an unknown *******");
		System.out.println("******** amount of hostiles.  ********");
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("********  Enter your name so  ********");
		System.out.println("********  so our systems can  ********");
		System.out.println("******** track you.....  ...  ********");
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.print("                ");
		playerOne = new Player(input.nextLine());
		System.out.print("                ");
		System.out.println();     
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("******    Thank you " + playerOne.getName() + "   *********");
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("Please enter a difficulty level(1-3): ");
		difficutly = input.nextInt();
		System.out.println();
		System.out.println();
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("**** " + playerOne.getName() + " be careful and *****");
		System.out.println("******* attempt to save the  *********");
		System.out.println("********          ship........********");
		System.out.println("**************************************");
		System.out.println("****  There is an unknown number  ****");
		System.out.println("**** of enemies that have boarded ****");
		System.out.println("**** the ship...... .... .... ..******");
		System.out.println("**************************************");
		System.out.println("******  Do everything in your  *******");
		System.out.println("******   power to repel them.  *******");
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("******  Exiting Communications *******");
		System.out.println("**************************************");
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
