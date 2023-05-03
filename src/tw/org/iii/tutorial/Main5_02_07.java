package tw.org.iii.tutorial;

public class Main5_02_07 {

	public static void main(String[] args) {
		SeeIe01 obj1 = new SeeIe01("A");
		SeeIe01 obj2 = new SeeIe01("B");
		SeeIe02 obj3 = new SeeIe02("C");
		Thread t1 = new Thread(obj3);
		
		obj1.start();
		obj2.start();
		t1.start();
		

		System.out.println("main");
		
		
		

	}
}
class SeeIe02 implements Runnable{
	String name;
	SeeIe02(String name) {
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