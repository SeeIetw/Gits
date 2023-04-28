package tw.org.iii.tutorial;

import java.util.ArrayList;

public class Main4_24_10 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(0,2);
		list.add(0,3);
		list.add(0,4);
		System.out.println(list);
		list.add(2,7);
		System.out.println(list);
		
	}
}