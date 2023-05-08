package tw.org.iii.tutorial;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.org.iii.myclasses.Bike;

public class JDBC17 {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String url = "jdbc:mysql://localhost/iii";
	private static final String SQL_QUERT = "SELECT * FROM cust";
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		try {
			Connection conn = DriverManager.getConnection(url, prop);
			PreparedStatement pstmt = conn.prepareStatement(
					SQL_QUERT,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("cname");
				System.out.println(id+":"+name);
			}
			System.out.println("-----------------");
			
			if(rs.first()) {				
				rs.absolute(2);
				String id3 = rs.getString("id");
				String name3 = rs.getString("cname");
				
				System.out.println(id3+":"+name3);
			}
			System.out.println("-----------------");
			rs.updateString("cname", "newSeeIe");
			rs.updateString("tel", "321");
			rs.updateRow();  //commit
			
			System.out.println("-----------------");
			rs.absolute(2);
//			rs.deleteRow();
			String id7 = rs.getString("id");
			String name7 = rs.getString("cname");
			System.out.println(id7+":"+name7);			
			
			System.out.println("-----------------");
			
			rs.moveToInsertRow();
			rs.updateString("cname", "Lily");
			rs.updateString("tel", "0912345678");
			rs.updateString("birthday", "1999-01-02");
			rs.insertRow();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
