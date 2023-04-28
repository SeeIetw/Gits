package tw.org.iii.tutorial;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main4_28_02 {//UDP send
	public static void main(String[] args) {
		//every ip has 2^16 ports (avoid 0 ~ 1024 since some are determined 
		//by certain program, net)
		
		//the choice of port is not important while sending data out
		//,but need to be chosen when receiving data
		
		byte[] data = {33,34,35,36};
		try { //UDP
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(
					data, data.length, InetAddress.getByName("10.0.104.255"), 8888);
			socket.send(packet);
			socket.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
