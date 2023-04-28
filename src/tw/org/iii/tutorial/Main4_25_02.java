package tw.org.iii.tutorial;

public class Main4_25_02 {
	public static void main(String[] args) {
		int a = 10, b = 0;
		int[] c = {1,2,3,4};
		try {
			System.out.println(a / b);
			System.out.println(c[4]);
		}catch(ArithmeticException ae){
			System.out.println("error");
		}catch(ArrayIndexOutOfBoundsException ee){
			System.out.println("Arrerror");
		}
		

		
		
		
	}
}