package tw.org.iii.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main4_26_10 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		File sourse = new File("dir1/hotel.json");
		File target = new File("dir2/hotel2.json");
		try {
			FileInputStream fin = new FileInputStream(sourse);
			byte[] buf = new byte[(int)sourse.length()];
			fin.read(buf);
			fin.close();
			FileOutputStream fout = new FileOutputStream(target);
			fout.write(buf);
			fout.flush();
			fout.close();
			System.out.println("finish!" + (System.currentTimeMillis()-start));
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
