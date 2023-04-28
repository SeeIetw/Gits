package tw.org.iii.tutorial;

import java.io.File;
import java.io.FileNotFoundException;

public class Main4_25_07 {
	public static void main(String[] args) {
		File file1 = new File("D:/dir1");
		if(file1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("NO");
		}
		
	}
}
