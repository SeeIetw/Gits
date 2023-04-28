package tw.org.iii.tutorial;

import java.util.HashSet;

import tw.org.iii.myclasses.Bike;

public class Main4_24_06 {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("a");
		set.add(new Bike());
		set.add(123);   //123=>auto-boxing
		set.add("a");
		set.add(123);
		System.out.println(set.size());
		System.out.println(set.toString());
		
		
	}
}