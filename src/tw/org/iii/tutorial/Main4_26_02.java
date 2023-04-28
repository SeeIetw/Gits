package tw.org.iii.tutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main4_26_02 {
	public static void main(String[] args) {
		File dir1 = new File("dir1");
		if(dir1.exists()&&dir1.isDirectory()) {
			File[] files = dir1.listFiles();
			for (File file : files) {
				String fname = file.getName();
				long size = file.length();
				String type = file.isDirectory()?"dir":"file";
				System.out.println(fname+":"+size+":"+type);
				
			}
		}

	}
}
