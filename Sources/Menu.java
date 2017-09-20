package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Menu extends JPanel implements MouseListener, MouseMotionListener{
	
private Rectangle start;
private Rectangle exit;
private int exY,x,y, width, height;


	public Menu(int x, int y, int width,int height) {
	super();
  	 addMouseListener(this);
	 addMouseMotionListener(this);

	  setPreferredSize(new Dimension(900, 600));
	  this.x=x;
	  this.y=y;
	  this.width=width;
	  this.height=height;
	  start=new Rectangle(x,y,width,height,this);
	  exY=3*y;
	  exit=new Rectangle(x,exY,width,height,this);
		start.setColor(Color.BLUE);
		exit.setColor(Color.BLUE);
	  	
	}

	  public void paintComponent(Graphics g)  {
		  super.paintComponent(g);	  
		  g.setFont(new Font("",0,height/2));
	      FontMetrics fm = getFontMetrics(new Font("",0,height/2));
		  start.draw(g);
		  g.drawString("Play",x+width/3+width/10,y+height/2+height/5);
		  exit.draw(g);
		  g.drawString("Exit",x+width/3+width/10,exY+height/2+height/5);
		  
	  }
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(start.isRolledOver()){
			
			start.setColor(Color.GREEN);
		}else{
			start.setColor(Color.BLUE);
		}
		if(exit.isRolledOver()){
			
			exit.setColor(Color.GREEN);
		}else{
			exit.setColor(Color.BLUE);
		}
		repaint();
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
		if(start.isRolledOver()){
			removeAll();
			add(new Main());
			revalidate(); 
			repaint();
		}else{
			
		}
		if(exit.isRolledOver()){
			System.exit(0);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	
}
