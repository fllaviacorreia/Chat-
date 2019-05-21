package controle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ControleServidor{

	private Socket cliente;
	private ObjectOutputStream envio;
	private ObjectInputStream recibo;

	public ControleServidor(Socket cliente) {
		System.out.println("No servidor");
		this.cliente = cliente;

		try {
			envio = new ObjectOutputStream(cliente.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			recibo = new ObjectInputStream(cliente.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// recebendo mensagens para o cliente
		new Thread() {
			@Override
			public void run() {
				try{
					String mensagem = recibo.readObject().toString();
					while(mensagem != null) {
						System.out.println(mensagem);
				//		envio.writeObject(mensagem); 
						envio.flush();

					}
				} catch (Exception e) {
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}.start();

	}


}
