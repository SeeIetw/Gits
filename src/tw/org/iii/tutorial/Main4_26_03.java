package tw.org.iii.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main4_26_03 {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/file1.txt");
			int c=0;
			String content="";
			while(true) {
				c = fin.read();
				if(c==-1) {break;}
				content += (char)c;
			}
			System.out.println(content);
			fin.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
