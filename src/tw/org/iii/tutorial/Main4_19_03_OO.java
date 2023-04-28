package tw.org.iii.tutorial;

import tw.org.iii.myclasses.Scooter;

public class Main4_19_03_OO {

	public static void main(String[] args) {
		Scooter s1 = new Scooter();
		s1.changeGear(1);
		s1.upSpeed();
		s1.changeGear(2);
		s1.upSpeed();
		System.out.println(s1.getSpeed());
//------------------------------ Constructor: Object initialize--------
	
	}

}