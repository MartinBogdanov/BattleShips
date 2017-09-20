package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Rectangle implements MouseListener, MouseMotionListener {

	protected int x, y;
	protected int width;
	protected int height;
	protected Rectangle2D rectangle;
	protected Color color;
	protected boolean rolledOver;
	protected boolean full;

	public Rectangle(int x, int y, int width, int height, JPanel activeZone) {
		activeZone.addMouseListener(this);
		activeZone.addMouseMotionListener(this);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		rolledOver = false;
		rectangle = new Rectangle2D.Double(x, y, width, height);
		color = Color.RED;
		full = false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setXY(int x, int y) {
		this.y = y;
		this.x = x;
		rectangle = new Rectangle2D.Double(x, y, width, height);
	}

	public Rectangle2D getShape() {
		return this.rectangle;
	}

	public void setShape(Rectangle2D shape) {
		this.rectangle = shape;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(color);
		g2d.draw(rectangle);
		if (full) {
			g2d.fill(rectangle);

		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if (rectangle.contains(e.getX(), e.getY())) {

			rolledOver = true;
		} else {

			rolledOver = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		rolledOver = false;
	}

	public boolean isRolledOver() {
		return rolledOver;
	}

	public void setOver(boolean pressed) {
		this.rolledOver = pressed;
	}

	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

}