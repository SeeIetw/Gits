package tw.org.iii.tutorial;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Main4_28_04 {
	public static void main(String[] args) {
		try(Socket socket = new Socket(
				InetAddress.getByName("10.0.104.210"),9957)) {
				OutputStream oout = socket.getOutputStream();
				OutputStreamWriter ow = new OutputStreamWriter(oout);
				BufferedWriter bw = new BufferedWriter(ow);
				bw.write("Hello, TCP!\nI'm SeeIe");
				bw.flush();
			System.out.println("Send OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
