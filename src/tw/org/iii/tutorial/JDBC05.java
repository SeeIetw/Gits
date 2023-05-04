package tw.org.iii.tutorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;


public class JDBC05 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", prop);
			String sql = "SELECT * FROM food";
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sql);

			for(int i=0;i<139;i++) {
				result.next();
				System.out.println(result.getString("name"));			
			}

			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}