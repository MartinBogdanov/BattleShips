package main;

import java.io.IOException;

import javax.swing.JPanel;

public class HorizontalAI extends BasicShip {

	public HorizontalAI(int size, Square block, JPanel activeZone)  {
		super(size, block);
		// TODO Auto-generated constructor stub
		shape = new AIsquare[1][size];
		for (int i = 0; i < size; i++) {
			shape[0][i] = new AIsquare(block.getX() + block.getSide() * i,
					block.getY(), block.getSide(), activeZone);
			shape[0][i].setFull(true);
		}
	}

	public void setLocation(int x, int y) {
		for (int i = 0; i < size; i++) {
			shape[0][i].setXY(x + block.getSide() * i, y);
		}

	}

}
