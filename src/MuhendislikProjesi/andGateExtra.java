package MuhendislikProjesi;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import MuhendislikProjesi.logicGate.gateType;

public class andGateExtra extends logicGate implements drawAble{

	public andGateExtra(int positionX , int positionY) {
		super.positionX = positionX;
		super.positionY = positionY;
		super.width = 100;
		super.height = 100;
		super.gatetype = gateType.andGateExtra;
		bounds = new Rectangle(positionX + 50 , positionY , 40 , 75);
		firstInputBounds = new Rectangle(positionX - 7 , positionY + 10  , 15 , 15); // NONE
		secondInputBounds = new Rectangle(positionX - 7 , positionY + 42 , 15 , 15);
		thirdInputBounds = new Rectangle(positionX - 7 , positionY + 29 , 10 , 10);
		outputBounds = new Rectangle(positionX + 140 , positionY + 33 , 20 , 20);
		System.out.println(firstInputBounds.toString());
		
	
		
		super.firstInputCableStartPositionX = super.positionX;
		super.firstInputCableStartPoisitionY = super.positionY + 20;
		super.outputCableStartPositionX = super.positionX + 150;
		super.outputCableStartPositionY = super.positionY + 35;
	
	
	}
	
	
	
	public void configureGate() {
		bounds = new Rectangle(positionX + 50 , positionY , 40 , 75);
		firstInputBounds = new Rectangle(positionX - 7 , positionY + 10  , 15 , 15); // NONE
		secondInputBounds = new Rectangle(positionX - 7 , positionY + 42 , 15 , 15);
		thirdInputBounds = new Rectangle(positionX - 7 , positionY + 29 , 10 , 10);
		outputBounds = new Rectangle(positionX + 140 , positionY + 25 , 20 , 20);

		super.firstInputCableStartPositionX = super.positionX;
		super.firstInputCableStartPoisitionY = super.positionY + 20;
		super.secondInputCableStartPositionX = super.positionX;
		super.secondInputCableStartPositionY = super.positionY + 35;
		super.thirdInputCableStartPositionX = super.positionX;
		super.thirdInputCableStartPositionY = super.positionY + 50;
		
		
		super.outputCableStartPositionX = super.positionX + 150;
		super.outputCableStartPositionY = super.positionY + 35;
		
		
		
		if (this.firstInput != null && this.secondInput != null && this.thirdInput != null) {
			this.Output = calculateOutput();
		}
		
		
	}
	

	
	
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.drawLine(positionX, positionY + 20, positionX + 50, positionY + 20); // first Input
		g2d.drawLine(positionX,positionY + 50, positionX + 50, positionY + 50); // Second Input
		g2d.drawLine(positionX, positionY + 35, positionX + 50, positionY + 35); // third Input
		g2d.drawLine(positionX + 50, positionY, positionX + 50, positionY + 70); // Gate horizontal
		//g2d.fillArc(120, 130, 110, 100, 5, 180);
		g2d.drawArc(positionX, positionY, 100, 70, 270, 180); // Gate Body
		g2d.drawLine(positionX + 100, positionY + 35, positionX +150, positionY + 35); // Gate Output
		
		
	}
	
	
	
	
	public boolean calculateOutput() {
		return this.firstInput && this.secondInput && this.thirdInput;
	}
	
}
