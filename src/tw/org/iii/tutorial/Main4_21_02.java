package tw.org.iii.tutorial;

public class Main4_21_02 {
	public static void main(String[] args) {
		Miuro2 O1 = new Miuro2();
		Miuro1 O2 = new Miuro2();
		Miuro1 O3 = new Miuro3();
//		O2.m1();
		
		doThing(O2);
		doThing(O3);
	}
	static void doThing (Miuro1 obj) {
		obj.m1();
	}
}

class Miuro1 {
	void m1() {
		System.out.println("M1m1");
	}
}
class Miuro2 extends Miuro1 {
	void m1() {
		System.out.println("M2m1");
	}
	void m2() {
		System.out.println("M2m2");
	}
}

class Miuro3 extends Miuro1 {
	void m1() {
		System.out.println("M3m1");
	}
	void m2() {
		System.out.println("M3m2");
	}
}