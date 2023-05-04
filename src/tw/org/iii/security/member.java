package tw.org.iii.security;

public class member {

	public static void main(String[] args) {
		String passwd = "123456";
		String hs = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(hs);

		System.out.println(BCrypt.checkpw(passwd, hs));
	}

}
