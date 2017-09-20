package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class InGameMenu implements MouseListener,
MouseMotionListener {
	
private Rectangle reset;
private Rectangle begin;
private boolean reseted;
private boolean started;
private int x,y,width,height,resX;
public InGameMenu(int x, int y, int width, int height, JPanel activeZone) {
	super();
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	resX=x+width+10;
	reset=new Rectangle(x,y,width,height,activeZone);
	begin=new Rectangle(resX,y,width,height,activeZone);
	activeZone.addMouseListener(this);
	activeZone.addMouseMotionListener(this);
	begin.setColor(Color.BLUE);
	reset.setColor(Color.BLUE);
}

public void draw(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	  g.setFont(new Font("",0,height/2));
	  
   
	  reset.draw(g);
	  g.drawString("Reset",x+width/4+width/10,y+height/2+height/5);
	  begin.draw(g);
	  g.drawString("Begin",resX+width/4+width/10,y+height/2+height/5);
}
@Override
public void mouseDragged(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseMoved(MouseEvent arg0) {
	// TODO Auto-generated method stub
	if(begin.isRolledOver()){
		
		begin.setColor(Color.GREEN);
	}else{
		begin.setColor(Color.BLUE);
	}
	if(reset.isRolledOver()){
		
		reset.setColor(Color.GREEN);
	}else{
		reset.setColor(Color.BLUE);
	}

}

public Rectangle getReset() {
	return reset;
}

public void setReset(Rectangle reset) {
	this.reset = reset;
}

public Rectangle getBegin() {
	return begin;
}

public void setBegin(Rectangle begin) {
	this.begin = begin;
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
	// TODO Auto-generated method stub
	if(begin.isRolledOver()){
		
		begin.setColor(Color.gray);
	}
	
	if(reset.isRolledOver()){
		
		reset.setColor(Color.gray);
	}
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub

		
		begin.setColor(Color.BLUE);
	
	
	
		
		reset.setColor(Color.BLUE);
	
	
}

public boolean isStarted() {
	return started;
}

public void setStarted(boolean started) {
	this.started = started;
}

public boolean isReseted() {
	return reseted;
}

public void setReseted(boolean reseted) {
	this.reseted = reseted;
}



}
