package tw.org.iii.security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

public class AccountRead2 {

	public static void main(String[] args) {
		String content="";
		try {
			FileInputStream fin = new FileInputStream("database/account");
			while(true) {
				int c = fin.read();
				if(c==-1) {break;}
				content += (char)c;
			}
			
			System.out.println(content);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
