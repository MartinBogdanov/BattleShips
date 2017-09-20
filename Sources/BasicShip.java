package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class BasicShip {
	protected int size;

	protected Square block;
	protected ShipSquare[][] shape;
	protected boolean mouseOver;
	protected boolean selected;
	protected Rectangle2D frame;
	
	public BasicShip(int size, Square block) {
		selected = false;
		mouseOver = false;
		this.block = block;
		this.size = size;
		frame = new Rectangle2D.Float(block.getX(),
				block.getY(), block.getSide(),
				block.getSide());

	}
	public void draw(Graphics g) {
		 
	     try {
	    	 
			BufferedImage 	image = ImageIO.read(new File(System.getProperty("user.dir")+"\\box.jpg"));
	
			Graphics2D g2d = (Graphics2D) g;
			
			RenderingHints hints = new RenderingHints(
					RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			hints.put(RenderingHints.KEY_RENDERING,
					RenderingHints.VALUE_RENDER_QUALITY);
			
			g2d.setRenderingHints(hints);
			
			for (ShipSquare[] i : shape) {
				for (ShipSquare j : i) {
					if(j.isAi()&&!j.isHit()){
					j.draw(g);

				}else{
					g2d.setClip(j.getShape());
					g.drawImage(image,j.x,j.y,j.getSide(),j.getSide(),null);
					g.setClip(null);
					j.draw(g);
				}
			}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public abstract void setLocation(int x, int y);
	public Square[][] getShape() {
		return shape;
	}

}
