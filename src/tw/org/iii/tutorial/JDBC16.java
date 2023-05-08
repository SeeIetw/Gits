package tw.org.iii.tutorial;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.org.iii.myclasses.Bike;

public class JDBC16 {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String url = "jdbc:mysql://localhost/iii";
	private static final String SQL_QUERT = "SELECT * FROM member WHERE id = ?";
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		try {
			Connection conn = DriverManager.getConnection(url, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERT);
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				InputStream in = rs.getBinaryStream("bike");
				ObjectInputStream oin = new ObjectInputStream(in);
				Object ob1 = oin.readObject();
				if(ob1 instanceof Bike) {
					System.out.println((Bike)ob1);
				}else {
					System.out.println("Not Bike");
				}
				
				
				
				System.out.println("OK");
			}else{
				System.out.println("failed");
			}

	
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
