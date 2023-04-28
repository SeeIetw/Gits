package tw.org.iii.tutorial;

public class Main4_24_04 {
	public static void main(String[] args) {
		int a = 10;
		Integer int1 = new Integer(a);
		Integer int2 = new Integer("10");
		//may be invalid in future
		Integer int3 = Integer.parseInt("10");
		Integer int4 = 10;  //auto-boxing
		
//		System.out.println(int1);
		System.out.println(int4);
		System.out.println(int1+int2); //int1,int2 => auto-unboxing then plus
	}
}