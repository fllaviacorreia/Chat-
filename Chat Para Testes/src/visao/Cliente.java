package visao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	TelaConversa telaConversa = new  TelaConversa();


	
	public Cliente(){
		System.out.println("No cliente");
		try {
			Socket socket = new Socket("127.0.0.1", 5001);
			
			// Lendo mensagens do servidor
			ObjectInputStream recibo = new ObjectInputStream(socket.getInputStream());
			new Thread() {
				public void run() {
					try {
						BufferedReader leitor = new BufferedReader((Reader) recibo.readObject());
						while(true) {
							String mensagem = leitor.readLine();
							telaConversa.getTextAreaMensagemEnviada().append(mensagem);
						}
					} catch (ClassNotFoundException e) {
						System.err.println("Classe não encontrada! " + e.getMessage());
						e.printStackTrace();
					} catch (IOException e) {
						System.err.println("Mensagem não pôde ser lida! " + e.getMessage());
						e.printStackTrace();
					}
					
				}
			}.start();
			
			// Escrevendo mensagens para o servidor
			ObjectOutputStream envio = new ObjectOutputStream(socket.getOutputStream());
			String mensagem = telaConversa.getTextAreaMensagemEscrita().getText();
			envio.writeObject(mensagem);
			envio.flush();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
