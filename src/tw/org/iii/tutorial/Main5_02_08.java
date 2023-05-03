package tw.org.iii.tutorial;

import java.util.Timer;
import java.util.TimerTask;

public class Main5_02_08 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new SeeIe03();
		TimerTask task2 = new SeeIe04(timer);
		timer.schedule(task, 3000);
		timer.schedule(new SeeIe05(), 0, 1000);
		
		timer.schedule(task2, 5000);

		System.out.println("main");
	}
}
class SeeIe03 extends TimerTask{
	public void run() {
		System.out.println("OK");
	}
}
class SeeIe04 extends TimerTask{
	private Timer timer;
	SeeIe04(Timer timer){
		this.timer = timer;
	}
	public void run() {
		timer.cancel();
		timer.purge();
		timer = null;
	}
}
class SeeIe05 extends TimerTask{
	int i;
	@Override
	public void run() {
		System.out.println(i++);
	}
}