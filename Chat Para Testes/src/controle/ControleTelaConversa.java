package controle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.Calendar;

import visao.Cliente;
import visao.Frame;
import visao.TelaConversa;
import visao.TelaInicial;

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
						telaConversa.getTextAreaMensagemEnviada().setText("\t             " + dia + "/"
							+ mes + "/"+ ano + "\n");
					}
					
					String msgEscrita = telaConversa.getTextAreaMensagemEscrita().getText().toString();
					new Cliente();
					telaConversa.getTextAreaMensagemEnviada().append(msgEscrita + "\t \t" + horas + ":" 
							+ minutos + ":" + segundos + "\n");
					if (!telaConversa.getTextAreaMensagemEnviada().getText().isEmpty() && !telaConversa.getTextAreaMensagemEnviada().isFocusOwner()) {
						telaConversa.getTextAreaMensagemEnviada().setCaretPosition(telaConversa.getTextAreaMensagemEnviada().getText().length() - 1);
		            }
					telaConversa.getTextAreaMensagemEscrita().setText("");
					telaConversa.getTextAreaMensagemEscrita().requestFocus();
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
		this.frame = frame;
		this.telaConversa = telaConversa;	
		frame.trocarPainel(this.telaConversa, "Conversa");
		this.telaConversa.getLabelEnviar().addMouseListener(mouseListener);
		this.telaConversa.getTextAreaMensagemEscrita().addKeyListener(this);
		this.telaConversa.getLabelVoltar().addMouseListener(mouseListener);
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
				
				String msgEscrita = telaConversa.getTextAreaMensagemEscrita().getText().toString();
				new Cliente();
				telaConversa.getTextAreaMensagemEnviada().append(msgEscrita + "\t             " 
				+ horas + ":" + minutos + ":" + segundos + "\n");
				if (!telaConversa.getTextAreaMensagemEnviada().getText().isEmpty() && !telaConversa.getTextAreaMensagemEnviada().isFocusOwner()) {
					telaConversa.getTextAreaMensagemEnviada().setCaretPosition(telaConversa.getTextAreaMensagemEnviada().getText().length() - 1);
	            }
				telaConversa.getTextAreaMensagemEscrita().setText("");
				telaConversa.getTextAreaMensagemEscrita().requestFocus();

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

}
