package servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;

import inter_face.ControleTelaInicial;

public class Servidor {

	private static IPBroadcast IP;
	private static ServerSocket server;
	private static DatagramSocket datagramSocket;
	private static ArrayList<String> contatos;
	private static String mensagem;
	private static String ip;
	private static String eu = "Fernanda";
	private static ControleTelaInicial controleTelaInicial;
	
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
		new BroadcastingClient();
		try {
			datagramSocket = new DatagramSocket(50001);
			while (true) {
				byte[] by = new byte[255];
				
				DatagramPacket packet = new DatagramPacket(by, by.length);
				datagramSocket.receive(packet);
				
				mensagem = new String(by);
				ip = packet.getAddress().toString();
				
				if(mensagem != eu) {
					getContatos().add(mensagem);
					getControleTelaInicial().addNome(getContatos());
				}
				System.out.println("MSG = "+ mensagem);
				System.out.println("ip = "+ip);
			}
		} catch (IOException e) {
			System.err.println("Porta em uso "+e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	public IPBroadcast getIPBroadcast() {
		if (IP == null) {
			IP = new IPBroadcast();
		}

		return IP;
	}
	
	public static ArrayList<String> getContatos(){
		if(contatos == null) {
			contatos = new ArrayList<String>();
		}
		return contatos;
	}

	public static ControleTelaInicial getControleTelaInicial() {
		if(controleTelaInicial == null) {
			controleTelaInicial = new ControleTelaInicial();
		}
		return controleTelaInicial;
	}
	
}