package tw.org.iii.myclasses;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ball extends JFrame {
	private MyPanel myPanel;
	
	public Ball() {
		super("Ball game");
		
		setLayout(new BorderLayout());
		myPanel = new MyPanel();
		add(myPanel, BorderLayout.CENTER);
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	
	public static void main(String[] args) {
		new Ball();
	}
}
