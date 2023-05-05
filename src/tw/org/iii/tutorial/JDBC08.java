package tw.org.iii.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.org.iii.security.BCrypt;

public class JDBC08 {
	private static Connection conn;
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String url = "jdbc:mysql://localhost/iii";
	private static final String SQL_CHECK = "SELECT * FROM member WHERE account = ?";
	private static final String SQL_INSERT = "INSERT INTO member(account, password, email) VALUES (?,?,?)";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Account : ");
		String account = scanner.next();

		System.out.println("Password : ");
		String password = scanner.next();

		System.out.println("Email : ");
		String email = scanner.next();

		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		try {
			conn = DriverManager.getConnection(url, prop);
			if (checkAccount(account)) {
				if (addMem(account, password, email)) {
					// OK
					System.out.println("Register success");
				} else {
					// XX2
					System.out.println("Register failed");
				}
			} else {
				// XX1
				System.out.println("multi ccount");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	static boolean checkAccount(String account) throws Exception {
		boolean retu = true;

		PreparedStatement pstmt = conn.prepareStatement(SQL_CHECK);
		pstmt.setString(1, account);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			retu = (rs.getInt("account") == 0);
		}
//		rs.close();
//		rs = null;

		return retu;
	}

	static boolean addMem(String account, String password, String email) throws Exception {
		PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
		pstmt.setString(1, account);
		pstmt.setString(2, BCrypt.hashpw(password, BCrypt.gensalt()));
		pstmt.setString(3, email);
		boolean isOK = (pstmt.executeUpdate() != 0);

		return isOK;
	}

}
