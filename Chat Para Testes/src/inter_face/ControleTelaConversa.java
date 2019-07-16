package inter_face;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.RepaintManager;

import servidor.BroadcastingClient;
import servidor.IPBroadcast;
import servidor.Servidor;

public class ControleTelaConversa implements KeyListener {
	static TelaConversa telaConversa;
	static Frame frame;
	static String contato = "";
	Calendar data = Calendar.getInstance();
	int segundos;
	int minutos;
	static int horas;
	static int dia;
	static int mes;
	static int ano;
	MouseListener mouseListener = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource() == (telaConversa.getLabelEnviar())) {
				if (!telaConversa.getTextAreaMensagemEscrita().getText().equals("")) {
					dia = data.get(Calendar.DATE);
					mes = data.get(Calendar.MONTH);
					ano = data.get(Calendar.YEAR);

					if (telaConversa.getTextAreaMensagemEnviada().getText().isEmpty()) {
						telaConversa.getTextAreaMensagemEnviada().setText("\t   " + dia + "/" + mes + "/" + ano + "\n");
					}
					try {
						new Servidor();
//						BroadcastingClient.broadcast(telaConversa.getTextAreaMensagemEscrita().getText().toString(), 
//								InetAddress.getByName(BroadcastingClient.getIPBroadcast().IP().toString().substring(1, 
//								(BroadcastingClient.getIPBroadcast().IP().toString()).length())));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					escreveMsg(telaConversa.getTextAreaMensagemEscrita().getText().toString());
				}
			}
			if (e.getSource() == (telaConversa.getLabelVoltar())) {
				frame.setContentPane(new TelaInicial());
				frame.repaint();
				frame.validate();
				Servidor.getControleTelaInicial();
			}

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	};

	public ControleTelaConversa(Frame frame, TelaConversa telaConversa, String contato) {
		this.frame = frame;
		this.telaConversa = telaConversa;
		this.telaConversa.getLabelContato().setText(contato);
		this.contato = contato;
		this.frame.trocarPainel(ControleTelaConversa.telaConversa, "Conversa");
		this.telaConversa.getLabelEnviar().addMouseListener(mouseListener);
		this.telaConversa.getLabelVoltar().addMouseListener(mouseListener);
		this.telaConversa.getTextAreaMensagemEscrita().addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!telaConversa.getTextAreaMensagemEscrita().getText().equals("")) {
				dia = data.get(Calendar.DATE);
				mes = data.get(Calendar.MONTH);
				ano = data.get(Calendar.YEAR);

				if (telaConversa.getTextAreaMensagemEnviada().getText().isEmpty()) {
					telaConversa.getTextAreaMensagemEnviada().setText("\t   " + dia + "/" + mes + "/" + ano + "\n");
				}
				escreveMsg(telaConversa.getTextAreaMensagemEscrita().getText().toString());
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void escreveMsg(String mensagem) {
		InetAddress ip = null;
		for(int i = 0; i < Servidor.getContatos().size(); i++) {
			if(Servidor.getContatos().get(i).equals(contato)) {
				ip = Servidor.getIps().get(i);
				break;
			}
		}
		System.out.println("no método de conversa");
		telaConversa.getTextAreaMensagemEnviada().append(mensagem+"\n");
		if (!telaConversa.getTextAreaMensagemEnviada().getText().isEmpty()
				&& !telaConversa.getTextAreaMensagemEnviada().isFocusOwner()) {
			telaConversa.getTextAreaMensagemEnviada()
					.setCaretPosition(telaConversa.getTextAreaMensagemEnviada().getText().length() - 1);
		}
		try {
			BroadcastingClient.escreveMsg(mensagem, ip , 5001);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		telaConversa.getTextAreaMensagemEscrita().setText(null);
		telaConversa.getTextAreaMensagemEscrita().requestFocus();
	}
}
