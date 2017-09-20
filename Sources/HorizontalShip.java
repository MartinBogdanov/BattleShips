package main;

import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JPanel;

public class HorizontalShip extends Ship {

	public HorizontalShip(int size, Square block, JPanel activeZone) {
		super(size, block, activeZone);
		shape = new PlayerSquare[1][size];
		for (int i = 0; i < size; i++) {
			shape[0][i] = new PlayerSquare(block.getX() + block.getSide() * i,
					block.getY(), block.getSide(), activeZone);
			// shape[0][i].setFull(true);

		}

	}

	public void setLocation(int x, int y) {
		for (int i = 0; i < size; i++) {
			shape[0][i].setXY(x + block.getSide() * i, y);
		}

	}

	public void setCenteredLocation(int x, int y) {
		for (int i = 0; i < size; i++) {
			if (size % 2 == 1) {
				shape[0][i].setXY(x - GetSize() * getBlock().getSide() / 2
						+ block.getSide() * i, y - getBlock().getSide() / 2);
			} else {
				shape[0][i].setXY(x - GetSize() * getBlock().getSide() / 2
						+ getBlock().getSide() / 2 + block.getSide() * i, y
						- getBlock().getSide() / 2);
			}

		}
	}

	public void setBoardLocation(int x, int y) {
		setCenteredLocation(x + block.getSide() / 2, y + block.getSide() / 2);

	}

	public void mouseMoved(MouseEvent e) {
		super.mouseMoved(e);
		if (isSelected() && isDragable()) {

			setCenteredLocation(e.getX(), e.getY());
		}
	}
}
