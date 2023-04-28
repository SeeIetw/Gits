package tw.org.iii.tutorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main4_28_05 {//TCP receive
	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(9957)) {
			Socket socket = server.accept();
			InputStreamReader ir = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(ir);
			String urip = socket.getInetAddress().getHostAddress();
			System.out.println(urip);
			String line = br.readLine();
			
			while(line == null) {
				line = br.readLine();
				System.out.println(br.readLine());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
