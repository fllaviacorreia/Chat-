package servidor;

import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BroadcastingClient {

	private static IPBroadcast IP;
	private static DatagramSocket socket = null;

	public static void main(String[] args) throws IOException {
		/*
		 * Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
		 * while (en.hasMoreElements()) { NetworkInterface ni = en.nextElement();
		 * //System.out.println(" Display Name = " + ni.getDisplayName());
		 * 
		 * //List<InterfaceAddress> list = ni.getInterfaceAddresses();
		 * //Iterator<InterfaceAddress> it = list.iterator();
		 * 
		 * for (InterfaceAddress interfaceAddress : ni.getInterfaceAddresses()) {
		 * InetAddress broadcast = interfaceAddress.getBroadcast();
		 * 
		 * System.out.println(broadcast);
		 * 
		 * if (broadcast == null) continue;
		 * 
		 * 
		 * broadcast("Hello", InetAddress.getByName(broadcast.toString().substring(1,
		 * (broadcast.toString()).length()))); } // InterfaceAddress ia = it.next();
		 */
		System.out.println(getIPBroadcast().IP());

		// broadcast = getIPBroadcast().IP();

		broadcast("Jack", InetAddress
				.getByName(getIPBroadcast().IP().toString().substring(1, (getIPBroadcast().IP().toString()).length())));

		// }
	}

	public static void broadcast(String broadcastMessage, InetAddress address) throws IOException {

		//System.out.println(broadcastMessage);

		socket = new DatagramSocket();
		socket.setBroadcast(true);
		
		byte[] buffer = broadcastMessage.getBytes();

		// System.out.println(new String( buffer,0, buffer.length));

		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 8000);
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
