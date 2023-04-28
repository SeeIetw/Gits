package tw.org.iii.security;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class AccountWrite {
	public static void main(String[] args) {
		JOptionPane jop = new JOptionPane();
		String password;

		password = AES256.encrypt(jop.showInputDialog("Password"));
		System.out.println(password);

		byte[] bt = password.getBytes();
		try {
			FileOutputStream fout = new FileOutputStream("database/account");

			for (byte c : bt) {
				fout.write(c);
			}
			fout.flush();
			fout.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
