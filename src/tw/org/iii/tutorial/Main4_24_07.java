package tw.org.iii.tutorial;

import java.util.HashSet;
import java.util.Iterator;

public class Main4_24_07 {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();

		set.add("SeeIe1");
		set.add("SeeIe2");
		set.add("SeeIe3");
		set.add("SeeIe4");
		set.add("SeeIe5");
		set.add("SeeIe6");
		set.add("SeeIe7");
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("----------------------");
		for (String v:set) {
			System.out.println(v);
		}
	}
}