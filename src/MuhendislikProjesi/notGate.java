package MuhendislikProjesi;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class notGate extends logicGate implements drawAble{
	
	
	public notGate(int positionX ,  int positionY) {
		super.positionX = positionX;
		super.positionY = positionY;
		super.width = 100;
		super.height = 100;
		super.gatetype = gateType.notGate;
		bounds = new Rectangle(positionX + 50, positionY , 40 , 50);
		firstInputBounds = new Rectangle(positionX - 5 , positionY + 15 , 20 , 20);
		secondInputBounds = new Rectangle(0 ,0,0, 0);
		thirdInputBounds = new Rectangle( 0 , 0 , 0 ,0);
		outputBounds = new Rectangle(positionX + 105 , positionY + 15 , 20 , 20); 
		System.out.println(firstInputBounds.toString());
		super.outputCableStartPositionX= super.positionX + 115;
		super.outputCableStartPositionX = super.positionY + 25;
		super.Output = false;
		
	}
	    
	public void configureGate() {
		bounds = new Rectangle(positionX + 50, positionY , 40 , 50);
		firstInputBounds = new Rectangle(positionX - 5 , positionY + 15 , 20 , 20);
		secondInputBounds = new Rectangle(0 ,0,0, 0);
		thirdInputBounds = new Rectangle( 0 , 0 , 0 , 0);
		outputBounds = new Rectangle(positionX + 105 , positionY + 15 , 20 , 20); 
		
		super.firstInputCableStartPositionX = super.positionX;
		super.firstInputCableStartPoisitionY = super.positionY + 25;
		super.outputCableStartPositionX= super.positionX + 115;
		super.outputCableStartPositionY = super.positionY + 25;
		
		
		
		if (this.firstInput != null) {
			this.Output = calculateOutput();
		}
		
		
	}
	
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		
		/* Not Gate Body */
		g2d.drawLine(positionX + 50, positionY, positionX + 50, positionY + 50);
		g2d.drawLine(positionX + 50, positionY, positionX + 75, positionY + 25 );
		g2d.drawLine(positionX + 50, positionY + 50, positionX + 75, positionY + 25);
		
		
		/* Not Gate Input */
		
		g2d.drawLine(positionX, positionY + 25, positionX + 50, positionY + 25);
		
		
		
		/* Not Gate Output */
		
		g2d.drawOval(positionX + 75, positionY +17, 15, 15);
		g2d.drawLine(positionX + 90, positionY + 25, positionX + 115, positionY + 25);
		
	}
	
	public boolean calculateOutput() {
		return !this.firstInput;
	}
}
