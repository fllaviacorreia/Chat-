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

import servidor.BroadcastingClient;
import servidor.IPBroadcast;

public class ControleTelaConversa implements KeyListener{
	static TelaConversa telaConversa;
	static Frame frame;
	Calendar data = Calendar.getInstance();
	int segundos;
    int minutos;
    int horas;
    int dia;
    int mes;
    int ano;
	MouseListener mouseListener = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getSource() == (telaConversa.getLabelEnviar())) {
				if(!telaConversa.getTextAreaMensagemEscrita().getText().equals("")) {
					segundos = data.get(Calendar.SECOND);
				    minutos = data.get(Calendar.MINUTE);
				    horas = data.get(Calendar.HOUR_OF_DAY);
				    dia = data.get(Calendar.DATE);
				    mes = data.get(Calendar.MONTH);
				    ano = data.get(Calendar.YEAR);
				    
					if(telaConversa.getTextAreaMensagemEnviada().getText().isEmpty()) {
						telaConversa.getTextAreaMensagemEnviada().setText("\t   " + dia + "/"
							+ mes + "/"+ ano + "\n");
					}
					try {
						BroadcastingClient.broadcast(telaConversa.getTextAreaMensagemEscrita().getText().toString(), 
								InetAddress.getByName(BroadcastingClient.getIPBroadcast().IP().toString().substring(1, 
								(BroadcastingClient.getIPBroadcast().IP().toString()).length())));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					escreveMsg(telaConversa.getTextAreaMensagemEscrita().getText().toString());
				}
			}
			if(e.getSource() == (telaConversa.getLabelVoltar())) {
				frame.setContentPane(new TelaInicial());
				new ControleTelaInicial();
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
	
	public ControleTelaConversa(Frame frame, TelaConversa telaConversa) {
		ControleTelaConversa.frame = frame;
		ControleTelaConversa.telaConversa = telaConversa;	
		ControleTelaConversa.frame.trocarPainel(ControleTelaConversa.telaConversa, "Conversa");
		ControleTelaConversa.telaConversa.getLabelEnviar().addMouseListener(mouseListener);
		ControleTelaConversa.telaConversa.getTextAreaMensagemEscrita().addKeyListener(this);
		ControleTelaConversa.telaConversa.getLabelVoltar().addMouseListener(mouseListener);
		System.out.println("No Controlador da Tela de Conversa");
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!telaConversa.getTextAreaMensagemEscrita().getText().equals("")) {
				segundos = data.get(Calendar.SECOND);
			    minutos = data.get(Calendar.MINUTE);
			    horas = data.get(Calendar.HOUR_OF_DAY);
			    dia = data.get(Calendar.DATE);
			    mes = data.get(Calendar.MONTH);
			    ano = data.get(Calendar.YEAR);
			    
				if(telaConversa.getTextAreaMensagemEnviada().getText().isEmpty()) {
					telaConversa.getTextAreaMensagemEnviada().setText("\t   " + dia + "/"
						+ mes + "/"+ ano + "\n");
				}
				try {
					BroadcastingClient.broadcast(telaConversa.getTextAreaMensagemEscrita().getText().toString(), 
							InetAddress.getByName(BroadcastingClient.getIPBroadcast().IP().toString().substring(1, 
							(BroadcastingClient.getIPBroadcast().IP().toString()).length())));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
	
	
	public void escreveMsg(String mensagem) {
		System.out.println("no método de conversa");
		telaConversa.getTextAreaMensagemEnviada().append(mensagem + "\t             " 
				+ horas + ":" + minutos + "\n");
				if (!telaConversa.getTextAreaMensagemEnviada().getText().isEmpty() && !telaConversa.getTextAreaMensagemEnviada().isFocusOwner()) {
					telaConversa.getTextAreaMensagemEnviada().setCaretPosition(telaConversa.getTextAreaMensagemEnviada().getText().length() - 1);
	            }
				telaConversa.getTextAreaMensagemEscrita().setText(null);
				telaConversa.getTextAreaMensagemEscrita().requestFocus();
	}
}
