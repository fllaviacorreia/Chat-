package visao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class TelaInicial extends JPanel{
	private JTextField textFieldBusca;
	private JLabel labelUsuario;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JLabel labelSearch;
	private ImageIcon iconeSearch;
	public TelaInicial() {
		setBackground(new Color(245, 255, 250));
		setLayout(null);
		add(getTextFieldBusca());
		add(getLabelUsuario());
		add(getSeparator());
		add(getSeparator_1());
		add(getSeparator_2());
		add(getLabelSearch());
		
	}
	public JTextField getTextFieldBusca() {
		if (textFieldBusca == null) {
			textFieldBusca = new JTextField("Buscar por pessoas...");
			textFieldBusca.setForeground(new Color(211, 211, 211));
			textFieldBusca.setBounds(10, 11, 357, 31);
			textFieldBusca.setColumns(10);
		}
		return textFieldBusca;
	}
	public JLabel getLabelUsuario() {
		if (labelUsuario == null) {
			labelUsuario = new JLabel("Usuario");
			labelUsuario.setBounds(10, 100, 396, 31);
		}
		return labelUsuario;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(0, 58, 480, 18);
		}
		return separator;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(0, 71, 480, 18);
		}
		return separator_1;
	}
	public JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setForeground(Color.BLACK);
			separator_2.setBounds(0, 83, 480, 18);
		}
		return separator_2;
	}
	public JLabel getLabelSearch() {
		if (labelSearch == null) {
			iconeSearch = new ImageIcon("search.png");
			iconeSearch.setImage(iconeSearch.getImage().getScaledInstance(40, 30, 100));
			labelSearch = new JLabel();
			labelSearch.setIcon(iconeSearch);
			labelSearch.setBounds(377, 11, 51, 31);
		}
		return labelSearch;
	}
}
