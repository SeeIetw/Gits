package tw.org.iii.myclasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MySign extends JFrame {
	private MydrawerV3 myDrawer;
	private JButton clear, undo, redo, changeColor;
	private JButton save, load, jpg;

	public MySign() {
		super("Sign");

		myDrawer = new MydrawerV3();
		setLayout(new BorderLayout());
		add(myDrawer, BorderLayout.CENTER);

		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		save = new JButton("Save");
		load = new JButton("Load");
		jpg = new JButton("Save JPG");
		changeColor = new JButton("Change Color");

		JPanel top = new JPanel(new FlowLayout()); // div in html
		top.add(clear);
		top.add(undo);
		top.add(redo);
		top.add(save);
		top.add(load);
		top.add(jpg);
		top.add(changeColor);

		add(top, BorderLayout.NORTH);

		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();
			}
		});

		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myDrawer.undo();
			}
		});
		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myDrawer.redo();
			}
		});

		changeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveObj();
			}
		});

		load.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				loadObj();

			}
		});
		
		jpg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myDrawer.saveJPEG();
			}
		});
		setSize(800, 640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void saveObj() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			myDrawer.saveLines(file.getAbsolutePath());
		}
	}


	public void loadObj() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
		File file = jfc.getSelectedFile();
		myDrawer.loadLines(file.getAbsolutePath());
		}
	}

	public void changeColor() {
//		Color newColor = JColorChooser.showDialog(null, "Change Color", myDrawer.getNowColor());
//		if(newColor!=null) {
//			myDrawer.setNowColor(newColor);
//		}
	}

	public static void main(String[] args) {
		new MySign();
	}
}
