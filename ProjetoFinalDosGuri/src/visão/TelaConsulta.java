package visão;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaConsulta extends JPanel {
	private JTextField textFieldCpfPaciente;
	private JButton btnConsultar;
	private JLabel lblSenha;

	
	public TelaConsulta() {
		setLayout(new MigLayout("", "[][][136.00,grow][][][][][]", "[][][][][][26.00][][]"));
		
		JLabel lblConsulta = new JLabel("Consulta");
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(lblConsulta, "cell 0 0");
		
		JLabel lblCpfDoPaciente = new JLabel("Cpf do Paciente:");
		add(lblCpfDoPaciente, "cell 1 2,alignx trailing");
		
		textFieldCpfPaciente = new JTextField();
		add(textFieldCpfPaciente, "cell 2 2,growx");
		textFieldCpfPaciente.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		add(btnConsultar, "cell 3 2");

	}

	public JTextField getTextFieldCpfPaciente() {
		return textFieldCpfPaciente;
	}

	public void setTextFieldCpfPaciente(JTextField textFieldCpfPaciente) {
		this.textFieldCpfPaciente = textFieldCpfPaciente;
	}

	public JButton getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(JButton btnConsultar) {
		this.btnConsultar = btnConsultar;
	}
	
	

}
