package visão;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class TelaRelatorio extends JPanel {
	private JTextField textFieldTempoEspera;
	private JTextField textFieldTempoAtendimento;

	public TelaRelatorio() {
		
		setLayout(new MigLayout("", "[][grow][][][][][]", "[][][][][][][]"));
		
		JLabel lblRelatorio = new JLabel("Relatórios");
		lblRelatorio.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(lblRelatorio, "cell 0 0");
		
		JLabel labelTempoEspera = new JLabel("Tempo m\u00E9dio de espera:");
		add(labelTempoEspera, "cell 1 1,alignx center");
		
		textFieldTempoEspera = new JTextField();
		add(textFieldTempoEspera, "cell 1 2,growx");
		textFieldTempoEspera.setColumns(10);
		
		JLabel lblTempoAtendimento = new JLabel("Tempo m\u00E9dio de atendimento:");
		add(lblTempoAtendimento, "cell 1 4,alignx center");
		
		textFieldTempoAtendimento = new JTextField();
		add(textFieldTempoAtendimento, "cell 1 5,growx");
		textFieldTempoAtendimento.setColumns(10);

	}

	public JTextField getTextFieldTempoEspera() {
		return textFieldTempoEspera;
	}

	public void setTextFieldTempoEspera(JTextField textFieldTempoEspera) {
		this.textFieldTempoEspera = textFieldTempoEspera;
	}

	public JTextField getTextFieldTempoAtendimento() {
		return textFieldTempoAtendimento;
	}

	public void setTextFieldTempoAtendimento(JTextField textFieldTempoAtendimento) {
		this.textFieldTempoAtendimento = textFieldTempoAtendimento;
	}
	
	

}
