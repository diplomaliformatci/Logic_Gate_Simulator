package MuhendislikProjesi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;

import MuhendislikProjesi.logicGate.gateType;

public class andGate extends logicGate implements drawAble{
	
	
	
	
	public andGate(int positionX , int positionY) {
		super.positionX = positionX;
		super.positionY = positionY;
		super.width = 100;
		super.height = 100;
		
		super.gatetype = gateType.andGate;
		bounds = new Rectangle(positionX + 50 , positionY , 40 , 75);
		firstInputBounds = new Rectangle(positionX - 5  , positionY + 10  , 20 , 20);
		secondInputBounds = new Rectangle(positionX - 5 , positionY + 40 , 20, 20);
		outputBounds = new Rectangle(positionX + 140 , positionY + 25 , 20 , 20);
		System.out.println(firstInputBounds.toString());
		
		
		
		
		super.firstInputCableStartPositionX = super.positionX;
		super.firstInputCableStartPoisitionY = super.positionY + 20;
		super.outputCableStartPositionX = super.positionX + 150;
		super.outputCableStartPositionY = super.positionY + 70;
		

		
	}
	
	
	
	public void configureGate() {
		bounds = new Rectangle(positionX + 50 , positionY , 40 , 75);
		firstInputBounds = new Rectangle(positionX - 5  , positionY + 10  , 20 , 20);
		secondInputBounds = new Rectangle(positionX - 5 , positionY + 40 , 20, 20);
		outputBounds = new Rectangle(positionX + 140 , positionY + 25 , 20 , 20);
		super.firstInputCableStartPositionX = super.positionX;
		super.firstInputCableStartPoisitionY = super.positionY + 20;
		super.secondInputCableStartPositionX = super.positionX;
		super.secondInputCableStartPositionY = super.positionY + 50;
		super.outputCableStartPositionX = super.positionX + 150;
		super.outputCableStartPositionY = super.positionY + 35;
		
		if (this.firstInput != null && this.secondInput != null) {
			this.Output = calculateOutput();
		}
	}
	
	public void configureCable() {

	}

	
	
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.drawLine(positionX, positionY + 20, positionX + 50, positionY + 20); // first Input
		g2d.drawLine(positionX,positionY + 50, positionX + 50, positionY + 50); // Second Input
		g2d.drawLine(positionX + 50, positionY, positionX + 50, positionY + 70); // Gate horizontal
		//g2d.fillArc(120, 130, 110, 100, 5, 180);
		g2d.drawArc(positionX, positionY, 100, 70, 270, 180); // Gate Body
		g2d.drawLine(positionX + 100, positionY + 35, positionX +150, positionY + 35); // Gate Output
		
		
	}
	
	
	
	
	public boolean calculateOutput() {
		return this.firstInput && this.secondInput;
	}
	
}
