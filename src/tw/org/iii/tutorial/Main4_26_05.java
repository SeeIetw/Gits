package tw.org.iii.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main4_26_05 {
	public static void main(String[] args) {
		try {
			File source = new File("dir1/file1.txt");
			FileInputStream fin = new FileInputStream(source);
			byte[] buf = new byte[(int)source.length()];
			fin.read(buf);
			System.out.println(new String(buf));
			fin.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
