package tw.org.iii.tutorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main5_02_04 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelStay.aspx");
			HttpsURLConnection conn = 
					(HttpsURLConnection)url.openConnection();
			conn.connect();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							conn.getInputStream()));
			
			String line;
			StringBuffer sb = new StringBuffer();
			while((line = reader.readLine())!=null) {
				sb.append(line);
//				System.out.println(line);
			}
			reader.close();
			System.out.println("OK");
			
			parseJSON(sb.toString());
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	static void parseJSON(String json) {
		JSONArray root = new JSONArray(json);
//		System.out.println(root.length());
		for(int i=0;i<root.length();i++) {
			JSONObject row = root.getJSONObject(i);
			System.out.println(row.getString("Name")+":"+row.getString("City")+":"+row.getString("Town"));
		}
	}

}
