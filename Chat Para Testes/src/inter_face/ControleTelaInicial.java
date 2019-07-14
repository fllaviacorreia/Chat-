package inter_face;



import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


public class ControleTelaInicial implements MouseListener{
	static TelaInicial telaInicial = new TelaInicial();
	static TelaConversa telaConversa;
	static Frame frame = new Frame();
	
	public ControleTelaInicial() {
		frame.trocarPainel(telaInicial, "Página Inicial");
		telaInicial.getTextFieldBusca().addMouseListener(this);
		telaInicial.getUsuario().addMouseListener(this);
		System.out.println("No controlador da Tela Inicial");
	}
	
	public void addNome(ArrayList<String>nomes) {
		telaInicial.getUsuario().setListData(nomes.toArray());
		telaInicial.getUsuario().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		telaInicial.getUsuario().setLayoutOrientation(JList.VERTICAL);
		System.out.println("em add nome");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == telaInicial.getTextFieldBusca()) {
			telaInicial.getTextFieldBusca().setText(null);
			telaInicial.getTextFieldBusca().setForeground(Color.BLACK);
		}
		
		if(e.getSource() == telaInicial.getUsuario()) {
			JOptionPane.showMessageDialog(telaInicial, "Bom dia!", "Olá", JOptionPane.INFORMATION_MESSAGE);
//			new ControleTelaConversa(frame, telaConversa);
//			telaConversa = null;
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
	
}
