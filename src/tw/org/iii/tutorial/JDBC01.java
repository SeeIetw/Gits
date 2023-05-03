package tw.org.iii.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class JDBC01 {
	public static void main(String[] args) {
		//1.load driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/iii?user=root&password=root"); 
			//3306 can be avoid since default.
			Statement stmt = conn.createStatement();
			String sql="INSERT INTO cust(cname,tel,birthday) VALUES ('bbb','0912345324','1997-01-01')";
			
			//boolean isQuote = stmt.executeUpdate(sql);
			//if false, we call it update
			int count = stmt.executeUpdate(sql);
			System.out.println(count);
			
			
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		

	}
}