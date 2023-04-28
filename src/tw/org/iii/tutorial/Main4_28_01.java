package tw.org.iii.tutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

public class Main4_28_01 {
	public static void main(String[] args) {
		// mine: 10.0.104.210
		// teacher: 10.0.104.254
		try {
//			InetAddress ip = InetAddress.getByName("");
//			System.out.println(ip.getHostAddress());  //127.0.0.1 本機
//			System.out.println(ip.getHostName());     //localhost
//			//-----------------------------------------
//			InetAddress ip1 = InetAddress.getByName("www.iii.org.tw.");
//			System.out.println(ip1.getHostAddress()); 
//			System.out.println(ip1.getHostName()); 
//			//-----------------------------------------
//			InetAddress ip2 = InetAddress.getByName("www.google.com.");
//			System.out.println(ip2.getHostAddress()); 
//			System.out.println(ip2.getHostName()); 
			//-----------------------------------------
			InetAddress[] ipAll = InetAddress.getAllByName("www.google.com");
			for (InetAddress ip : ipAll) {
				System.out.println(ip.getHostAddress()); 
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
