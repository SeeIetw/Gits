package tw.org.iii.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import tw.org.iii.myclasses.Bike;

public class JDBC15 {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String url = "jdbc:mysql://localhost/iii";
	private static final String SQL_UPDATE_ICON = "UPDATE member SET bike = ? WHERE id = ?";
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		try {
			Connection conn = DriverManager.getConnection(url, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE_ICON);
			
			Bike b1 = new Bike();
			b1.upSpeed();
			b1.upSpeed();
			b1.upSpeed();
			b1.upSpeed();
			System.out.println(b1);
			
			pstmt.setObject(1, b1);
			pstmt.setInt(2, 1);
			if(pstmt.executeUpdate()>0) {
				System.out.println("Update success");
			} else {
				System.out.println("failed");
			}
	
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
