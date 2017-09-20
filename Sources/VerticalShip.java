package main;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class VerticalShip extends Ship {

	public VerticalShip(int size, Square block, JPanel activeZone) {
		super(size, block,activeZone);
		shape = new PlayerSquare[size][1];
		for (int i = 0; i < size; i++) {
			shape[i][0] = new PlayerSquare(block.getX(), block.getY()
					+ block.getSide() * i, block.getSide(),activeZone);
		//	shape[i][0].setFull(true);
		
		}
	}

	public void setLocation(int x, int y) {
		for (int i = 0; i < size; i++) {
			shape[i][0].setXY(x, y + block.getSide() * i);
;
		

		}
	}
	
	public void setCenteredLocation(int x, int y) {
		for (int i = 0; i < size; i++) {
			if(size%2==0){
				shape[i][0].setXY(x - getBlock().getSide() / 2, y- GetSize() * getBlock().getSide() / 2 + block.getSide() * i);
			}

			
			else{
				shape[i][0].setXY(x - getBlock().getSide() / 2, y- GetSize() * getBlock().getSide() / 2 + block.getSide() * i+getBlock().getSide() / 2);

			}

			}
	}
	public void setBoardLocation(int x, int y){
		
		setCenteredLocation(x+block.getSide()/2, y);
		
	}
	public void mouseMoved(MouseEvent e) {
		super.mouseMoved(e);
		if (isSelected()&&isDragable()) {
			if(size!=1){
			setCenteredLocation(e.getX(),e.getY());
			}else{
				setCenteredLocation(e.getX(),e.getY()-block.getSide()/2);
			}
		}
	}

}
