package servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;


import inter_face.ControleTelaInicial;

//import controle.ControleServidor;

public class Servidor {

	private static IPBroadcast IP;
	private static ServerSocket server;
	private static DatagramSocket datagramSocket;
	private static byte[] Byte;
	private static String mensagem;
	private static String ip;
	private static int porta;
	
	ArrayList<Servidor> listUsuarios = new ArrayList<Servidor>();
	
	public Servidor() {
//		ServerSocket servidor = null;
//		try{
//			servidor = new ServerSocket(5001);
//			System.out.println("[I] - Servidor iniciado na porta 5001");
//			while(true) {
//				Socket cliente = servidor.accept(); // o accept é o que espera alguém se conectar
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
		new ControleTelaInicial();
		new BroadcastingClient();
		try {
			datagramSocket = new DatagramSocket(5000);
			while (true) {
				byte[] by = new byte[255];
				
				DatagramPacket packet = new DatagramPacket(by, by.length);
				datagramSocket.receive(packet);
				BroadcastingClient.broadcast(packet.toString(), packet.getAddress());
				datagramSocket.send(packet);
				
				mensagem = new String(by);
				ip = packet.getAddress().toString();
				porta = packet.getPort();
				
				System.out.println("MSG = "+new String(by));
				System.out.println("packet.toString() = " + packet.toString());
//				static ControleTelaConversa telaConversa = ;
//				telaConversa.escreveMsg(new String(by));
			}
		} catch (IOException e) {
			System.err.println("Porta em uso "+e.getMessage());
			e.printStackTrace();
		}
		
		
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

	

	public static ServerSocket getServer() {
		return server;
	}

	public static void setServer(ServerSocket server) {
		Servidor.server = server;
	}
}