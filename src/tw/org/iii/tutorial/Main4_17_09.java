package tw.org.iii.tutorial;

import javax.swing.JOptionPane;

public class Main4_17_09 {

	public static void main(String[] args) {
//		int x = Integer.parseInt(JOptionPane.showInputDialog("input year"));
		for (int x = 1; x <= 2023; x++) {
			boolean isLeap1;
			boolean isLeap2;
			if (x % 400 == 0) {
				isLeap1 = true;
				System.out.println("潤年");
			} else {
				if (x % 100 == 0) {
					isLeap1 = false;
					System.out.println("平年");
				} else {
					if (x % 4 == 0) {
						isLeap1 = true;
						System.out.println("潤年");
					} else {
						isLeap1 = false;
						System.out.println("平年");
					}
				}
			}
			//-------------------------			

			if (x % 4 == 0) {
				if(x%100==0) {
					if(x%400==0) {
						isLeap2 = true;
						System.out.println("潤年");
					} else {
						isLeap2 = false;
						System.out.println("平年"); 
					}
				} else {
					isLeap2 = true;
					System.out.println("潤年");
				}
			} else {
				isLeap2 = false;
				System.out.println("平年");
			}
			if(isLeap1 != isLeap2) {
				System.out.println("wrong");
				break;
			}
		}
		
		
		//--------------------------------------
		
		
	}   
}