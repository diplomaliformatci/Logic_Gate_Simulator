package MuhendislikProjesi;


import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Point;
import java.awt.Rectangle;


public class Board extends JPanel implements ActionListener{
	
	
	
	int mousePositionX , mousePositionY;
	int i = 0;
	JLabel label = new JLabel();
	
	int cableNum = 0; 
	static logicGate gateReferenceParameter1 = null;
	static logicGate gateReferenceParameter2 = null;
	
	
	boolean debugMode = true;
	boolean baseGate = false;
	andGate gate1 = new andGate( 50  , 100);
	orGate gate2 = new orGate( 50 , 250);
	notGate gate3 = new notGate(50 , 400);
	
	andGateExtra gate4 = new andGateExtra(50 , 500);
	
	orGateExtra  gate5 = new orGateExtra(50 , 600);
	
	inputBox gate6 = new inputBox(50 , 700);
	
	ledCircle gate7 = new ledCircle(50 , 800);
	
	Timer timer = new Timer(100 , this);
	
	boolean mouseln = false;
	logicGate gate;
	
	ArrayList<logicGate> logicArray = new ArrayList<logicGate>();
	ArrayList<logicGate> fixedArray = new ArrayList<logicGate>();
	ArrayList<cable> cableArray = new ArrayList<cable>();
	public Board() {
		label.setText("ToolBox");
		label.setSize(60, 60);
		label.setVisible(true);
		this.add(label);
		fixedArray.add(gate1);
		fixedArray.add(gate2);
		fixedArray.add(gate3);
		fixedArray.add(gate4);
		fixedArray.add(gate5);
		fixedArray.add(gate6);
		fixedArray.add(gate7);
		 addMouseMotionListener(new MyMouseAdapter());
	     addMouseListener(new MyMouseAdapter());
		timer.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setColor(new Color(255 ,255 ,255));
		g2d.fillRect(0, 0, 250, 1500);
		g2d.fillRect(255, 0, 1500, 1500);
		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.BLACK);
		g2d.drawLine(255, 0, 255, 1500);
		g2d.drawLine(0, 80, 255, 80);
		
		//gate1.paint(g);
		//gate2.paint(g);
		//gate3.paint(g);
		if (debugMode) {
			debugColors(g);
		} else {
			paintGates(g);
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
	}
	
	public void paintGates(Graphics g) {
		Graphics2D g2d  = (Graphics2D) g.create();
		
		for (logicGate temp: fixedArray) {
			temp.paint(g);
		}
		
		
		for (logicGate temp : logicArray) {
			temp.paint(g);
		}
	}
	
	
	public void debugColors(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.fillRect(mousePositionX, mousePositionY, 20, 20);
		
		i = 0;
		
		
		for (logicGate temp: fixedArray) {
			g2d.setColor(Color.blue);
			g2d.fill(temp.firstInputBounds);
			g2d.fill(temp.secondInputBounds);
			g2d.setColor(Color.yellow);
			g2d.fill(temp.bounds);
			g2d.setColor(Color.RED);
			g2d.fill(temp.outputBounds);
			g2d.setColor(Color.pink);
			g2d.fill(temp.thirdInputBounds);
			temp.paint(g);
		}
		
		
		
		for (logicGate temp : logicArray) {
			g2d.setColor(Color.blue);
			g2d.fill(temp.firstInputBounds);
			g2d.fill(temp.secondInputBounds);
			g2d.fill(temp.thirdInputBounds);
			g2d.setColor(Color.yellow);
			g2d.fill(temp.bounds);
			g2d.setColor(Color.RED);
			g2d.fill(temp.outputBounds);
			
			temp.paint(g);
			
			
		}
		
		
		for (cable temp : cableArray) {
			temp.paint(g);
			//System.out.println(temp.cableStartPositionX + "   "  + temp.cableEndPositionX + "  " + temp.cableStartPositionY + "  "  + temp.cableEndPositionY);
			//System.out.println(temp.inputGate.gatetype + "   "  + temp.outputGate.gatetype);
		}
		
		
		
		
		
	}
	
