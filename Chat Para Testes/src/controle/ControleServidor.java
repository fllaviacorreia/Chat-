package controle;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ControleServidor extends Thread{

	private Socket cliente;
	private ObjectOutputStream envio;
	private ObjectInputStream recibo;
	
	public ControleServidor(Socket cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public void run() {
		try {
			envio = new ObjectOutputStream(cliente.getOutputStream());
			recibo = new ObjectInputStream(cliente.getInputStream());
			System.out.println("No servidor");
			String mensagem = recibo.readObject().toString();
			while(mensagem != null) {
				System.out.println(mensagem);
				 envio.writeObject(mensagem); 
				 envio.flush();
				
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
