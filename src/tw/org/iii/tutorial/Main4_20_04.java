package tw.org.iii.tutorial;

public class Main4_20_04 {
	public static void main(String[] args) {
		m1(1,(byte)2);
	}
	
	static void m1(byte b1, byte b2) {
		System.out.println(1);
	}
	static void m1(byte b1, int b2) {
		System.out.println(2);
	}
	static void m1(int b1, int b2) {
		System.out.println(3);
	}
}