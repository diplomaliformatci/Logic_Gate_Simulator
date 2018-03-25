package MuhendislikProjesi;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import MuhendislikProjesi.logicGate.gateType;

public class inputBox extends logicGate implements drawAble{
	
	
	public inputBox(int positionX , int positionY) {
		super.positionX = positionX;
		super.positionY = positionY;
		super.width = 50;
		super.height = 50;
		super.gatetype = gateType.inputBox;
		super.inputValueString = "0";
		bounds = new Rectangle(positionX + 5, positionY + 5, width - 10 , height - 10);
		firstInputBounds = new Rectangle(positionX - 25, positionY + 20  , 10 , 10);
		outputBounds = new Rectangle(positionX + 70 , positionY + 20 , 10, 10);
		System.out.println(firstInputBounds.toString());
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setStroke(new BasicStroke(3));
		 g2d.drawRect(positionX, positionY, width, height);
		 g2d.drawLine(positionX - 20, positionY + height / 2, positionX, positionY + height / 2); // Inpout Line
		 g2d.drawLine(positionX + width, positionY + height / 2, positionX + width + 20, positionY + height / 2 ); // output Line
		 g2d.drawString(inputValueString, positionX + width / 2, positionY + width / 2);
		 
	}
	
	public void configureGate() {
		bounds = new Rectangle(positionX + 5, positionY + 5, width - 10 , height - 10);
		firstInputBounds = new Rectangle(positionX - 25, positionY + 20  , 10 , 10);
		outputBounds = new Rectangle(positionX + 70 , positionY + 20 , 10, 10);
		outputCableStartPositionX = positionX + width + 20;
		outputCableStartPositionY = positionY + height / 2;
	
		System.out.println(inputValueString + "   " + inputValue);
	}
	
	
}
