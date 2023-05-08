package tw.org.iii.tutorial;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC13 {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String url = "jdbc:mysql://localhost/iii";
	private static final String SQL_UPDATE_ICON = "UPDATE member SET icon = ? WHERE id = ?";
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		try {
			Connection conn = DriverManager.getConnection(url, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE_ICON);
			
			FileInputStream fin = new FileInputStream("dir1/ball.png");
			
			pstmt.setBinaryStream(1, fin);
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
