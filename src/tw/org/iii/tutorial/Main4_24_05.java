package tw.org.iii.tutorial;

public class Main4_24_05 {
	public static void main(String[] args) {
		
	}
}
interface SeeIe241{
	void m1();
}
interface SeeIe242{
	void m2();
}
interface SeeIe243 extends SeeIe241,  SeeIe242 {
	void m3();
}
interface SeeIe244 extends SeeIe243 {
	public void m1();
	public void m2();
	public void m3();
}