	public void drawLine() {
		
	}
	
	
	
	
	public static cable connectGates(logicGate gateReferenceParameter1 , logicGate gateReferenceParameter2) {//Parameter1 = Output  Parameter2= Input
			cable connectorCable = new cable();
			
			System.out.println("Gate Reference Parameter 1 In Methed : " + gateReferenceParameter1.toString());
			System.out.println("Gate Reference Parameter 2 In Method : " + gateReferenceParameter2.toString());
			System.out.println("Connect Gates Function Executed");
		if (gateReferenceParameter2.firstInputCable == null) {
			gateReferenceParameter2.firstInputCable = connectorCable;
			connectorCable.cableGoesNum = 1;
			System.out.println("First Cable Connected");
		} else if (gateReferenceParameter2.secondInputCable == null) {
			System.out.println("Second Cable Connected");
			gateReferenceParameter2.secondInputCable = connectorCable;
			connectorCable.cableGoesNum = 2;
		} else if (gateReferenceParameter2.gatetype == logicGate.gateType.andGateExtra ||
				gateReferenceParameter2.gatetype == logicGate.gateType.orGateExtra) {
				if (gateReferenceParameter2.thirdInputCable == null) {
					gateReferenceParameter2.thirdInputCable = connectorCable;
					connectorCable.cableGoesNum = 3;
				}
			
		} else {
			System.out.println("Cable cannot be Added");
			return null;
		}
		
		gateReferenceParameter1.outputCable = connectorCable;
		connectorCable.inputGate = gateReferenceParameter1;
		connectorCable.outputGate = gateReferenceParameter2;
//		cableArray.add(connectorCable);
		System.out.println("Connector Cable Coordinates: " + connectorCable.cableStartPositionX  + " "  + connectorCable.cableEndPositionX );
		System.out.println("Cable added to Gates OutputGate: " + gateReferenceParameter1.gatetype + " InputGate: " + gateReferenceParameter1.gatetype);
		return connectorCable;
	}
	
	
	
