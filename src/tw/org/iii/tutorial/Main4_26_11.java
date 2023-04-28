package tw.org.iii.tutorial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4_26_11 {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/Fstdata.csv");
			InputStreamReader ir = new InputStreamReader(fin);
//			FileReader ir = new FileReader("dir1/Fstdata.csv");
			BufferedReader br = new BufferedReader(ir);
			String line;
			while(true) {
				line = br.readLine();
				if(line == null) {break;}
				String[] row = line.split(",");
				System.out.println(row[1]+":"+row[5]+":"+row[7]);
				
			}
						
			br.close();
			System.out.println("Finish!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
