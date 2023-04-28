package tw.org.iii.tutorial;

public class Main4_17_08 {

	public static void main(String[] args) {
		Double dd = 22.0;
		Integer ddi = dd.intValue();
		while (ddi < 100 && ddi > 0) {
			dd = Math.random() * 101;
			ddi = dd.intValue();
			System.out.printf("Score: %d\n", ddi);
			if (dd >= 90) {
				System.out.println("A");
			} else if (dd >= 80) {
				System.out.println("B");
			} else if (dd >= 70) {
				System.out.println("C");
			} else if (dd >= 60) {
				System.out.println("D");
			} else {
				System.out.println("E");
			}
		}
	}
}
