package tw.org.iii.myclasses;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JPanel;

public class Mydrawer extends JPanel {
	private LinkedList<LinkedList<Point>> pointsLists;
	private LinkedList<LinkedList<Point>> temp;
	public Mydrawer() {
		pointsLists = new LinkedList<>();
		temp = new LinkedList<>();
		setBackground(Color.black);
		myListener myListener1 = new myListener();
		addMouseListener(myListener1);
		addMouseMotionListener(myListener1);
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
		for (LinkedList<Point> linkedList : pointsLists) {
			for (int i = 1; i < linkedList.size(); i++) {
				Point p0 = linkedList.get(i - 1);
				Point p1 = linkedList.get(i);
				g2d.drawLine(p0.x, p0.y, p1.x, p1.y);
			}
		}

	}

	private class myListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			temp.clear();
			LinkedList<Point> pointsList = new LinkedList<>();
			Point point = new Point();
			point.x = e.getX();
			point.y = e.getY();
			pointsList.add(point);
			pointsLists.add(pointsList);
			repaint();

//this method causes a call to this component's paint method as soon as possible.
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			Point point = new Point();
			point.x = e.getX();
			point.y = e.getY();
			pointsLists.getLast().add(point);
			repaint();
//this method causes a call to this component's paint method as soon as possible.
		}
	}
}

class Point {
	public int x, y;

}
