package main;

import java.awt.Color;

import javax.swing.JPanel;

public class PlayerSquare extends ShipSquare {

	public PlayerSquare(int x, int y, int side, JPanel activeZone) {
		super(x, y, side, activeZone);
		isAi = false;
		this.color = new Color(0, 0, 0, 0);
		// TODO Auto-generated constructor stub
	}

}
