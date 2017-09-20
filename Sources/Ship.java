package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import java.awt.geom.*;

import javax.swing.JPanel;

import com.sun.javafx.geom.Vec2d;

public abstract class Ship extends BasicShip implements MouseListener,
		MouseMotionListener {

	protected boolean dragable;

	public Ship(int size, Square block, JPanel activeZone) {
		super(size, block);
		activeZone.addMouseListener(this);
		activeZone.addMouseMotionListener(this);
		dragable = true;

	}

	public abstract void setCenteredLocation(int x, int y);

	public abstract void setBoardLocation(int x, int y);

	public boolean isDragable() {
		return dragable;
	}

	public void setDragable(boolean dragable) {
		this.dragable = dragable;
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
		if (mouseOver && !selected) {
			selected = true;
		} else {
			selected = false;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		frame = new Rectangle2D.Float(shape[0][0].getX(), shape[0][0].getY(),
				shape[0][0].getSide(), shape[0][0].getSide());
		for (Square[] i : shape) {
			for (Square j : i) {
				frame.add(j.getShape());
			}
		}

		if (frame.contains(e.getX(), e.getY())) {
			mouseOver = true;

		} else {
			mouseOver = false;
		}

	}

	public Rectangle2D getFrame() {
		return frame;
	}

	public void setFrame(Rectangle2D frame) {
		this.frame = frame;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Square getBlock() {
		return block;
	}

	public void setBlock(Square block) {
		this.block = block;
	}

	public void setShape(PlayerSquare[][] shape) {
		this.shape = shape;
	}

	public int GetSize() {
		return size;
	}

	public void SetSize(int size) {
		this.size = size;
	}

	public boolean isMouseOver() {
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}

}
