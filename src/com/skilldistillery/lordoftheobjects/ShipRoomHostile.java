package com.skilldistillery.lordoftheobjects;

public class ShipRoomHostile extends StarShip {

	private HostileChar[] activeHostile;
	private HostileChar newHostile;
	private boolean isSafe;

	public ShipRoomHostile(int difficulty) {
		if (isSafe == false) {
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
		} else {
			activeHostile = new HostileChar[0];
		}

	}

	public HostileChar[] getActiveHostile() {
		return activeHostile;
	}

	public void setActiveHostile(HostileChar[] activeHostile) {
		this.activeHostile = activeHostile;
	}

	public HostileChar getNewHostile() {
		return newHostile;
	}

	public void setNewHostile(HostileChar newHostile) {
		this.newHostile = newHostile;
	}

	public boolean getIsSafe() {
		return isSafe;
	}

	public void setIsSafe(boolean isSafe) {
		this.isSafe = isSafe;
	}

}
