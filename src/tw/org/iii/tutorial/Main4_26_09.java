package tw.org.iii.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main4_26_09 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileOutputStream fout = new FileOutputStream("dir2/hotel1.json");
			FileInputStream fin = new FileInputStream("dir1/hotel.json");
			int len;
			byte[] buf = new byte[4*1024];
			while(true) {
				len = fin.read(buf);
				System.out.println(buf);
				
				if(len==-1) {break;}
				fout.write(buf,0,len);
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
