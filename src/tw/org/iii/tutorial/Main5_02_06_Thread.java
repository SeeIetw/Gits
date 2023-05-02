package tw.org.iii.tutorial;

public class Main5_02_06_Thread {// 執行緒
	public static void main(String[] args) {

	}
}

class SeeIe01 extends Thread {
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}
		
	}
}
