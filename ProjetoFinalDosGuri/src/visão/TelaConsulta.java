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
		setLayout(new MigLayout("", "[][][119.00,grow][][][][][]", "[][][][][][20.00][][]"));
		
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
		
		JLabel lblSenha = new JLabel("Senha:");
		add(lblSenha, "cell 1 4,alignx center");
		
		textFieldSenha = new JTextField();
		add(textFieldSenha, "cell 2 4,growx");
		textFieldSenha.setColumns(10);
		
		btnEncaminharParaAtendimento = new JButton("Encaminhar para Atendimento");
		add(btnEncaminharParaAtendimento, "cell 3 4");
		
		labelStatus = new JLabel("");
		add(labelStatus, "cell 2 5");

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
