package servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import inter_face.ControleTelaInicial;

//import controle.ControleServidor;

public class Servidor {

	private static IPBroadcast IP;
	private static ServerSocket server;
	private static DatagramSocket datagramSocket;
	private static ArrayList<PrintStream> clientes;
	private static byte[] Byte;

	public Servidor() {
//		ServerSocket servidor = null;
//		try{
//			servidor = new ServerSocket(5001);
//			System.out.println("[I] - Servidor iniciado na porta 5001");
//			while(true) {
//				Socket cliente = servidor.accept(); // o accept � o que espera algu�m se conectar
//				new ControleServidor(cliente);
//				
//			}
//		} catch (IOException e) {
//			System.err.println("Porta ocupda ou servidor fechado  " + e.getMessage());
//			try {
//				if(servidor != null)
//					servidor.close();
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}
	}

	public static void main(String[] args) {

		try {
			setByte(InetAddress.getByName("localhost").getAddress());
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}

		setClientes(new ArrayList<>());

		try {
			datagramSocket = new DatagramSocket(8000);

			while (true) {
				byte[] by = new byte[255];

				DatagramPacket packet = new DatagramPacket(by, by.length);

				datagramSocket.receive(packet);
				
				System.out.println(packet.getAddress());
				System.out.println("foi " + by.length);
				System.out.println(new String(by, 0, by.length));
				System.out.println(by);

			}
		} catch (IOException e) {
			System.err.println("Porta em uso "+e.getMessage());
			e.printStackTrace();
		}
		
		new ControleTelaInicial();
	}

	public static IPBroadcast getIPBroadcast() {
		if (IP == null) {
			IP = new IPBroadcast();
		}

		return IP;
	}

	public static byte[] getByte() {
		return Byte;
	}

	public static void setByte(byte[] b) {
		Byte = b;
	}

	public static ArrayList<PrintStream> getClientes() {
		return clientes;
	}

	public static void setClientes(ArrayList<PrintStream> clientes) {
		Servidor.clientes = clientes;
	}

	public static ServerSocket getServer() {
		return server;
	}

	public static void setServer(ServerSocket server) {
		Servidor.server = server;
	}
}