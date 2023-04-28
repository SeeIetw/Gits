package tw.org.iii.tutorial;

import tw.org.iii.myclasses.taiwanId;

public class Main4_19_06 {
	public static void main(String[] args) {
//		System.out.println(taiwanId.checkId("A123456789"));
		taiwanId id1 = new taiwanId();
		taiwanId id2 = new taiwanId(1);
		taiwanId id3 = new taiwanId(false);
		taiwanId id4 = new taiwanId(true, 0);
		taiwanId id5 = taiwanId.createId("A123456789");
		taiwanId id6 = taiwanId.createId("N123456789");
		
		
		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
		System.out.println(id5.getId());
		System.out.println(id6);

	}

}