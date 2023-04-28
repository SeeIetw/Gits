package tw.org.iii.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main4_26_04 {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/file1.txt");
			byte[] buf = new byte[3];
			int len = buf.length;
			while(true) {
				len = fin.read(buf);
				if(len==-1) {break;}
				System.out.print(new String(buf,0,len));
			}
			
			
			fin.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
