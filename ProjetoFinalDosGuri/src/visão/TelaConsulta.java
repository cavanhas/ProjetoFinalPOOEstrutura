package visão;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Random;

import javax.swing.JTextField;

import modelo.Paciente;

import javax.swing.JButton;

public class TelaConsulta extends JPanel {
	private JTextField textFieldCpfPaciente;
	private JButton btnConsultar;
	private JLabel lblSenha;
	private JTextField textFieldSenha;
	private JButton btnEncaminharParaAtendimento;
	private JLabel labelStatus;

	
	public TelaConsulta() {
		setLayout(new MigLayout("", "[][][][]", "[][][][][][][20.00][][]"));
		
		JLabel lblConsulta = new JLabel("Consulta");
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(lblConsulta, "cell 0 0");
		
		JLabel lblCpfDoPaciente = new JLabel("CPF do Paciente:");
		add(lblCpfDoPaciente, "flowx,cell 0 2 2 1");
		
		btnConsultar = new JButton("Consultar");
		add(btnConsultar, "cell 2 2 2 1,growx");
		
		JLabel lblSenha_1 = new JLabel("Senha:");
		add(lblSenha_1, "flowx,cell 0 4 2 1");
		
		btnEncaminharParaAtendimento = new JButton("Encaminhar para Atendimento");
		add(btnEncaminharParaAtendimento, "cell 2 4 2 1,growx");
		
		textFieldCpfPaciente = new JTextField();
		add(textFieldCpfPaciente, "cell 0 2,growx");
		textFieldCpfPaciente.setColumns(10);
		
		textFieldSenha = new JTextField();
		add(textFieldSenha, "cell 0 4,growx");
		textFieldSenha.setColumns(10);
		
		labelStatus = new JLabel("");
		add(labelStatus, "cell 0 6 4 1,alignx center");

	}
	
	public void mostrarSenha() {
		Random rand  = new Random();
		getTextFieldSenha().setText(Integer.toString(rand.nextInt()));
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

	public JTextField getTextFieldSenha() {
		return textFieldSenha;
	}

	public void setTextFieldSenha(JTextField textFieldSenha) {
		this.textFieldSenha = textFieldSenha;
	}

	public JButton getBtnEncaminharParaAtendimento() {
		return btnEncaminharParaAtendimento;
	}

	public void setBtnEncaminharParaAtendimento(JButton btnEncaminharParaAtendimento) {
		this.btnEncaminharParaAtendimento = btnEncaminharParaAtendimento;
	}

	public JLabel getLabelStatus() {
		return labelStatus;
	}

	public void setLabelStatus(JLabel labelStatus) {
		this.labelStatus = labelStatus;
	}
	
	
	
}
