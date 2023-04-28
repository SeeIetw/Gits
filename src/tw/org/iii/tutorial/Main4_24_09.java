package tw.org.iii.tutorial;

import java.util.LinkedList;

public class Main4_24_09 {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(10);
		System.out.println(list.get(list.size()-1));
		
		list.add(2,7);
		System.out.println(list);
		
		
	}
}