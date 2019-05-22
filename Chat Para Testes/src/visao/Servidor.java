package visao;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import controle.ControleServidor;

public class Servidor {

	public Servidor() {
		ServerSocket servidor = null;
		try{
			servidor = new ServerSocket(5001);
			System.out.println("[I] - Servidor iniciado na porta 5001");
			while(true) {
				Socket cliente = servidor.accept();
				new ControleServidor(cliente);
				
			}
		} catch (IOException e) {
			System.err.println("Porta ocupda ou servidor fechado  " + e.getMessage());
			try {
				if(servidor != null)
					servidor.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
		
}
