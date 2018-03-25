package MuhendislikProjesi;

import java.awt.Graphics;
import java.awt.Rectangle;

public class logicGate{
	int positionX;
	int positionY;
	enum gateType {andGate , orGate , notGate , andGateExtra , orGateExtra , inputBox , ledCircle};
	gateType gatetype;
	Boolean firstInput = null;
	Boolean secondInput = null;
	Boolean thirdInput = null;
	Boolean Output = null;
	int width;
	Boolean inputValue = false;
	String inputValueString = "0";
	
	int firstInputCableStartPositionX;
	int firstInputCableStartPoisitionY;
	int secondInputCableStartPositionX;
	int secondInputCableStartPositionY;
	int thirdInputCableStartPositionX;
	int thirdInputCableStartPositionY;
	int outputCableStartPositionX;
	int outputCableStartPositionY;
	
	cable firstInputCable = null;
	cable secondInputCable = null;
	cable thirdInputCable = null;
	cable outputCable = null;
	
	
	int height;
	
	Rectangle bounds;
	
	Rectangle firstInputBounds;
	Rectangle secondInputBounds = new Rectangle(0 , 0 , 0 ,0);
	Rectangle thirdInputBounds = new Rectangle ( 0 , 0 , 0 ,0);
	Rectangle outputBounds;
	
	public void paint(Graphics g) {
		
	}
	
	public void configureGate() {
		
	}
	
	@Override
	public String toString() {
		return   "Gate Type : " +  this.gatetype  + "First Input : " +this.firstInput + "Second Input: " +this.secondInput + "Third Input : "  + this.thirdInput + "OUTPUT: " + this.Output;
		 
	}

}
