package visão;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaConsulta extends JPanel {
	private JTextField textFieldCpfPaciente;

	/**
	 * Create the panel.
	 */
	public TelaConsulta() {
		setLayout(new MigLayout("", "[][][136.00,grow][][][][][]", "[][][][][][][][]"));
		
		JLabel lblConsulta = new JLabel("Consulta");
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(lblConsulta, "cell 0 0");
		
		JLabel lblCpfDoPaciente = new JLabel("Cpf do Paciente:");
		add(lblCpfDoPaciente, "cell 1 2,alignx trailing");
		
		textFieldCpfPaciente = new JTextField();
		add(textFieldCpfPaciente, "cell 2 2,growx");
		textFieldCpfPaciente.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		add(btnConsultar, "cell 3 2");

	}

}
