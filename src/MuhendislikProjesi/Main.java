package MuhendislikProjesi;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Frame ex = new Frame();
				ex.setVisible(true);
				ex.setSize(1500, 1500);
			}
		});
	}
}
