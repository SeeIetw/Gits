package tw.org.iii.myclasses;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class MydrawerV3 extends JPanel {
	private LinkedList<LinkedList<HashMap<String, Integer>>> pointsLists, temp;
	public MydrawerV3() {
		pointsLists = new LinkedList<>();
		temp = new LinkedList<>();
		setBackground(Color.black);
		myListener myListener1 = new myListener();
		addMouseListener(myListener1);
		addMouseMotionListener(myListener1);
	}
	public boolean saveLines(String fname) {
		try(FileOutputStream fout = new FileOutputStream(fname);
				ObjectOutputStream oout = new ObjectOutputStream(fout))
			//auto-close
		{
			oout.writeObject(pointsLists);
			oout.flush();			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean loadLines(String fname) {
		try (FileInputStream fin = new FileInputStream(fname);
				ObjectInputStream oin = new ObjectInputStream(fin)){
			pointsLists = (LinkedList<LinkedList<HashMap<String, Integer>>>)oin.readObject();
			repaint();
			temp.clear();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public void saveJPEG() {

//		BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
//		Graphics2D g2d = bi.createGraphics();
//		paint(g2d);
//		try {
//			ImageIO.write(bi, "jpeg", new File("dir1/lines.jpg"));
//		} catch (IOException e) {
//			System.out.println(e);
//		}
		BufferedImage img = new BufferedImage(
				getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = img.createGraphics();
			paint(g2d);
			
			try {
				ImageIO.write(img, "jpeg", new File("dir1/lines.jpg"));
			}catch(Exception e) {
				System.out.println(e);
			}
		
	}
	public void saveJPEG1() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = bi.createGraphics();
			paint(g2d);
			File file = jfc.getSelectedFile();
			System.out.println("OK");
			try {
				ImageIO.write(bi, "jpeg", new File(file.getAbsolutePath()));
			} catch (IOException e) {
				System.out.println(e);
			}
			
		}
	}

	public void clear() {
		pointsLists.clear();
		temp.clear();
		repaint();
	}
	
	public void undo() {
		temp.add(pointsLists.getLast());
		pointsLists.removeLast();
		repaint();
	}
	public void redo() {
		pointsLists.add(temp.getLast());
		temp.removeLast();
		repaint();
	}
	@Override
	protected void paintComponent(Graphics g) { // active when the graphic is showed
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.white);
		g2d.setStroke(new BasicStroke(4));
		for (LinkedList<HashMap<String, Integer>> linkedList : pointsLists) {
			for (int i = 1; i < linkedList.size(); i++) {
				HashMap<String, Integer> p0 = linkedList.get(i - 1);
				HashMap<String, Integer> p1 = linkedList.get(i);
				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
			}
		}

	}

	private class myListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			temp.clear();
			LinkedList<HashMap<String, Integer>> pointsList = new LinkedList<>();
			HashMap<String, Integer> point = new HashMap<>();		
			point.put("x", e.getX());
			point.put("y", e.getY());
			pointsList.add(point);
			pointsLists.add(pointsList);
			repaint();

//this method causes a call to this component's paint method as soon as possible.
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			HashMap<String, Integer> point = new HashMap<>();		
			point.put("x", e.getX());
			point.put("y", e.getY());
			pointsLists.getLast().add(point);
			repaint();
//this method causes a call to this component's paint method as soon as possible.
		}
	}
}

