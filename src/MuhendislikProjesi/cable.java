package MuhendislikProjesi;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class cable implements drawAble{
	
	
	int cableStartPositionX;
	int cableStartPositionY;
	int cableEndPositionX;
	int cableEndPositionY;
	int cableGoesNum;
	logicGate inputGate;
	logicGate outputGate;
	int cableNum;
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.drawLine(cableStartPositionX, cableStartPositionY, cableEndPositionX, cableEndPositionY);
	}
	
	
	public void configureCable() {
		
//		System.out.println( "Input  Gate : " + inputGate.gatetype + "  "  
//							+ "OUTPUT: " + inputGate.Output 
//							+ "First Input : " + inputGate.firstInput 
//							+ "Second Input:" + inputGate.secondInput 
//							+ "Third Input : " + inputGate.thirdInput );
			
		

//		System.out.println( "Output Gate : " + outputGate.gatetype + "  "  
//							+ "OUTPUT: " + outputGate.Output 
//							+ "First Input : " + outputGate.firstInput 
//							+ "Second Input:" + outputGate.secondInput 
//							+ "Third Input : " + outputGate.thirdInput );
		
		
		if (inputGate.gatetype == logicGate.gateType.inputBox) {
			inputGate.Output = inputGate.inputValue;  // POWER CASE NOT WORKING
		}
		
		
		
		if (this.cableGoesNum == 1) {
			
			 cableStartPositionX = outputGate.firstInputCableStartPositionX;
			 cableStartPositionY = outputGate.firstInputCableStartPoisitionY;
			 
			 if (inputGate.Output != null) {
				 boolean output = false;
				 output = inputGate.Output.booleanValue();
				 inputGate.Output = output;
				 outputGate.firstInput = output;
				 System.out.println("First Cable Connected");
			 }
			
		}  else if (this.cableGoesNum == 2) {
			 cableStartPositionX = outputGate.secondInputCableStartPositionX;
			 cableStartPositionY = outputGate.secondInputCableStartPositionY;
			 //System.out.println("Second Cable Connected");
			 if (inputGate.Output != null) {
				 boolean output = false;
				 output = inputGate.Output.booleanValue();
				 inputGate.Output = output;
				 outputGate.secondInput = output;
				 System.out.println("Second Cable Connected");
			 } 
		}  else if (outputGate.gatetype == logicGate.gateType.andGateExtra || 
		    		   outputGate.gatetype == logicGate.gateType.orGateExtra) {
			    if (this.cableGoesNum == 3) 
			    {
				cableStartPositionX = outputGate.thirdInputCableStartPositionX;
				cableStartPositionY = outputGate.thirdInputCableStartPositionY;
						if (inputGate.Output != null) {
							outputGate.thirdInput = inputGate.Output;
						}
			    }
		} else {
			System.out.println("None of Cable References Are Mapped ");
		}
		
//		cableStartPositionX = inputGate.outputCableStartPositionX;
//		cableStartPositionY = inputGate.outputCableStartPositionY;
		cableEndPositionX = inputGate.outputCableStartPositionX;
		cableEndPositionY = inputGate.outputCableStartPositionY;
	}
	
	public String toString() {
		return "Cable NUM :" + this.cableNum + "Cable Goes Num = " + this.cableGoesNum + "Input Gate : "  + this.inputGate.toString() + "   Cable Output Gate : " +  this.outputGate.toString();
	}
	
}
