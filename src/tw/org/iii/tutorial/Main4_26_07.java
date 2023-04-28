package tw.org.iii.tutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main4_26_07 {
	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("dir1/file1.txt");
			int c=reader.read();
			String str = "";
			while(true) {
				c = reader.read();
				if(c==-1) {break;}
				str += (char)c;
			}
			System.out.println(str);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		

	}
}
