package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import java.util.Vector;

public class AILogic implements MouseListener, MouseMotionListener {

	protected Board myBoard;
	protected Vector<BasicShip> allShips;
	
	public AILogic(Board myBoard, Vector<BasicShip> allShips) {
		this.allShips=allShips;
		this.myBoard = myBoard;
		
		for (BasicShip myShip : this.allShips) { 
			randomisePostion(myShip);
		}
		
	}
	


	public boolean isColliding(BasicShip myShip) {//is a ship colliding with the others

		for (BasicShip myShip2 : allShips) {
		
				for (Square[] i : myShip.getShape()) {
					for (Square j : i) {
						for (Square[] a : myShip2.getShape()) {
							for (Square b : a) {
								if (b.getX() == j.getX()
										&& b.getY() == j.getY() && b != j) {
									
									return true;
								}
							}
						}
					}
				}
			}

		
		return false;
	}

	public void randomisePostion(BasicShip myShip) {//gives a ship a random postion on the board

		for (Square[] i : myShip.getShape()) {
			
			for (Square j : i) {
				Random randomGenerator = new Random();
				do {
					int randomX = randomGenerator.nextInt(myBoard.getHeight());
					int randomY = randomGenerator.nextInt(myBoard.getWidth());
					myShip.setLocation(
							myBoard.getBoard()[randomX][randomY].getX(),
							myBoard.getBoard()[randomX][randomY].getY());

				} while (!myBoard.getFrame().contains(j.getShape())//while is not colliding and is in the board
						|| isColliding(myShip));
			}
		}

	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
