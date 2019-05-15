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

public class ControleTelaConversa implements KeyListener{
	static TelaConversa telaConversa;
	static Frame frame;
	Calendar data = Calendar.getInstance();
	MouseListener mouseListener = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getSource() == (telaConversa.getLabelEnviar())) {
				if(!telaConversa.getTextAreaMensagemEscrita().getText().equals("")) {
					String msgEscrita = telaConversa.getTextAreaMensagemEscrita().getText().toString();
					new Cliente();
					telaConversa.getTextAreaMensagemEnviada().append(msgEscrita + "\t " + data.get(Calendar.DATE) + "/"
							+ data.get(Calendar.MONTH)+ "/"+ data.get(Calendar.YEAR) + "  " + data.get(Calendar.HOUR) + ":" 
							+ data.get(Calendar.MINUTE)+"\n");
					telaConversa.getTextAreaMensagemEscrita().setText(null);
					telaConversa.getTextAreaMensagemEscrita().requestFocus();
				}
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
		// TODO Auto-generated method stub
		
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
