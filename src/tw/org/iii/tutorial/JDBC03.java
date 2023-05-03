package tw.org.iii.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;


public class JDBC03 {
	public static void main(String[] args) {
		//No loader
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/iii", prop);
			String sql="INSERT INTO cust(cname,tel,birthday) VALUES (?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "SeeIe");
			pstmt.setString(2, "123");
			pstmt.setString(3, "1997-06-01");
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		

	}
}