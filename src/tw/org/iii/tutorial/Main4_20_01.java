package tw.org.iii.tutorial;

public class Main4_20_01 {
	public static void main(String[] args) {
//		String s1 = "SeeIe";
//		String s2 = s1.concat("tw");
//		String s3 = s1.replace("e", "a");
//		
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
		
		
//-------------------------------------------
		
		String s1 = "SeeIe";
		String s2 = "SeeIe";
		String s3 = new String("SeeIe");
		String s4 = new String("SeeIe");
		System.out.println(s1==s2); //call by value
		System.out.println(s3==s4); //memory addresses are different
		System.out.println(s1==s3);
		
	}

}