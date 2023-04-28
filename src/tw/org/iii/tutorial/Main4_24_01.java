package tw.org.iii.tutorial;


public class Main4_24_01 {
	public static void main(String[] args) {
//		Main401 obj1 = new Main401();
		Main401 obj2 = new Main402();
		Main401 obj3 = new Main403();
		
		obj2.m2();
		obj3.m2();
		
	}
}

abstract class Main401 {
	// "abstract" can not be constructed in straight as an object
	
	Main401(int a){
		System.out.println("Main401");
	}
	void m1() {
		System.out.println("Main401:m1()");
	}

	abstract void m2();
}

class Main402 extends Main401 {
	Main402(){
		super(2);
		System.out.println("Main402");
	}
	void m2() {
		System.out.println("Main402:m2()");
	}
}

class Main403 extends Main401 {

	Main403() {
		super(3);
	}

	void m2() {
		System.out.println("Main403:m2()");
	}
}
