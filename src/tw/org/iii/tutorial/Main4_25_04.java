package tw.org.iii.tutorial;

public class Main4_25_04 {
	public static void main(String[] args) {
		Bird bird = new Bird();
		try {
			bird.setLeg(2);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("error");
		}
		
		
	}
}
class Bird{
	private int leg;
	void setLeg(int leg) throws Exception {
		if(leg>=0 &&leg<=2) {
			this.leg = leg;			
		}else {
			throw new Exception();
		}
	}
}