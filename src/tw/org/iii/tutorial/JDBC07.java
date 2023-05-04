package tw.org.iii.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JDBC07 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Page =");
		int page = scanner.nextInt();
		int rpp = 10;
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", prop);
			String sql = "SELECT * FROM food LIMIT ?, ?";
			// SELECT * FROM food WHERE name LIKE '%key%' OR address LIKE '%key%' OR tel
			// LIKE '%key%';
			ResultSet rs = conn.createStatement().executeQuery("select count(*) as total from food");
			rs.next();
			int total = rs.getInt(1);

			if ( page>0 && ((page-1) * rpp < total)) {} else throw new MyPageException("Page Error");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rpp * (page - 1));
				pstmt.setInt(2, rpp);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					String id = result.getString("id");
					String name = result.getString("name");
					String tel = result.getString("tel");
					System.out.println(String.format("%s:%s:%s", id, name, tel));
				}
		}catch (MyPageException e) {
			System.out.println("Oops! "+ e);
		}catch (SQLException e) {
			System.out.println(e);
		}
	}
}
class MyPageException extends Exception{
	private String mesg;
	MyPageException(String mesg){
		this.mesg = mesg;
	}
	@Override
	public String toString() {
		return mesg;
	}
}