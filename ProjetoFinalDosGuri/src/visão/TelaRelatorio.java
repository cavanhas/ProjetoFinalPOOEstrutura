package visão;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class TelaRelatorio extends JPanel {

	public TelaRelatorio() {
		
		setLayout(new MigLayout("", "[][grow][][][][][]", "[][][][][][][]"));
		
		JLabel lblRelatorio = new JLabel("Relatórios");
		lblRelatorio.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(lblRelatorio, "cell 0 0");

	}

}
