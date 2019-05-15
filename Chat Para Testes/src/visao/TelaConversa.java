package visao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.TextArea;
import java.awt.Label;

public class TelaConversa extends JPanel {
	
	private JTextArea textAreaMensagemEscrita;
	private JTextArea textAreaMensagemEnviada;
	private JScrollPane scrollPaneAreaMensagemEscrita;
	private JScrollPane scrollPaneAreaMensagemEnviada;
	private JLabel labelVoltar;
	private JLabel labelContato;
	private JLabel labelEnviar;
	private ImageIcon iconeBack;
	private ImageIcon iconeSend;
	public TelaConversa() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		add(getLabelEnviar());
		add(getScrollPaneAreaMensagemEscrita());
		add(getScrollPaneAreaMensagemEnviada());
		add(getLabelVoltar());
		add(getLabelContato());
		
	}
	public JLabel getLabelEnviar() {
		if (labelEnviar == null) {
			iconeSend = new ImageIcon("send.png");
			iconeSend.setImage(iconeSend.getImage().getScaledInstance(89, 61, 1000));
			labelEnviar = new JLabel();
			labelEnviar.setIcon(iconeSend);
			labelEnviar.setBackground(new Color(255, 255, 240));
			labelEnviar.setBounds(351, 487, 61, 50);
		}
		return labelEnviar;
	}
	public JTextArea getTextAreaMensagemEscrita() {
		if (textAreaMensagemEscrita == null) {
			textAreaMensagemEscrita = new JTextArea();
			textAreaMensagemEscrita.setBounds(10, 397, 331, 50);
			textAreaMensagemEscrita.setLineWrap(true);
		}
		return textAreaMensagemEscrita;
	}
	public JTextArea getTextAreaMensagemEnviada() {
		if (textAreaMensagemEnviada == null) {
			textAreaMensagemEnviada = new JTextArea();
			textAreaMensagemEnviada.setBounds(10, 397, 331, 50);
			textAreaMensagemEnviada.setLineWrap(true);
			textAreaMensagemEnviada.setEditable(false);
		}
		return textAreaMensagemEnviada;
	}
	public JScrollPane getScrollPaneAreaMensagemEscrita() {
		if(scrollPaneAreaMensagemEscrita == null) {
			scrollPaneAreaMensagemEscrita = new JScrollPane(getTextAreaMensagemEscrita(), 
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneAreaMensagemEscrita.setSize(326, 50);
			scrollPaneAreaMensagemEscrita.setLocation(10, 491);
		}
		return scrollPaneAreaMensagemEscrita;
	}
	public JScrollPane getScrollPaneAreaMensagemEnviada() {
		if(scrollPaneAreaMensagemEnviada == null) {
			scrollPaneAreaMensagemEnviada = new JScrollPane(getTextAreaMensagemEnviada(), 
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneAreaMensagemEnviada.setSize(415, 404);
			scrollPaneAreaMensagemEnviada.setLocation(10, 61);
		}
		return scrollPaneAreaMensagemEnviada;
	}
	public JLabel getLabelVoltar() {
		if (labelVoltar == null) {
			iconeBack = new ImageIcon("back1.png");
			iconeBack.setImage(iconeBack.getImage().getScaledInstance(40, 30, 100));
			labelVoltar = new JLabel();
			labelVoltar.setIcon(iconeBack);
			labelVoltar.setBounds(10, 10, 47, 32);
			labelVoltar.setBackground(Color.LIGHT_GRAY);
		}
		return labelVoltar;
	}
	public JLabel getLabelContato() {
		if (labelContato == null) {
			labelContato = new JLabel("Contato");
			labelContato.setBounds(57, 10, 368, 22);
		}
		return labelContato;
	}
}
