package inter_face;

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
import javax.swing.SwingConstants;

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
	private JPanel panel;
	public TelaConversa() {
		setBackground(new Color(153, 204, 204));
		setLayout(null);
		add(getLabelEnviar());
		add(getScrollPaneAreaMensagemEscrita());
		add(getScrollPaneAreaMensagemEnviada());
		add(getPanel());
		
	}
	public JLabel getLabelEnviar() {
		if (labelEnviar == null) {
			iconeSend = new ImageIcon("send.png");
			iconeSend.setImage(iconeSend.getImage().getScaledInstance(60, 50, 100));
			labelEnviar = new JLabel("Enviar");
			labelEnviar.setHorizontalAlignment(SwingConstants.CENTER);
			labelEnviar.setIcon(iconeSend);
			labelEnviar.setBackground(new Color(255, 255, 240));
			labelEnviar.setBounds(375, 491, 61, 50);
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
			scrollPaneAreaMensagemEscrita.setSize(355, 50);
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
			labelVoltar.setBounds(10, 11, 65, 34);
			labelVoltar.setIcon(iconeBack);
			labelVoltar.setBackground(Color.LIGHT_GRAY);
		}
		return labelVoltar;
	}
	public JLabel getLabelContato() {
		if (labelContato == null) {
			labelContato = new JLabel("Contato");
			labelContato.setBounds(85, 5, 344, 40);
		}
		return labelContato;
	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 447, 50);
			panel.setLayout(null);
			panel.add(getLabelVoltar());
			panel.add(getLabelContato());
		}
		return panel;
	}
}
