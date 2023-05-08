package tw.org.iii.tutorial;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC14 {
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
			rs.next();
			InputStream in = rs.getBinaryStream("icon");
			FileOutputStream fout = new FileOutputStream("dir2/ball.png");
			byte[] buf = new byte[1024*4];
			int len = in.read(buf);
			fout.write(buf, 0, len);
			fout.flush();
			fout.close();
			System.out.println("OK");
	
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
