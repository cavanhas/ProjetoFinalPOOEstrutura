package visão;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaCadastro extends JPanel {
	private JTextField textFieldcpf;
	private JTextField textFieldnome;
	private JTextField textFieldData;
	private JButton btnCadastrar;
	private JButton btnLimpar;

	public TelaCadastro() {
		setLayout(new MigLayout("", "[][grow][23.00][51.00][grow][][][]", "[][][][][][][]"));
		
				JLabel lblCadastro = new JLabel("Cadastro:");
				lblCadastro.setFont(new Font("Tahoma", Font.BOLD, 17));
				add(lblCadastro, "cell 0 0");
		
				JLabel lblNome = new JLabel("Nome:");
				add(lblNome, "cell 0 1,alignx center");
						
				textFieldnome = new JTextField();
				add(textFieldnome, "cell 1 1 3 1,growx");
				textFieldnome.setColumns(10);
												
				JLabel lblCpf = new JLabel("CPF:");
				add(lblCpf, "cell 0 2,alignx center");
												
				textFieldcpf = new JTextField();
				add(textFieldcpf, "cell 1 2 2 1,growx");
				textFieldcpf.setColumns(10);
												
				JLabel lblDataNasc = new JLabel("Data de Nascimento:");
				add(lblDataNasc, "cell 0 3,alignx left");
										
				textFieldData = new JTextField();
				textFieldData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
				add(textFieldData, "cell 1 3,growx");
				textFieldData.setColumns(10);
										
				btnCadastrar = new JButton("Cadastrar");
				add(btnCadastrar, "cell 1 5,alignx center");
										
				btnLimpar = new JButton("Limpar");
				add(btnLimpar, "cell 3 5,alignx center");

	}
	
	public void limpar() {
		getTextFieldData().setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
		getTextFieldcpf().setText("");
		getTextFieldnome().setText("");
	}

	public JTextField getTextFieldcpf() {
		return textFieldcpf;
	}

	public void setTextFieldcpf(JTextField textFieldcpf) {
		this.textFieldcpf = textFieldcpf;
	}

	public JTextField getTextFieldnome() {
		return textFieldnome;
	}

	public void setTextFieldnome(JTextField textFieldnome) {
		this.textFieldnome = textFieldnome;
	}

	public JTextField getTextFieldData() {
		return textFieldData;
	}

	public void setTextFieldData(JTextField textFieldData) {
		this.textFieldData = textFieldData;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}

}
