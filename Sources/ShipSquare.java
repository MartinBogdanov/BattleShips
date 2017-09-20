package main;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ShipSquare extends Square {

	protected boolean isAi;

	public ShipSquare(int x, int y, int side, JPanel activeZone) {
		super(x, y, side, activeZone);

	}

	public boolean isAi() {
		return isAi;
	}

	public void setAi(boolean isAi) {
		this.isAi = isAi;
	}
}
