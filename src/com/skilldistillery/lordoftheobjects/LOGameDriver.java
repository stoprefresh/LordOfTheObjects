package com.skilldistillery.lordoftheobjects;

import java.util.Scanner;

public class LOGameDriver {

	public static void main(String[] args) {
		LOGameDriver prog = new LOGameDriver();
		prog.run();
	}
	
	public void run() {
		
		ShipGame game = new ShipGame();
		Scanner kb = new Scanner(System.in);
		game.playerCreate(kb);
		
		
		while(!game.getGameOver()) {
			
			game.generateRoom(game.getDifficutly());
			game.gameTurn(kb, 0);
			
			
			
		}
		kb.close();
	}
	
//	private void createPlayer(Scanner kb) {
//		System.out.println("Select your player: ");
//		System.out.println();
//	}
	
}
