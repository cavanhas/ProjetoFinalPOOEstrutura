package visão;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TelaAtendimento extends JPanel {
	private JTextField textFieldSenha;
	private JButton btnIniciarAtendimento;
	private JButton btnChamarSenha ;

	public TelaAtendimento() {
		setLayout(new MigLayout("", "[][grow][][][][][]", "[][][][][][][]"));
		
		JLabel lblAtendimento = new JLabel("Atendimento");
		lblAtendimento.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(lblAtendimento, "cell 0 0");
		
		JLabel lblSenha = new JLabel("Senha:");
		add(lblSenha, "cell 1 1,alignx center");
		
		btnChamarSenha = new JButton("Chamar senha");
		add(btnChamarSenha, "cell 0 2,alignx center");
		
		textFieldSenha = new JTextField();
		add(textFieldSenha, "cell 1 2,growx");
		textFieldSenha.setColumns(10);
		
		btnIniciarAtendimento = new JButton("Iniciar atendimento");
		add(btnIniciarAtendimento, "cell 1 3,alignx center");
		

	}
	
	public void limpar() {
		getTextFieldSenha().setText("");
	}

	public JTextField getTextFieldSenha() {
		return textFieldSenha;
	}

	public void setTextFieldSenha(JTextField textFieldSenha) {
		this.textFieldSenha = textFieldSenha;
	}

	public JButton getBtnIniciarAtendimento() {
		return btnIniciarAtendimento;
	}

	public void setBtnIniciarAtendimento(JButton btnIniciarAtendimento) {
		this.btnIniciarAtendimento = btnIniciarAtendimento;
	}

	public JButton getBtnChamarSenha() {
		return btnChamarSenha;
	}

	public void setBtnChamarSenha(JButton btnChamarSenha) {
		this.btnChamarSenha = btnChamarSenha;
	}
	
	

}
