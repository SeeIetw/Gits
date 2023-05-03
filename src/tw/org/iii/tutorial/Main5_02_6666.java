package tw.org.iii.tutorial;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Main5_02_6666 {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://10.0.104.190/dashboard/brad/ball4.png");
//			HttpsURLConnection conn = 
//					(HttpsURLConnection)url.openConnection();
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.connect();
			
			FileOutputStream fout = new FileOutputStream("dir1/ball4.png");
			BufferedInputStream bin = new BufferedInputStream(
					conn.getInputStream());
			byte[] buf = new byte[1024*4];
			int len;
			while((len = bin.read(buf))!=-1) {
				fout.write(buf, 0, len);
			}
			fout.flush();
			fout.close();
			bin.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
