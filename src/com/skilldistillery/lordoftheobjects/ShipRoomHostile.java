package com.skilldistillery.lordoftheobjects;

public class ShipRoomHostile extends StarShip {

	private HostileChar[] activeHostile;
	private HostileChar newHostile;

	public ShipRoomHostile(int difficulty) {

		switch (difficulty) {
		case 1:
			activeHostile = new HostileChar[1 + (int) (Math.random() * 2)];
			for (int x = 0; x < activeHostile.length; x++) {
				newHostile = new HostileChar();
				activeHostile[x] = newHostile;
			}
			break;

		case 2:
			activeHostile = new HostileChar[1 + (int) (Math.random() * 3)];
			for (int x = 0; x < activeHostile.length; x++) {
				newHostile = new HostileChar();
				activeHostile[x] = newHostile;
			}
			break;

		case 3:
			activeHostile = new HostileChar[1 + (int) (Math.random() * 5)];
			for (int x = 0; x < activeHostile.length; x++) {
				newHostile = new HostileChar();
				activeHostile[x] = newHostile;
			}

			break;

		default:
		}

	}

}
