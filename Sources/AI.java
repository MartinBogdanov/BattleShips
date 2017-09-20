package main;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;

public class AI extends JPanel implements MouseListener, MouseMotionListener { 

	private int sqSide;
	private Board myBoard;
	private Vector<BasicShip> allShips;
	private int threeCount,twoHCount,fourCount;
	private AILogic logic;
	


public AI(int sqSide,Board myBoard,  JPanel activeZone,	int threeCount, int twoHCount, int fourCount) {
		super();
		this.sqSide=sqSide;
		this.threeCount=threeCount;this.twoHCount=twoHCount;
		this.fourCount=fourCount;
		this.myBoard = new Board(myBoard.getHeight() ,   
				myBoard.getWidth(),
				myBoard.getX()+myBoard.getSqSide()*myBoard.getWidth()+50, 
				myBoard.getY(),  
				sqSide,activeZone);
		
		 allShips=new Vector(0);
    	
    	 for(int i=0;i<fourCount;i++){
    	 allShips.addElement(new FourAI(new AIsquare(10+i*sqSide,10,sqSide,activeZone),activeZone));
    	 }
      	 for(int i=0;i<threeCount;i++){
        	 allShips.addElement(new ThreeAI(new AIsquare(10+i*sqSide,10,sqSide,activeZone),activeZone));
        	 }
       	 for(int i=0;i<twoHCount;i++){
        	 allShips.addElement(new TwoBlockHai(new AIsquare(10+i*sqSide,10,sqSide,activeZone),activeZone));
        	 }
		logic=new AILogic(this.myBoard,allShips);
		
	}

public int getSqSide() {
	return sqSide;
}

public void setSqSide(int sqSide) {
	this.sqSide = sqSide;
}

public Board getMyBoard() {
	return myBoard;
}

public void setMyBoard(Board myBoard) {
	this.myBoard = myBoard;
}

public Vector<BasicShip> getAllShips() {
	return allShips;
}

public void setAllShips(Vector<BasicShip> allShips) {
	this.allShips = allShips;
}



public AILogic getLogic() {
	return logic;
}

public void setLogic(AILogic logic) {
	this.logic = logic;
}

public void draw(Graphics g){
	 myBoard.draw(g);
	  for(BasicShip myShip:allShips){
		  myShip.draw(g);
		  }
		 
}



@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	
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
	
}
}
