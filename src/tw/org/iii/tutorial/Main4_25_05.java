package tw.org.iii.tutorial;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.management.RuntimeErrorException;

public class Main4_25_05 {
	public static void main(String[] args) {
		try {
			new SeeIe251().m1();
		} catch (Exception e) {
			
		}
//		new SeeIe251().m1();
		
		
	}
}
class SeeIe251{
	void m1() throws Exception{
		m2();
		}
	void m2() throws Exception{
		m3(3);
		}
	void m3(int a) throws FontFormatException, FileNotFoundException {
		if(a>0) {
			throw new FontFormatException(null);
		}else {
			throw new FileNotFoundException();
		}
	}
}
class SeeIe252 extends SeeIe251{
	void m3(int b) throws FileNotFoundException {
		
	}
}