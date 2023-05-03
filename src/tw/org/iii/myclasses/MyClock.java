package tw.org.iii.myclasses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class MyClock extends JLabel {
	private Timer timer;

	public MyClock() {
		setText("10:20:30");
		timer = new Timer();
		timer.schedule(new MyTask(), 0, 1000);
		
	}

	private class MyTask extends TimerTask {
		private SimpleDateFormat formatter;
		private Date date;
		@Override
		public void run() {
			formatter= new SimpleDateFormat(
					"HH:mm:ss");
			date = new Date(System.currentTimeMillis());
			setText(formatter.format(date));
		}
	}
}
