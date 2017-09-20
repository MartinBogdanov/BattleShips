package main;

import java.util.Vector;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Board {
	private Square board[][];


	private Rectangle2D frame;

	private int height, width, x, y, sqSide;
	public Rectangle2D getFrame() {
		return frame;
	}

	public void setFrame(Rectangle2D frame) {
		this.frame = frame;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setBoard(Square[][] board) {
		this.board = board;
	}

	public Board(int height, int width, int x, int y, int sqSide,JPanel activeZone) {
		this.setSqSide(sqSide);
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		board = new Square[height][width];
		frame=new Rectangle2D.Float(x,y,sqSide*(width),sqSide*height);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j] = new Square(x + j * sqSide, y + i * sqSide, sqSide,activeZone);
			}
		}
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j].draw(g2d);
			}
		}
	}

	public Square[][] getBoard() {
		return board;
	}

	public int getSqSide() {
		return sqSide;
	}

	public void setSqSide(int sqSide) {
		this.sqSide = sqSide;
	}

}
