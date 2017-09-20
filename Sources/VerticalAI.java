package main;

import javax.swing.JPanel;

public class VerticalAI extends BasicShip{
	
	public VerticalAI(int size, Square block, JPanel activeZone) {
		super(size, block);
		shape = new AIsquare[size][1];
		for (int i = 0; i < size; i++) {
			shape[i][0] = new AIsquare(block.getX(), block.getY()
					+ block.getSide() * i, block.getSide(),activeZone);
     	shape[i][0].setFull(true);
		}
	}

	public void setLocation(int x, int y) {
		for (int i = 0; i < size; i++) {
			shape[i][0].setXY(x, y + block.getSide() * i);
		

		}
	}
}
