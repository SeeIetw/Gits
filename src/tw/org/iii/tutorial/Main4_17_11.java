package tw.org.iii.tutorial;

public class Main4_17_11 {

	public static void main(String[] args) {
		int year = 2000;
		int month = 2;
		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12:
			System.out.println("31");
			break;
		case 2:
			if (checkLeap(year)) {
				System.out.println("29");
				break;
			} else {
				System.out.println("28");
				break;
			}
		case 4, 6, 9, 11:
			System.out.println("30");
			break;
		default:
			System.out.println("X");
			break;
		}
	}

	public static boolean checkLeap(int x) {
		boolean isLeap1;
		if (x % 400 == 0) {
			isLeap1 = true;
//			System.out.println("潤年");
		} else {
			if (x % 100 == 0) {
				isLeap1 = false;
//				System.out.println("平年");
			} else {
				if (x % 4 == 0) {
					isLeap1 = true;
//					System.out.println("潤年");
				} else {
					isLeap1 = false;
//					System.out.println("平年");
				}
			}
		}

		return isLeap1;
	}
}