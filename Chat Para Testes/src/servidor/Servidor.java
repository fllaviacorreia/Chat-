package servidor;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

import inter_face.ControleTelaConversa;
import inter_face.ControleTelaInicial;

public class Servidor {

	private static IPBroadcast IP;
	private static ServerSocket servidor = null;
	private static DatagramSocket datagramSocket;
	private static ArrayList<String> contatos;
	private static ArrayList<InetAddress> ips;
	private static String mensagem;
	private static InetAddress ip;
	private static String eu = "Flávia Correia";
	private static ControleTelaInicial controleTelaInicial;
	private static Socket cliente;
	private static int porta = 5001;
	
	public Servidor() {
		try {
			datagramSocket = new DatagramSocket(porta);
			String mensagem;
			while (true) {
				byte[] by = new byte[15];

				DatagramPacket packet = new DatagramPacket(by, by.length);
				datagramSocket.receive(packet);
				System.out.println("no métdo servior");
				mensagem = new String(by, 0, by.length);
				ControleTelaConversa.escreveMsg(mensagem);
				System.out.println("MSG = " + mensagem + "TAM MSG = " + mensagem.length());
				System.out.println("ip = " + ip);
			}
		} catch (IOException e) {
			System.err.println("Porta em uso " + e.getMessage());
			e.printStackTrace();
		}
//		try {
//			System.out.println("[I] - Servidor iniciado na porta 5001");
//			while (true) {
//				cliente = getServidor().accept();
//				String msg = (cliente.getInputStream().toString());
//				System.out.println("mensagem " + msg);
//				cliente.close();
//			}
//		} catch (IOException e) {
//			System.err.println("Porta ocupda ou servidor fechado  " + e.getMessage());
//			try {
//				if (servidor != null)
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
				byte[] by = new byte[15];

				DatagramPacket packet = new DatagramPacket(by, by.length);
				datagramSocket.receive(packet);

				mensagem = new String(by, 0, by.length);
				mensagem = mensagem.replace("  ", "");
				ip = packet.getAddress();

				if (!mensagem.equals(eu)) {

					getContatos().add(mensagem);
					getIps().add(ip);
					getControleTelaInicial().insereNome(getContatos());
				}

				for (int i = 0; i < getContatos().size(); i++) {
					if (mensagem == getContatos().get(i))
						System.out.println("igual");
				}
				System.out.println("MSG = " + mensagem + "TAM MSG = " + mensagem.length());
				System.out.println("ip = " + ip);
			}
		} catch (IOException e) {
			System.err.println("Porta em uso " + e.getMessage());
			e.printStackTrace();
		}

	}

	public IPBroadcast getIPBroadcast() {
		if (IP == null) {
			IP = new IPBroadcast();
		}

		return IP;
	}

	public static ArrayList<String> getContatos() {
		if (contatos == null) {
			contatos = new ArrayList<String>();
		}
		return contatos;
	}

	public static ArrayList<InetAddress> getIps() {
		if (ips == null) {
			ips = new ArrayList<InetAddress>();
		}
		return ips;
	}

	public static ControleTelaInicial getControleTelaInicial() {
		if (controleTelaInicial == null) {
			controleTelaInicial = new ControleTelaInicial();
		}
		return controleTelaInicial;
	}

	public static IPBroadcast getIP() {
		return IP;
	}

	public static ServerSocket getServidor() {
		if(servidor == null) {
			try {
				servidor = new ServerSocket(porta);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return servidor;
	}

	public static DatagramSocket getDatagramSocket() {
		return datagramSocket;
	}

	public static String getMensagem() {
		return mensagem;
	}

	public static String getEu() {
		return eu;
	}

	public static Socket getCliente() {
		return cliente;
	}

	public static String TiraEspaços(String dado) {
		String[] pedacos;
		String junta;
		pedacos = dado.split(" ");
		junta = "";

		for (int i = 0; i < pedacos.length; i++) {
			if (pedacos[i] != " ") {
				junta = junta + pedacos[i] + " ";
			}

			// if(i == pedacos.length - 1) {
			// junta = junta + pedacos[i];
			// }
			// else if(pedacos[i].equals(pedacos[i])) {
			// junta = junta + pedacos[i];
			// }
		}
		return junta;
	}

}