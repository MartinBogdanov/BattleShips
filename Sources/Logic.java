package main;

import java.awt.ActiveEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.Random;
import java.util.Vector;

import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Logic implements MouseListener, MouseMotionListener {

	private Board myBoard;
	private Vector<Ship> allShips;
	private InGameMenu ingMenu;
	private AI enemy;
	private boolean iWon, enemyWon;

	public Logic(Board myBoard, Vector<Ship> allShips, InGameMenu ingMenu,
			AI enemy, JPanel activeZone) {
		iWon = false;
		enemyWon = false;
		this.myBoard = myBoard;
		this.allShips = allShips;
		for (Ship myShip : allShips) {
			randomisePostion(myShip);
		}
		this.ingMenu = ingMenu;
		this.enemy = enemy;
		activeZone.addMouseMotionListener(this);
		activeZone.addMouseListener(this);

	}

	public boolean isColliding(Ship myShip) {// is a ship colliding with the
												// others

		for (Ship myShip2 : allShips) {
			if (!myShip.isSelected() && !myShip2.isSelected()) {
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

		}
		return false;
	}

	public void randomisePostion(Ship myShip) {// gives a ship a random postion
												// on the board

		for (Square[] i : myShip.getShape()) {

			for (Square j : i) {
				Random randomGenerator = new Random();
				do {
					int randomX = randomGenerator.nextInt(myBoard.getHeight());
					int randomY = randomGenerator.nextInt(myBoard.getWidth());
					myShip.setLocation(
							myBoard.getBoard()[randomX][randomY].getX(),
							myBoard.getBoard()[randomX][randomY].getY());

				} while (!myBoard.getFrame().contains(j.getShape())// while is
																	// not
																	// colliding
																	// and is in
																	// the board
						|| isColliding(myShip));
			}
		}

	}

	public void outOfBounds(Ship myShip) {

		for (Square[] i : myShip.getShape()) {// makes sure it stays in the
												// board
			for (Square j : i) {
				Random randomGenerator = new Random();
				while (!myBoard.getFrame().contains(j.getShape())
						|| isColliding(myShip)) {
					int randomX = randomGenerator.nextInt(myBoard.getHeight());
					int randomY = randomGenerator.nextInt(myBoard.getWidth());
					myShip.setLocation(
							myBoard.getBoard()[randomX][randomY].getX(),
							myBoard.getBoard()[randomX][randomY].getY());
				}
			}
		}

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void draw(Graphics g) {

		if (iWon) {
			g.setColor(Color.GREEN);
			g.setFont(new Font("", 0, 30));
			g.drawString("You Won", myBoard.getX() + myBoard.getWidth()
					* myBoard.getSqSide() - 20,
					myBoard.getY() + myBoard.getHeight() * myBoard.getSqSide()
							+ 40);
		}
		if (enemyWon) {
			g.setColor(Color.RED);
			g.setFont(new Font("", 0, 30));
			g.drawString("Enemy Won", myBoard.getX() + myBoard.getWidth()
					* myBoard.getSqSide() - 20,
					myBoard.getY() + myBoard.getHeight() * myBoard.getSqSide()
							+ 40);
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		GameOver();

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
	public void mousePressed(MouseEvent e) {


		if (iWon) {
			reset();
			iWon = false;
		}
		if (enemyWon) {
			reset();
			enemyWon = false;
		}
		for (Ship myShip : allShips) {
			if (myShip.isMouseOver() && !myShip.isSelected()
					&& myShip.isDragable()) {// drop

				for (int i = 0; i < myBoard.getHeight(); i++) {
					for (int j = 0; j < myBoard.getWidth(); j++) {
						if (myBoard.getBoard()[i][j].isRolledOver()) {
							System.out.println("DADADADA");
							int x = myBoard.getBoard()[i][j].getX();
							int y = myBoard.getBoard()[i][j].getY();
							myShip.setBoardLocation(x, y);
						}
					}
				}
				outOfBounds(myShip);

			}

		}

		if (ingMenu.getBegin().isRolledOver()) {// start playing vs enemy

			ingMenu.setStarted(true);
			for (Ship myShip : allShips) {
				myShip.setDragable(false);
			}
			for (BasicShip currShip : enemy.getAllShips()) {
				for (Square[] i : currShip.getShape()) {
					for (Square j : i) {
						j.setActive(true);

					}
				}
			}

		}

		if (ingMenu.getReset().isRolledOver()) {
			reset();
		}

		if (ingMenu.isStarted()) {
			if (enemy.getMyBoard().getFrame().contains(e.getX(), e.getY())) {// hit
																				// on
																				// enemy
																				// b
				boolean isNotHit = false;// chekcs if a square is already hit
				for (Square[] i : enemy.getMyBoard().getBoard()) {
					for (Square j : i) {
						if (j.isRolledOver() && !j.isHit()) {
							j.setHit(true);
							isNotHit = true;
						}

					}
				}
				if (isNotHit) {
					// hit plyerbaord
					Random randomGenerator = new Random();
					Random randomGenerator2 = new Random();
					int randomX = randomGenerator.nextInt(myBoard.getHeight());
					int randomY = randomGenerator2.nextInt(myBoard.getWidth());

					while (myBoard.getBoard()[randomX][randomY].isHit()) {
						randomX = randomGenerator.nextInt(myBoard.getHeight());
						randomY = randomGenerator2.nextInt(myBoard.getWidth());

					}
					myBoard.getBoard()[randomX][randomY].setHit(true);
					isMyShipHit(myBoard.getBoard()[randomX][randomY]);
				}
			}
		}
	}

	public void isMyShipHit(Square square) {
		for (Ship myShip : allShips) {
			for (Square[] i : myShip.getShape()) {
				for (Square j : i) {
					if (j.getX() == square.getX() && j.getY() == square.getY()) {
						j.setHit(true);
					}
				}
			}
		}
	}

	private void reset() {

		for (Ship myShip : allShips) {// reset player ship
			for (Square[] i : myShip.getShape()) {
				for (Square j : i) {
					j.setHit(false);
				}
			}
			randomisePostion(myShip);
			myShip.setDragable(true);
		}

		for (BasicShip currShip : enemy.getAllShips()) {// reset ai ship
			enemy.getLogic().randomisePostion(currShip);
			for (Square[] i : currShip.getShape()) {
				for (Square j : i) {

					j.setActive(false);
					j.setHit(false);
					j.setColor(new Color(0, 0, 0, 0));

				}
			}
		}
		for (Square[] i : myBoard.getBoard()) {
			for (Square j : i) {
				j.setHit(false);
			}
		}
		for (Square[] i : enemy.getMyBoard().getBoard()) {
			for (Square j : i) {
				j.setHit(false);
			}
		}
		ingMenu.setReseted(false);
		ingMenu.setStarted(false);

	}

	private void GameOver() {
		iWon = true;
		enemyWon = true;
		for (Ship myShip : allShips) {
			for (Square[] i : myShip.getShape()) {
				for (Square j : i) {
					if (!j.isHit()) {
						enemyWon = false;
					}
				}
			}
		}
		for (BasicShip myShip : enemy.getAllShips()) {
			for (Square[] i : myShip.getShape()) {
				for (Square j : i) {
					if (!j.isHit()) {
						iWon = false;

					}
				}
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

		// TODO Auto-generated method stub

	}

}
