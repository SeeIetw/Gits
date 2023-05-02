package tw.org.iii.tutorial;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Main5_02_05 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://s3.notfalse.net/wp-content/uploads/2016/12/24160012/Three-way-Handshake1.png");
			HttpsURLConnection conn = 
					(HttpsURLConnection)url.openConnection();
			conn.connect();
			
			FileOutputStream fout = new FileOutputStream("dir2/iii.png");
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
