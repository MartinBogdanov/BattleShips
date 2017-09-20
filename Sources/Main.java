package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;



public class Main extends JPanel implements MouseListener, MouseMotionListener {

	private int sqSide;
	private Board myBoard;
	private Vector<Ship> allShips;
	private static Logic logic;
	private InGameMenu ingMenu;
	private int threeCount,twoHCount,fourCount;
	private AI enemy;
	
	public Main(){
		
		this.sqSide=40;
		this.threeCount=3;
		this.twoHCount=4;
		this.fourCount=2;
		allShips=new Vector(0);
		myBoard=new Board(8,8,10,10,sqSide,this);
		ingMenu=new InGameMenu(myBoard.getX()+10,myBoard.getY()+
				myBoard.getHeight()*myBoard.getSqSide()+10,
				myBoard.getWidth()*myBoard.getSqSide()/3,
				myBoard.getHeight()*myBoard.getSqSide()/10,this);
	
	   	 addMouseListener(this);
    	 addMouseMotionListener(this);
    	
    	 for(int i=0;i<fourCount;i++){
    	 allShips.addElement(new Four(new Square(10+i*sqSide,10,sqSide,this),this));
    	
      
    	 }
      	 for(int i=0;i<twoHCount;i++){
        	 allShips.addElement(new TwoBlockH(new PlayerSquare(10+i*sqSide,10,sqSide,this),this));
        	 }
     	 for(int i=0;i<threeCount;i++){
        	 allShips.addElement(new Three(new Square(10+i*sqSide,10,sqSide,this),this));
        	 }
  
    	 enemy=new AI(sqSide,myBoard,this,threeCount,twoHCount,fourCount);
      	 logic=new Logic(myBoard,allShips,ingMenu,enemy,this);

    	    	
         setPreferredSize(new Dimension(900, 900));
         
    	 
	}
	
    public static void main(String[] args){
   	 javax.swing.SwingUtilities.invokeLater(new Runnable() {
   		 
            public void run() {
            
                createAndShowGUI();
          
            }
        });
   	
   	 
   }

	  public void paintComponent(Graphics g)  {
		  super.paintComponent(g);
		  myBoard.draw(g);
		  for(Ship myShip:allShips){
			  myShip.draw(g);
			  }
		  enemy.draw(g);
		
		  ingMenu.draw(g);
		 logic.draw(g);
		
	  }
    
    private static void createAndShowGUI() { 
        JFrame frame = new JFrame("BattleShips");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      int frameW=1000;
      int frameH=1000;
        frame.setSize(frameW, frameH);
        frame.setVisible(true);
        //Create and set up the content pane.
        
        JComponent newContentPane = new Menu(frameW/3,100,300,50);

        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        //Display the window.
        frame.pack();
   
   
    }
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	} 
	

	
}
