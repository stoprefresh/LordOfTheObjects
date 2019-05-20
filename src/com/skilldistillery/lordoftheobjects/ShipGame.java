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
	private int gameScore;

	public ShipGame() {
		gameOver = false;
		playerTurn = true;
		turnCount = 0;
	}

	public void generateRoom(int difficulty) {
		int randomDiff = (int) (Math.random() * 100);

		switch (difficulty) {

		case 1:
			gameScore = 2;
			if (randomDiff < 20) {
				hostileRoom = new ShipRoomHostile(difficulty);
				hostileRoom.setIsSafe(true);
			} else {
				hostileRoom = new ShipRoomHostile(difficulty);
			}
			break;

		case 2:
			gameScore = 3;
			if (randomDiff < 15) {
				hostileRoom = new ShipRoomHostile(difficulty);
				hostileRoom.setIsSafe(true);
			} else {
				hostileRoom = new ShipRoomHostile(difficulty);
			}
			break;

		case 3:
			gameScore = 6;
			if (randomDiff < 10) {
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
		hostileRoom.setRoomIdent("Bay 1-A");
		System.out.println(".........................................................");
		System.out.println(".........................................................");
		System.out.println("................You are now entering " + hostileRoom.getRoomIdent() + "..............");
		System.out.println(".........................................................");
		System.out.println(".........................................................");
	}

	public void gameTurn(Scanner kb, int count) {

		generateRoom(getDifficutly());

		int playerChoice = 0;
		int totalHostiles = hostileRoom.getActiveHostile().length;

		do {
			if (hostileRoom.getIsSafe() == false) {
				playerChoice = playerChoiceFight(totalHostiles, kb);
				if (playerChoice == 1) {
					engageRound(totalHostiles, count, kb, playerChoice);
				}
			}
			playerChoice = playerChoiceSafe(kb);

		} while (playerChoice != 2);

		if (playerOne.getScore() == gameScore) {
			printEndGameMessage();
			gameOver = true;
		}
	}

	// Game turn system to be restored.
//		while (playerOne.getScore() != gameScore) {
//		if (count < totalHostiles) {
//			playerChoice = playerChoiceFight(totalHostiles, kb);
//			if (playerChoice == 1) {
//				for (int i = 0 + count; i < totalHostiles; i++) {
//					if (characterHit(playerOne.getHitChance(), hostileRoom.getActiveHostile()[i].getName())) {
//						if (hostileRoom.getActiveHostile()[i] != null) {
//
//							if (characterHit(.86, playerOne.getName())) {
//								System.out.println();
//								System.out.println();
//								turnCount++;
//
//								if (playerOne.getShieldStr() <= 0) {
//									playerOne.setHealth(20);
//								} else {
//									playerOne.setShieldStr(playerOne.getShieldStr() - 20);
//								}
//							}
//							hostileRoom.getActiveHostile()[i] = null;
//							playerOne.setScore(1);
//							System.out.println("**************");
//							System.out.println("*Enemy killed*");
//							System.out.println("**************");
//							
//							count++;
//							totalHostiles = totalHostiles - 1;
//							gameTurn(kb, count);
//						}
//
//					} 
//				}
//
//			}
//		}
//		while (playerChoice != 2 && hostileRoom.getIsSafe() == true) {
//			playerChoice = playerChoiceSafe(kb);
//			if (playerChoice == 1) {
//				System.out.println("Recharging shields");
//				System.out.println("******************");
//				playerOne.setShieldStr(100);
//				System.out.println("******************");
//			}
//		}
//
//	}
	public void engageRound(int totalHostiles, int count, Scanner kb, int playerChoicePassed) {

		int playerChoice = playerChoicePassed;
		int i = 0 + count;

		while (totalHostiles != 0 && playerChoice != 2) {

			if (playerChoice == 1) {

				if (characterHit(playerOne.getHitChance(), hostileRoom.getActiveHostile()[i].getName())) {
					playerOne.setScore(1);
					System.out.println("**************");
					System.out.println("*Enemy killed*");
					System.out.println("**************");
					totalHostiles = totalHostiles - 1;
					count++;
//					hostileRoom.getActiveHostile()[i] = null;
				}
				if (totalHostiles > 0) {
					if (characterHit(.85, playerOne.getName())) {
						System.out.println();
						System.out.println();
						turnCount++;
						if (playerOne.getShieldStr() <= 0) {
							playerOne.setHealth(playerOne.getHealth() - 20);
						} else {
							playerOne.setShieldStr(playerOne.getShieldStr() - 20);
						}
					} else {
						System.out.println();
						System.out.println();
					}
				}
			}
			playerChoice = playerChoiceFight(totalHostiles, kb);
		}
	}

	public void printEndGameMessage() {
		System.out.println(".........................................................");
		System.out.println(".........................................................");
		System.out.println(".......You've saved the ship from being overrun..........");
		System.out.println(".........................................................");
		System.out.println("......Unfortunately you were the only survivor...........");
		System.out.println("With no hope for being saved, you pass out after watching");
		System.out.println(".......the life support systems fail.....................");
		playerOne.setHealth(0);
		playerOne.setShieldStr(0);
		System.out.println();
		System.out.println("     Current Health: " + playerOne.getHealth());
		System.out.println("     Current Shield: " + playerOne.getShieldStr());
		System.out.println(".........................................................");
		System.out.println(".........................................................");
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
		if (choiceSelection == 1) {
			System.out.println("Recharging shields");
			System.out.println("******************");
			playerOne.setShieldStr(100);
			System.out.println("******************");
		} 
		
		System.out.println("__________________________________________");

		return choiceSelection;
	}

	public int playerChoiceFight(int totalHostiles, Scanner kb) {
		System.out.println();
		System.out.println();
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
		System.out.println("\t**************************************");
		System.out.println("\t********* New message incoming *******");
		System.out.println("\t********* * * * * * * * * * * ********");
		System.out.println("\t**************************************");
		System.out.println("\t********* * * * * * * * * * * ********");
		System.out.println("\t**************************************");
		System.out.println("\t********* * * * * * * * * * * ********");
		System.out.println("\t**************************************");
		System.out.println("\t********* * * * * * * * * * * ********");
		System.out.println("\t**************************************");
		System.out.println("\t******** You are the only one ********");
		System.out.println("\t******** still picking up the ********");
		System.out.println("\t******** communications.      ********");
		System.out.println("\t**************************************");
		System.out.println("\t******** Your ship has been   ********");
		System.out.println("\t******** boarded by an unknown *******");
		System.out.println("\t******** amount of hostiles.  ********");
		System.out.println("\t**************************************");
		System.out.println("\t**************************************");
		System.out.println("\t********  Enter your name so  ********");
		System.out.println("\t********  so our systems can  ********");
		System.out.println("\t******** track you.....  ...  ********");
		System.out.println("\t**************************************");
		System.out.println("\t**************************************");
		System.out.print("\t..............");
		playerOne = new Player(input.nextLine());
		System.out.println("\t..............");
		System.out.println("\t\t..............");
		System.out.println("\t\t\t..............");
		System.out.println();
		System.out.println("\t**************************************");
		System.out.println("\t**************************************");
		System.out.println("\t******    Thank you " + playerOne.getName() + "   *********");
		System.out.println("\t**************************************");
		System.out.println("\t**************************************");
		System.out.println("\t**************************************");
		System.out.println("\tPlease enter a difficulty level(1-3): ");
		System.out.print("\t..............");
		difficutly = input.nextInt();
		System.out.println("\t..............");
		System.out.println("\t\t..............");
		System.out.println("\t\t\t..............");

		System.out.println();
		System.out.println("\t**************************************");
		System.out.println("\t**************************************");
		System.out.println("\t**** " + playerOne.getName() + " be careful and *****");
		System.out.println("\t******* attempt to save the  *********");
		System.out.println("\t********          ship........********");
		System.out.println("\t**************************************");
		System.out.println("\t****  There is an unknown number  ****");
		System.out.println("\t**** of enemies that have boarded ****");
		System.out.println("\t**** the ship...... .... .... ..******");
		System.out.println("\t**************************************");
		System.out.println("\t******  Do everything in your  *******");
		System.out.println("\t******   power to repel them.  *******");
		System.out.println("\t**************************************");
		System.out.println("\t**************************************");
		System.out.println("\t******  Exiting Communications *******");
		System.out.println("\t**************************************");
		System.out.println(".........................................................");
		System.out.println(".........................................................");
		System.out.println(".........................................................");
		System.out.println(".........................................................");
		System.out.println("................This is the ships 1MC....................");
		System.out.println(".............All personnel must now exit.................");
		System.out.println("................their personnel quarters.................");
		System.out.println(".........................................................");
		System.out.println(".........................................................");
		System.out.println(".........................................................");
		System.out.println(".........................................................");
		System.out.println("          " + playerOne.getName() + " *grabs blaster* and heads toward");
		System.out.println("          the hatch. Auto-locks disengage and " + playerOne.getName() + "   ");
		System.out.println("          steps through to the next compartment.    ");
		System.out.println(".........................................................");
		System.out.println(".........................................................");
		System.out.println(".........................................................");
		System.out.println(".........................................................");
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
