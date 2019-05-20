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

		while (!game.getGameOver()) {

			game.gameTurn(kb, 0);

		}
		kb.close();
	}

}
