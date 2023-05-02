package tw.org.iii.tutorial;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main5_02_02 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999);
			Socket socket = server.accept();
			BufferedInputStream bin = new BufferedInputStream(
					socket.getInputStream());
			
			BufferedOutputStream bout = new BufferedOutputStream(
					new FileOutputStream(String.format("dir2/%s.jpg",socket.getInetAddress().getHostAddress())));
			
			byte[] buf = new byte[1024*1024];
			int len;
			while(true) {
				len= bin.read(buf);
				if(len==-1) {break;}
				bout.write(buf, 0, len);
			}
			
			bout.flush();
			bout.close();
			server.close();
			System.out.println("receive OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		

	}
}
