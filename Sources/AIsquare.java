package main;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class AIsquare extends ShipSquare {

	public AIsquare(int x, int y, int side,JPanel activeZone) {
		super(x, y, side,activeZone);
		setAi(true);
		this.color= new Color(0,0,0,0);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void mousePressed(MouseEvent e) {
	if(rolledOver&&isActive){
		full=true;
		isHit=true;
		
	}
	}


}
