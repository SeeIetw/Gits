package tw.org.iii.myclasses;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame {
	private JButton go;
	private JLabel[] lanes;
	private Car[] cars;
	private int rank;

	public Racing() {
		super("Racing");
		setLayout(new GridLayout(9, 1));
		go = new JButton("Go");
		add(go);
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});

		lanes = new JLabel[8];
		for (int i = 0; i < lanes.length; i++) {
			lanes[i] = new JLabel((i + 1) + ".");
			add(lanes[i]);
		}

		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void go() {

		for (int i = 0; i < lanes.length; i++) {
			lanes[i].setText((i + 1) + ".");
		}
		cars = new Car[8];
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(i);
			cars[i].start();
		}
		go.setEnabled(false);
	}

	private void finish() {
		for (int i = 0; i < lanes.length; i++) {
			cars[i].interrupt();
		}
	}

	private class Car extends Thread {
		private int lane;

		Car(int lane) {
			this.lane = lane;
		}

		public void run() {
			for (int i = 0; i < 100; i++) {
				lanes[lane].setText(lanes[lane].getText() + ">" + ((i == 99) ? ++rank : ""));
				if (rank == 1) {
					finish();
					go.setEnabled(true);
					rank = 0;
				}

				try {
					Thread.sleep((int) (+Math.random() * 300));
				} catch (Exception e) {
					break;
				}
			}

		}

	}

	public static void main(String[] args) {
		new Racing();
	}

}
