package tw.org.iii.tutorial;

import tw.org.iii.myclasses.Bike;

public class Main4_20_02 {
	public static void main(String[] args) {
		String s1 = "SeeIe";
		String s2 = "SeeIe";
		System.out.println(s1.equals(s2));
		
		Bike b2 = new Bike();
		Bike b3 = b2;
		System.out.println(b3.equals(b2));
		System.out.println(b3 == b2);
	}

}