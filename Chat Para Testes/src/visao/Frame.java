package visao;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;

	public Frame() {
		new JFrame();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
	}
	
	public void trocarPainel(JPanel painel, String titulo) {
		this.setContentPane(painel);
		this.setTitle(titulo);
		this.setMinimumSize(new Dimension(452, 600));
		this.setMaximumSize(new Dimension(452, 600));
		this.setLocation(10,10);
		repaint();
		validate();
	} 
}
