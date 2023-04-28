package tw.org.iii.tutorial;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main4_28_03 {//UDP receive
	public static void main(String[] args) {
		byte[] buf = new byte[1024];
		try(DatagramSocket socket = new DatagramSocket(8888)) {
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			String urip = packet.getAddress().getHostAddress();
			byte[] data = packet.getData();
			int len = packet.getLength();
			String msg = new String(data,0,len);
			
			System.out.println("receive OK " + msg);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
