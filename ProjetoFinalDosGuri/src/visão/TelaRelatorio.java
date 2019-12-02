package visão;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class TelaRelatorio extends JPanel {

	private JLabel lblInfoTempoEspera;
	private JLabel lblInfoTempoAtendimento;

	public TelaRelatorio() {

		setLayout(new MigLayout("", "[][grow][][][][][]", "[][][][][][][]"));

		JLabel lblRelatorio = new JLabel("Relatórios");
		lblRelatorio.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(lblRelatorio, "cell 0 0");

		JLabel labelTempoEspera = new JLabel("Tempo m\u00E9dio de espera:");
		add(labelTempoEspera, "cell 1 1,alignx center");

		lblInfoTempoEspera = new JLabel("");
		lblInfoTempoEspera.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblInfoTempoEspera, "cell 1 2");

		JLabel lblTempoAtendimento = new JLabel("Tempo m\u00E9dio de atendimento:");
		add(lblTempoAtendimento, "cell 1 4,alignx center");

		lblInfoTempoAtendimento = new JLabel("");
		lblInfoTempoAtendimento.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblInfoTempoAtendimento, "cell 1 5");

	}

	public JLabel getLblInfoTempoEspera() {
		return lblInfoTempoEspera;
	}

	public void setLblInfoTempoEspera(JLabel lblInfoTempoEspera) {
		this.lblInfoTempoEspera = lblInfoTempoEspera;
	}

	public JLabel getLblInfoTempoAtendimento() {
		return lblInfoTempoAtendimento;
	}

	public void setLblInfoTempoAtendimento(JLabel lblInfoTempoAtendimento) {
		this.lblInfoTempoAtendimento = lblInfoTempoAtendimento;
	}

}
