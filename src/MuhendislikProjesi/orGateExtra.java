package MuhendislikProjesi;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import MuhendislikProjesi.logicGate.gateType;

public class orGateExtra extends logicGate implements drawAble{
	int tempX = positionX + 50;
	int tempY = positionY + 70;
	
	
	
	public orGateExtra(int positionX ,  int positionY) {
		super.positionX = positionX;
		super.positionY = positionY;
		super.width = 100;
		super.height = 100;
		super.gatetype = gateType.orGateExtra;
		bounds = new Rectangle(positionX  + 50, positionY , 50 , 50);
		firstInputBounds = new Rectangle(positionX - 7 , positionY + 2  , 15 , 15); // NONE
		secondInputBounds = new Rectangle(positionX - 7 , positionY + 34 , 15 , 15);
		outputBounds = new Rectangle(positionX + 140 , positionY + 15 , 20 , 20);
		thirdInputBounds = new Rectangle(positionX - 7 , positionY + 21 , 10 , 10);
		outputBounds = new Rectangle(positionX + 140 , positionY + 15 , 20 , 20);
		System.out.println(firstInputBounds.toString());
	}
	
	
	public void configureGate() {
		bounds = new Rectangle(positionX  + 50, positionY , 50 , 50);
		firstInputBounds = new Rectangle(positionX - 7 , positionY + 2  , 15 , 15); // NONE
		secondInputBounds = new Rectangle(positionX - 7 , positionY + 34 , 15 , 15);
		outputBounds = new Rectangle(positionX + 140 , positionY + 15 , 20 , 20);
		thirdInputBounds = new Rectangle(positionX - 7 , positionY + 21 , 10 , 10);
		
		super.firstInputCableStartPositionX = super.positionX;
		super.firstInputCableStartPoisitionY = super.positionY + 10;
		super.secondInputCableStartPositionX = super.positionX;
		super.secondInputCableStartPositionY = super.positionY + 40;
		super.thirdInputCableStartPositionX = super.positionX;
		super.thirdInputCableStartPositionY = super.positionY + 25;
		
		
		super.outputCableStartPositionX = super.positionX + 150;
		super.outputCableStartPositionY = super.positionY + 35;
		
		if (this.firstInput != null && this.secondInput != null && this.thirdInput != null) {
			this.Output = calculateOutput();
		}
		
	}
	
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.drawLine(positionX, positionY + 10, positionX + 55, positionY + 10 ); // first Input
		g2d.drawLine(positionX,positionY + 40, positionX + 55, positionY +  + 40); // Second Input
		g2d.drawLine(positionX, positionY + 25, positionX + 60, positionY + 25); //third Input
//		g2d.drawLine(positionX + 50, positionY, positionX + 60, positionY + 25); // Gate horizontal
//		g2d.drawLine(positionX + 60, positionY + 25, positionX + 50, positionY + 50); // Gate horizontal
		
		g2d.drawArc(positionX + 30, positionY, 30, 50, 270, 180); // Gate Horizontal Lately
		
		//g2d.fillArc(120, 130, 110, 100, 5, 180);
		//g2d.draw(new Ellipse2D.Double(200, 200, 200, 200));
		g2d.drawArc(positionX , positionY, 100, 50, 270, 90);
		g2d.drawArc(positionX , positionY, 100, 50, 0,90);
		
		
		//g2d.drawArc(positionX, positionY, 100, 70, 270, 180); // Gate Body
		g2d.drawLine(positionX + 100, positionY + 25, positionX +150, positionY + 25); // Gate Output
	
}
	
	public boolean calculateOutput() {
		return this.firstInput || this.secondInput || this.thirdInput;
	}
}