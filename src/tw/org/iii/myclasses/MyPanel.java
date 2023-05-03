package tw.org.iii.myclasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private Image ball4, ball1, ball2, ball3;
	private Timer timer;
	private int viewW, viewH;
	private BufferedImage[] imgs;
	private LinkedList<BallTask> balls;
	
	public MyPanel() {
		setBackground(Color.YELLOW);
		try {
			imgs = new BufferedImage[4];
			for(int i=0;i<4;i++) {
				imgs[i]=ImageIO.read(new File("dir1/ball"+(i+1)+".png"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		timer = new Timer();
		balls = new LinkedList<>();
		timer.schedule(new RefreshView(), 0, 16);
		addMouseListener(new MyMouseListener());
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth();
		viewH = getHeight();
		
		Graphics2D g2d = (Graphics2D)g;
		
		for (BallTask ball : balls) {
			g2d.drawImage(imgs[ball.img], ball.x, ball.y, null);
		}
		
	}
	
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			BallTask ball = new BallTask(e.getX()-32, e.getY()-32);
			balls.add(ball);
			timer.schedule(ball, 500, 30);
		}
		
	}
	private class RefreshView extends TimerTask{
		@Override
		public void run() {
			repaint();
		}
	}
	
	
	private class BallTask extends TimerTask{
		protected int x, y, dx, dy, img;
		public BallTask(int x, int y){
			this.x = x;
			this.y = y;
			dx = (int)(Math.random()*7)-3;
			dy = (int)(Math.random()*4)+1;
			img = (int)(Math.random()*4);
		}
		
		public void run() {
			if(x<=0 || x + 64>=viewW ) {
				dx *= -1;
			}
			if(y<=0 || y + 64>=viewH ) {
				dy *= -1;
			}
			x += dx;
			y += dy;

		}
	}
}
