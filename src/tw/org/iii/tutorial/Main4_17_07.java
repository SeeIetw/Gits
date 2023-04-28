package tw.org.iii.tutorial;

public class Main4_17_07 {

	public static void main(String[] args) {
		Double dd = 22.0;
		Integer ddi = dd.intValue();
		while(ddi<100 && ddi>0) {
			 dd = Math.random()*101;
			 ddi = dd.intValue();
			System.out.printf("Score: %d\n",ddi);
			if(dd>= 60) {
				System.out.println("pass");
			} else {
				System.out.println("failed");
			}
		}
	}

}
