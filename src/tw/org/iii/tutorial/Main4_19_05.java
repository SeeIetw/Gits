package tw.org.iii.tutorial;

public class Main4_19_05 {
	public static void main(String[] args) {
		//String is an object
		String s1 = "Hello";
		System.out.println(s1.charAt(0));
		String s2 = new String();
		byte[] b1 = {97,98,99,100};
		String s3 = new String(b1);
		System.out.println(s2);
		System.out.println(s3);
//		System.out.println();
//		System.out.println();
	}

}