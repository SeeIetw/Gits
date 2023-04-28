package tw.org.iii.tutorial;

import java.util.Scanner;

public class Main4_17_02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("x=");
		int x = scanner.nextInt();
		System.out.print("y=");
		int y = scanner.nextInt();
		System.out.printf("%d + %d = %d\n",x,y,x+y);
		System.out.printf("%d - %d = %d\n",x,y,x-y);
		System.out.printf("%d * %d = %d\n",x,y,x*y);
		System.out.printf("%d / %d = %d remainder:%d",x,y,x/y,x%y);
	}
		

}
