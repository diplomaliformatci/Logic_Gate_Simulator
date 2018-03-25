package MuhendislikProjesi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.*;


class Frame extends JFrame {
	public Frame() {
		initUI();
	}
	
	
	public void initUI() {
			setResizable(false);
			setTitle("Logic Gates");
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.add(new Board());
			
	}
}