package visão;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

public class TelaAndamento extends JPanel {

	private JLabel lblPacienteAtendido;
	private JLabel lblHoraAtendimento;
	private JLabel lblSituacaoPaciente;
	private JButton btnEncerrarAtendimento;

	public TelaAndamento() {

		setLayout(new MigLayout("", "[][grow][][][][][]", "[][][][][][][][][]"));

		JLabel lblAndamento = new JLabel("Paciente em atendimento");
		lblAndamento.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(lblAndamento, "cell 0 0");

		lblPacienteAtendido = new JLabel("");
		add(lblPacienteAtendido, "cell 0 2");

		lblHoraAtendimento = new JLabel("");
		add(lblHoraAtendimento, "cell 0 3");

		lblSituacaoPaciente = new JLabel("");
		add(lblSituacaoPaciente, "cell 0 4");

		btnEncerrarAtendimento = new JButton("Encerrar atendimento");
		add(btnEncerrarAtendimento, "cell 0 8,grow");

	}

	public JLabel getLblPacienteAtendido() {
		return lblPacienteAtendido;
	}

	public void setLblPacienteAtendido(JLabel lblPacienteAtendido) {
		this.lblPacienteAtendido = lblPacienteAtendido;
	}

	public JLabel getLblHoraAtendimento() {
		return lblHoraAtendimento;
	}

	public void setLblHoraAtendimento(JLabel lblHoraAtendimento) {
		this.lblHoraAtendimento = lblHoraAtendimento;
	}

	public JLabel getLblSituacaoPaciente() {
		return lblSituacaoPaciente;
	}

	public void setLblSituacaoPaciente(JLabel lblSituacaoPaciente) {
		this.lblSituacaoPaciente = lblSituacaoPaciente;
	}

	public JButton getBtnEncerrarAtendimento() {
		return btnEncerrarAtendimento;
	}

	public void setBtnEncerrarAtendimento(JButton btnEncerrarAtendimento) {
		this.btnEncerrarAtendimento = btnEncerrarAtendimento;
	}

}
