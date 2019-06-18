package servidor;

import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BroadcastingClient {

	private static IPBroadcast IP;
	private static DatagramSocket socket = null;	
	
	public BroadcastingClient() {
		try {
			broadcast("Flávia", InetAddress.getByName(getIPBroadcast().IP().toString().substring(1, (getIPBroadcast().IP().toString()).length())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void broadcast(String broadcastMessage, InetAddress address) throws IOException {
		socket = new DatagramSocket();
		socket.setBroadcast(true);
		DatagramPacket packet = new DatagramPacket(broadcastMessage.getBytes(), broadcastMessage.getBytes().length, address, 5000);
		socket.send(packet);
		socket.close();
	}

	public static IPBroadcast getIPBroadcast() {
		if (IP == null) {
			IP = new IPBroadcast();
		}
		return IP;
	}

}
