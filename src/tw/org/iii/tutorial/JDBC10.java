package tw.org.iii.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

import tw.org.iii.security.BCrypt;

public class JDBC10 {
	private static Connection conn;
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String url = "jdbc:mysql://localhost/iii";
	private static final String SQL_CHANGE_PASSWORD = "UPDATE member SET password = ? WHERE account = ?";
	private static final int INDEX_PASSWORD = 1;
	private static final int INDEX_ACCOUNT = 2;
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Account : ");
		String account = scanner.next();

		System.out.println("New Password : ");
		String password = scanner.next();
		
		try {
			conn = DriverManager.getConnection(url, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_CHANGE_PASSWORD);
			pstmt.setString(INDEX_ACCOUNT, account);
			pstmt.setString(INDEX_PASSWORD, BCrypt.hashpw(password, BCrypt.gensalt()));
			if(pstmt.executeUpdate()>0) {
				System.out.println("OK");
			} else {
				System.out.println("No");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
