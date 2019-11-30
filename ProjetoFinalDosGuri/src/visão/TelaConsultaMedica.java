package visão;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TelaConsultaMedica extends JPanel {
	private JButton btnChamarPaciente;
	private JButton btnSar;
	private JButton btnRelatrios;
	private JLabel lblProximoPac;
	private JTextField textFieldProximoPac;
	
	public TelaConsultaMedica() {
		setLayout(new MigLayout("", "[][][][]", "[][][][][]"));
		
		JLabel lblFilas = new JLabel("Filas");
		lblFilas.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(lblFilas, "cell 0 0");
		
		lblProximoPac = new JLabel("Pr\u00F3ximo paciente:");
		add(lblProximoPac, "flowx,cell 0 1");
		
		btnChamarPaciente = new JButton("Chamar paciente");
		add(btnChamarPaciente, "flowx,cell 1 3");
		
		btnRelatrios = new JButton("Relat\u00F3rios");
		add(btnRelatrios, "cell 1 3");
		
		btnSar = new JButton("Sa\u00EDr");
		add(btnSar, "cell 1 3,alignx center");
		
		textFieldProximoPac = new JTextField();
		add(textFieldProximoPac, "cell 0 1,growx");
		textFieldProximoPac.setColumns(10);
		
	}

	public JButton getBtnChamarPaciente() {
		return btnChamarPaciente;
	}

	public void setBtnChamarPaciente(JButton btnChamarPaciente) {
		this.btnChamarPaciente = btnChamarPaciente;
	}

	public JButton getBtnSar() {
		return btnSar;
	}

	public void setBtnSar(JButton btnSar) {
		this.btnSar = btnSar;
	}

	public JButton getBtnRelatrios() {
		return btnRelatrios;
	}

	public void setBtnRelatrios(JButton btnRelatrios) {
		this.btnRelatrios = btnRelatrios;
	}
	
	

}
