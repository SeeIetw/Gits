package tw.org.iii.tutorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Main5_02_03 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.ispan.com.tw");
			HttpsURLConnection conn = 
					(HttpsURLConnection)url.openConnection();
			conn.connect();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							conn.getInputStream()));
			
			String line;
			while((line = reader.readLine())!=null) {
				System.out.println(line);
			}
			reader.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
