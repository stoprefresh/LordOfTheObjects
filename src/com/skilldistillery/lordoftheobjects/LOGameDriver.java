package com.skilldistillery.lordoftheobjects;

import java.util.Scanner;

public class LOGameDriver {

	public static void main(String[] args) {
		LOGameDriver prog = new LOGameDriver();
		prog.run();
	}
	
	public void run() {
		
		ShipGame game = new ShipGame(false, true, 0);
		Scanner kb = new Scanner(System.in);
		game.playerCreate(kb);
		
		
		while(!game.isGameOver()) {
			
			
			
			
			
		}
	}
	
//	private void createPlayer(Scanner kb) {
//		System.out.println("Select your player: ");
//		System.out.println();
//	}
	
}
