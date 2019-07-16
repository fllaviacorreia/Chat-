package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class BroadcastingClient {

	private static IPBroadcast IP;
	private static DatagramSocket socket = null;	
	private static BufferedReader leitor;
	private static PrintWriter escritor;
	public BroadcastingClient() {
		new Thread() {
			public void run() {
				while(true) {
					try {
						broadcast("Flávia Correia", InetAddress.getByName(getIPBroadcast().IP().toString().
								substring(1, (getIPBroadcast().IP().toString()).length())));
						Thread.sleep(2000);
						System.out.println("indo");
						System.out.println("ip Flávia Correia = "+InetAddress.getByName(getIPBroadcast().IP().toString().
								substring(1, (getIPBroadcast().IP().toString()).length())));

					} catch (IOException e) {
						
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
	}
	
	public static void escreveMsg(String msg, InetAddress address, int porta) throws IOException {
		byte [] buffer = msg.getBytes();
		socket = new DatagramSocket();
		socket.setBroadcast(true);
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, porta);
		socket.send(packet);
		socket.close();
	}

	public static void broadcast(String broadcastMessage, InetAddress address) throws IOException {
		byte [] buffer = broadcastMessage.getBytes();
		socket = new DatagramSocket();
		socket.setBroadcast(true);
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 50001);
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
