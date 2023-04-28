package tw.org.iii.tutorial;

import java.util.EventListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class Main4_24_08 {
	public static void main(String[] args) {
		
//		HashSet<Integer> lottery = new HashSet<>();
		TreeSet<Integer> lottery = new TreeSet<>();
		while(lottery.size()<6) {
			lottery.add((int)(Math.random()*49+1));
		}
		Iterator<Integer> it = lottery.iterator();

		while(it.hasNext()) {
			System.out.println(it.next());
		}

		
		
	}
}