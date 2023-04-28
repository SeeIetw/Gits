package tw.org.iii.tutorial;

import java.io.File;
import java.io.FileNotFoundException;

public class Main4_25_08 {
	public static void main(String[] args) {
		File root = new File(".");
		System.out.println(root.getAbsolutePath());
//		File dir1 = new File("./dir2");
		File dir1 = new File("dir2");
		if(dir1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("NO");
		}
		
		
	}
}