	 private class MyMouseAdapter extends MouseAdapter {

	        
		 	@Override
		 	public void mousePressed(MouseEvent e) {
		 		
		 		
		 		
		 		
		 	
		 		Rectangle mouseRect = new Rectangle(e.getX() - 5 , e.getY() - 5 , 10 , 10);
		 		
		 		
		 		for (logicGate temp : fixedArray) {
		 			if (mouseRect.intersects(temp.bounds)) {
		 				baseGate = true;
		 				switch (temp.gatetype) {
		 	            case andGate:
		 	            		gate = new andGate(e.getX() , e.getY());
		 	                logicArray.add(gate);
		 	                break;
		 	                    
		 	            case notGate:
		 	            		gate = new notGate(e.getX() , e.getY());
		 	            		logicArray.add(gate);
		 	            		break;
		 	                         
		 	            case orGate:
		 	            		gate =  new orGate(e.getX() , e.getY());
		 	            		logicArray.add(gate);
		 	                break;
		 	               
		 	            case orGateExtra:
		 	            		gate = new orGateExtra(e.getX() , e.getY());
		 	            		logicArray.add(gate);
		 	            		break;
		 	            	
		 	            case andGateExtra:
		 	            		gate = new andGateExtra(e.getX() , e.getY());
		 	            		logicArray.add(gate);
		 	            		break;
		 	            case inputBox:
		 	            		gate = new inputBox(e.getX() , e.getY() );
		 	            		logicArray.add(gate);
		 	            		break;
		 	            case ledCircle:
		 	            		gate = new ledCircle(e.getX() , e.getY());
		 	            		logicArray.add(gate);
		 	            		break;
		 	            		
		 	            default:
		 	            		break;
		 	            
		 				}
		 				
		 			}
		 		}
		 		
		 		if (baseGate) { // If Mouse selected item from fixed array then execute and Return
		 			mouseln = true;
		 			baseGate  = false;
		 			System.out.println(gate.gatetype);
		 			return;
		 		}
		 		
		 		for (logicGate temp : logicArray) { // if mouse selected item from logicArray execute and return
		 			if (mouseRect.intersects(temp.bounds)) {
		 				gate  = temp;
		 				if (gate.gatetype == logicGate.gateType.inputBox || gate.gatetype == logicGate.gateType.ledCircle) {
		 					System.out.println("gate Values : " + gate.inputValue + "  " + gate.inputValueString);
		 					if (gate.inputValue == false) {
		 						gate.inputValue = true;
		 						gate.inputValueString = "1";
		 						gate.configureGate();
		 						mouseln = false;
		 						return;
		 						
		 					} else {
		 						gate.inputValue = false;
		 						gate.inputValueString = "0";
		 						gate.configureGate();
		 						mouseln = false;
		 						return;
		 					}
		 				}
		 				
		 				mouseln = true;
		 				System.out.println("Gate Loaded");
		 				return;
		 			} 		 					
		 			 else if (mouseRect.intersects(temp.outputBounds)) {
		 				 if (gateReferenceParameter1 == null) {
		 					  gateReferenceParameter1 = temp;
		 					 System.out.println("Gate Reference 1 Loaded");
		 					 return;
		 				 }
		 			}
		 			 else if (mouseRect.intersects(temp.firstInputBounds) || 
		 					 mouseRect.intersects(temp.secondInputBounds) || // if mouse is in input bounds
		 					 mouseRect.intersects(temp.thirdInputBounds)) {
		 				 if (gateReferenceParameter2 == null) {
		 					 gateReferenceParameter2 = temp;
		 					 System.out.println("Gate Reference 2 Loaded");
		 					 return;
		 					 
		 					 
		 				 }
		 			 } 
		 			System.out.println("HEREEEE");
		 			if (gateReferenceParameter1 != null && gateReferenceParameter2 != null) {
		 				cable connectedCable = new cable();
		 				connectedCable = connectGates(gateReferenceParameter1 , gateReferenceParameter2); // REFERENCE1 = SENDING OUTPUT
		 				System.out.println("2 Parameter Not NULL");										// REFERENCE2 = GETTING INPUT
		 				if (connectedCable != null) {
		 					connectedCable.cableNum = cableNum;
		 					cableNum ++;
		 					cableArray.add(connectedCable);
		 					gateReferenceParameter1 = null;
		 					gateReferenceParameter2 = null;
		 					return;
		 				}
		 			}
		 			
		 		}
		 		
		 		mouseln = false; // no mouse event then stop shape events
		 		
		 	
		 	
		 	}
		 		
		 		
		 		
		 	
		 	
		 	@Override
		 	public void mouseDragged(MouseEvent e) {

		 	}
		 	
		 
		    @Override
	        public void mouseReleased(MouseEvent e) {
		    
	        }

	        @Override
	        public void mouseEntered(MouseEvent e) {
	        	
	        }

	        @Override
	        public void mouseMoved(MouseEvent e) {
	        	if (mouseln) {
	        		gate.positionX = e.getX() - 30;
	        		gate.positionY = e.getY() - 30;
	        		gate.configureGate();	
	        		//repaint();
	        		if (debugMode) {
	        			//System.out.println("GateMoving");
	        		}
	        	} else {
	        		if (debugMode) {
	        			//System.out.println("Gate Not Moving");
	        		}
	        	}
	        	
	        	
	        	}
	    }



	@Override
	public void actionPerformed(ActionEvent e) {
		for (cable temp : cableArray) {
			temp.configureCable();
			System.out.println(temp.toString());
		}
		
		for ( logicGate temp : logicArray) {
			temp.configureGate();
			//System.out.println(temp.toString());
		}
		repaint();
	}
	
	
	
	
	
	
	
	
	
}
