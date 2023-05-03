package tw.org.iii.tutorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;


public class JDBC04 {
	public static void main(String[] args) {
		//No loader
		try {
			getFoodData();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	
	}
	static String getFoodData() throws Exception {
		URL url = new URL("https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
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
//			System.out.println(line);
		}
		reader.close();
		parseJSON(sb.toString());
		return sb.toString();
	}
	
	static void parseJSON(String json) throws Exception {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/iii", prop);
		String sql="INSERT INTO food(name,address,tel,pic1,lat,lng) VALUES "
				+ "(?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		JSONArray root = new JSONArray(json);
		for(int i=0;i<root.length();i++) {
			JSONObject row = root.getJSONObject(i);
			pstmt.setString(1, row.getString("Name"));
			pstmt.setString(2, row.getString("Address"));
			pstmt.setString(3, row.getString("Tel"));
			pstmt.setString(4, row.getString("PicURL"));
			try {
				pstmt.setDouble(5, Double.parseDouble(row.getString("Latitude")));
			} catch (Exception e) {
				pstmt.setDouble(5,0);
			}
			try {
				pstmt.setDouble(6, Double.parseDouble(row.getString("Longitude")));
			} catch (Exception e) {
				pstmt.setDouble(6,0);
			}
			
			pstmt.executeUpdate();
		}
	}
	
	
}