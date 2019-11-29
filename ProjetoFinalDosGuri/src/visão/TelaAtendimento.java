package visão;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaAtendimento extends JPanel {

	public TelaAtendimento() {
		setLayout(new MigLayout("", "[][][][]", "[][][][]"));
		
		JLabel lblAtendimento = new JLabel("Atendimento");
		lblAtendimento.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(lblAtendimento, "cell 0 0");
		

	}

}
