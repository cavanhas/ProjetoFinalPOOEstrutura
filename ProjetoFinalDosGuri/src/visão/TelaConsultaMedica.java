package visão;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class TelaConsultaMedica extends JPanel {

	private JTextArea textArea;
	private JButton btnChamarPaciente;
	private JButton btnSar;
	private JButton btnRelatrios;
	
	public TelaConsultaMedica() {
		setLayout(new MigLayout("", "[][grow][][][]", "[][][grow][][]"));
		
		JLabel lblFilas = new JLabel("Filas");
		lblFilas.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(lblFilas, "cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 2,grow");
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnChamarPaciente = new JButton("Chamar paciente");
		add(btnChamarPaciente, "flowx,cell 1 3");
		
		btnRelatrios = new JButton("Relat\u00F3rios");
		add(btnRelatrios, "cell 1 3");
		
		btnSar = new JButton("Sa\u00EDr");
		add(btnSar, "cell 1 3,alignx center");
		
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
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
