package tw.org.iii.tutorial;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Main5_02_01 {//1-time TCP
	public static void main(String[] args) {
		File source = new File("dir1/garbage.jpg");
		try {
			BufferedInputStream bin = new BufferedInputStream(
					new FileInputStream(source));
			byte[] buf = new byte[(int)source.length()];
			bin.read(buf);
			bin.close();
			//socket => TCP, since we are sending document.(need to be stable)
			//Three-way Handshake
			Socket socket = new Socket(InetAddress.getByName("10.0.104.210"), 9999); 
			BufferedOutputStream bout = new BufferedOutputStream(
					socket.getOutputStream());
			bout.write(buf);
			bout.flush();
			bout.close();
			socket.close();
			System.out.println("send OK");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
