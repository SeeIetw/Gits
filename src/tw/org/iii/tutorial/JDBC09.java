package tw.org.iii.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Result;

import tw.org.iii.myclasses.Member;
import tw.org.iii.security.BCrypt;

public class JDBC09 {
	private static Connection conn;
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String url = "jdbc:mysql://localhost/iii";
	private static final String SQL_LOGIN = "SELECT * FROM member WHERE account = ?";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Account : ");
		String account = scanner.next();

		System.out.println("Password : ");
		String password = scanner.next();
		
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		try (Connection conn = DriverManager.getConnection(url, prop)){
			PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String hsPasswd = rs.getString("password");
				if(BCrypt.checkpw(password, hsPasswd)) {
					Member member = new Member();
					member.setAccount(rs.getString("account"));
					member.setPassword(password);
					member.setId(rs.getInt("id"));
					member.setEmail(rs.getString("email"));
					welcome(member);
					
				}else {
					System.out.println("Login failure");
				}
			}else {
				System.out.println("Login failure");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	static void welcome(Member member) {
		System.out.println("Welcome "+member.getAccount()+":"+member.getEmail());
	}

}
