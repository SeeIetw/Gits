package tw.org.iii.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main4_26_08 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileOutputStream fout = new FileOutputStream("dir2/hotel1.json");
			FileInputStream fin = new FileInputStream("dir1/hotel.json");
			int b;
			while(true) {
				b = fin.read();
				if(b==-1) {break;}
				fout.write(b);
			}
			fin.close();
			fout.flush();
			fout.close();
			System.out.println("finish!" + (System.currentTimeMillis()-start));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
