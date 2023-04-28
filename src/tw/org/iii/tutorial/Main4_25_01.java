package tw.org.iii.tutorial;

import java.util.HashMap;
import java.util.Set;

public class Main4_25_01 {
	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "SeeIe");
		map.put("gender", true);
		map.put("age", 18);
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(map.get(key));
		}
		
		
	}
}