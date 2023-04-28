package tw.org.iii.tutorial;

public class Main4_25_03 {
	public static void main(String[] args) {
		int a = 10, b = 0;
		int[] c = {1,2,3,4};
		try {
			System.out.println(c[4]);
			System.out.println(a / b);
		}catch(ArithmeticException ae){
			System.out.println("Arth error");
		}catch(ArrayIndexOutOfBoundsException ee){
			System.out.println("Arr error");
		}catch(RuntimeException re){
			System.out.println("All error");
		}
		

		
		
	}
}