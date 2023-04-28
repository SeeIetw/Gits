package tw.org.iii.tutorial;

public class Main4_18_01 {

	public static void main(String[] args) {
		int rows = 2;
		for (int n = 1; n <= rows; n++) {
			for (int i = 1; i < 10; i++) {
				for (int j = 2+4*(n-1); j <= 5+4*(n-1); j++) {
					System.out.printf("%d x %d = %d\t", j, i, i * j);
				}
				System.out.println();
			}
			System.out.println("------------------------------------------------------");
		}
//		for (int i = 1; i < 10; i++) {
//			for (int j = 6; j <= 9; j++) {
//				System.out.printf("%d x %d = %d\t", j, i, i * j);
//			}
//			System.out.println();
//		}
	}
}
