package controle;



import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import visao.Frame;
import visao.Servidor;
import visao.TelaConversa;
import visao.TelaInicial;

public class ControleTelaInicial implements MouseListener{
	static TelaInicial telaInicial = new TelaInicial();
	static TelaConversa telaConversa;
	static Frame frame = new Frame();
	
	public ControleTelaInicial() {
		frame.trocarPainel(telaInicial, "Página Inicial");
		telaInicial.getLabelUsuario().addMouseListener(this);
		telaInicial.getTextFieldBusca().addMouseListener(this);
		System.out.println("No controlador da Tela Inicial");
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == telaInicial.getTextFieldBusca()) {
			telaInicial.getTextFieldBusca().setText(null);
			telaInicial.getTextFieldBusca().setForeground(Color.BLACK);
		}
		if(e.getSource() == telaInicial.getLabelUsuario()) {
			if(telaConversa == null)
				telaConversa = new TelaConversa();
			new ControleTelaConversa(frame, telaConversa);
			telaConversa = null;
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new ControleTelaInicial();
		new Servidor();
	}
	
}
