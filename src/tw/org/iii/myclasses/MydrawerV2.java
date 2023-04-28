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

public class MydrawerV2 extends JPanel {
	Color nowColor;
	private LinkedList<Line> pointsLists, temp;
	public MydrawerV2() {
		nowColor = Color.white;
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
		g2d.setStroke(new BasicStroke(4));
		for (Line linkedList : pointsLists) {
			g2d.setColor(linkedList.getColor());
			for (int i = 1; i < linkedList.size(); i++) {
				Point p0 = linkedList.getPoint(i - 1);
				Point p1 = linkedList.getPoint(i);
				g2d.drawLine(p0.x, p0.y, p1.x, p1.y);
			}
		}

	}

	public Color getNowColor() {
		return nowColor;
	}

	public void setNowColor(Color nowColor) {
		this.nowColor = nowColor;
	}

	private class myListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			temp.clear();
			Line line = new Line(nowColor);
			Point point = new Point();
			point.x = e.getX();
			point.y = e.getY();
			line.addPoint(point);
			pointsLists.add(line);
			repaint();

//this method causes a call to this component's paint method as soon as possible.
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			Point point = new Point();
			point.x = e.getX();
			point.y = e.getY();
			pointsLists.getLast().addPoint(point);
			repaint();
//this method causes a call to this component's paint method as soon as possible.
		}
	}
}

class Line {
	private Color color;
	private LinkedList<Point> points;
	Line(Color color){
		this.color = color;
		points = new LinkedList<>();
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void addPoint(Point point) {
		points.add(point);
	}
	public Point getPoint(int index) {
		return points.get(index);
	}
	public int size() {
		return points.size();
		
	}
	
}
