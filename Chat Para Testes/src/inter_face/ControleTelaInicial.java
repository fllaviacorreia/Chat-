package inter_face;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ControleTelaInicial {
	static TelaInicial telaInicial = new TelaInicial();
	static TelaConversa telaConversa;
	static Frame frame = new Frame();
	String contato;
	MouseListener mouse = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == telaInicial.getTextFieldBusca()) {
				telaInicial.getTextFieldBusca().setText(null);
				telaInicial.getTextFieldBusca().setForeground(Color.BLACK);
			}
			
			
		}
	};
	
	public ControleTelaInicial() {
		frame.trocarPainel(telaInicial, "Página Inicial");
		telaInicial.getTextFieldBusca().addMouseListener(mouse);
		telaInicial.getUsuario().addListSelectionListener(new ListSelectionListener() {
			@Override
            public void valueChanged(ListSelectionEvent e1) {
			 if (telaInicial.getUsuario().getSelectedValue() != null) {
                    contato = (telaInicial.getUsuario().getSelectedValue().toString());
                    telaConversa = new TelaConversa();
                    new ControleTelaConversa(frame, telaConversa, contato);
                    System.out.println("contato = "+ contato);
                }
			
		}});
		
		System.out.println("No controlador da Tela Inicial");
	}
	
	public void insereNome(ArrayList<String>nomes) {
		telaInicial.getUsuario().setListData(nomes.toArray());
		telaInicial.getUsuario().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		telaInicial.getUsuario().setLayoutOrientation(JList.VERTICAL);
		System.out.println("em add nome");
	}

	
}
