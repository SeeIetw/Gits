package tw.org.iii.tutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main4_26_06 {
	public static void main(String[] args) {
		String data = "Hello\n";
		byte[] btData = data.getBytes();
		try {
			FileOutputStream fout = new FileOutputStream("dir1/file2.txt",true);
			fout.write(btData);
			fout.close();
			System.out.println("OK");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		

	}
}
