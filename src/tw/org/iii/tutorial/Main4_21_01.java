package tw.org.iii.tutorial;

public class Main4_21_01 {
	public static void main(String[] args) {
		SeeIe O1 = new SeeIe(2);
		SeeIe O2 = new SeeIe2();
		SeeIe O3 = new SeeIe3();
		

	}
}

class SeeIe extends Object {
	SeeIe(){
		
	}
	//All classes contains constructor
	SeeIe(int a) {
		//super(); 
		//the above will be inputed by compiler if we didn't construct anything in constructor
		System.out.println("SeeIe(int)");
	}
}

class SeeIe2 extends SeeIe {
	SeeIe2() {
		//All constructors need to initialize parent in the first line
		super(2);
		System.out.println("SeeIe2()");
	}
}
class SeeIe3 extends SeeIe2 {
	SeeIe3() {
		//All constructors need to initialize parent in the first line
		System.out.println("SeeIe3()");
	}
}