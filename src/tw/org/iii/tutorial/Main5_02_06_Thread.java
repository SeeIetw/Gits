package tw.org.iii.tutorial;

public class Main5_02_06_Thread {// 執行緒
	public static void main(String[] args) {
		SeeIe01 obj1 = new SeeIe01("A");
		SeeIe01 obj2 = new SeeIe01("B");
		obj1.start();
		obj2.start();

		
		
		
//		obj1.start(); //can only start once
//		obj2.start();
		System.out.println("main");
	}
}

class SeeIe01 extends Thread {
	String name;
	SeeIe01(String name) {
		this.name = name;
	}
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(name + "." + i+" ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		
	}
}
