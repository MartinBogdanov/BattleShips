package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Square extends Rectangle {
	private int side;
	protected boolean isActive;
	protected boolean isHit;
	protected Color hitColor;

	public Square(int x, int y, int side, JPanel activeZone) {
		super(x, y, side, side, activeZone);
		this.side = side;
		isHit = false;
		hitColor = new Color(60, 0, 0, 100);
		setActive(false);
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (!isHit) {
			g2d.setColor(color);
			g2d.draw(rectangle);
			if (full) {
				g2d.fill(rectangle);

			}
		} else {
			g2d.setColor(hitColor);
			g2d.fill(rectangle);
		}
	}

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}