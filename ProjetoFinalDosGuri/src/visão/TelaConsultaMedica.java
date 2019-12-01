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
	private JLabel lblFilaP1;
	private JLabel lblFilaP2;
	private JLabel lblFilaP3;
	private JLabel lblFilaP4;
	private JLabel lblFilaP5;
	private JLabel lblProximoPacDesc;
	private JLabel lblFila1;
	private JLabel lblFila2;
	private JLabel lblFila3;
	private JLabel lblFila4;
	private JLabel lblFila5;
	
	public TelaConsultaMedica() {
		setLayout(new MigLayout("", "[][][][]", "[][][][][][][][][][][]"));
		
		JLabel lblFilas = new JLabel("Filas");
		lblFilas.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(lblFilas, "cell 0 0");
		
		lblProximoPac = new JLabel("Pr\u00F3ximo paciente:");
		add(lblProximoPac, "flowx,cell 0 1");
		
		lblFilaP1 = new JLabel("Fila de Prioridade 1:");
		add(lblFilaP1, "flowx,cell 0 2");
		
		lblFilaP2 = new JLabel("Fila de Prioridade 2:");
		add(lblFilaP2, "flowx,cell 0 3");
		
		lblFilaP3 = new JLabel("Fila de Prioridade 3:");
		add(lblFilaP3, "flowx,cell 0 4");
		
		lblFilaP4 = new JLabel("Fila de Prioridade 4:");
		add(lblFilaP4, "flowx,cell 0 5");
		
		lblFilaP5 = new JLabel("Fila de Prioridade 5:");
		add(lblFilaP5, "flowx,cell 0 6");
		
		btnChamarPaciente = new JButton("Chamar paciente");
		add(btnChamarPaciente, "flowx,cell 0 10");
		
		btnRelatrios = new JButton("Relat\u00F3rios");
		add(btnRelatrios, "cell 0 10");
		
		btnSar = new JButton("Sa\u00EDr");
		add(btnSar, "cell 0 10,alignx center");
		
		lblProximoPacDesc = new JLabel("");
		add(lblProximoPacDesc, "cell 0 1");
		
		lblFila1 = new JLabel("");
		add(lblFila1, "cell 0 2,alignx left");
		
		lblFila2 = new JLabel("");
		add(lblFila2, "cell 0 3");
		
		lblFila3 = new JLabel("");
		add(lblFila3, "cell 0 4");
		
		lblFila4 = new JLabel("");
		add(lblFila4, "cell 0 5,alignx left,aligny bottom");
		
		lblFila5 = new JLabel("");
		add(lblFila5, "cell 0 6");
		
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

	public JLabel getLblProximoPac() {
		return lblProximoPac;
	}

	public void setLblProximoPac(JLabel lblProximoPac) {
		this.lblProximoPac = lblProximoPac;
	}

	public JLabel getLblFilaP1() {
		return lblFilaP1;
	}

	public void setLblFilaP1(JLabel lblFilaP1) {
		this.lblFilaP1 = lblFilaP1;
	}

	public JLabel getLblFilaP2() {
		return lblFilaP2;
	}

	public void setLblFilaP2(JLabel lblFilaP2) {
		this.lblFilaP2 = lblFilaP2;
	}

	public JLabel getLblFilaP3() {
		return lblFilaP3;
	}

	public void setLblFilaP3(JLabel lblFilaP3) {
		this.lblFilaP3 = lblFilaP3;
	}

	public JLabel getLblFilaP4() {
		return lblFilaP4;
	}

	public void setLblFilaP4(JLabel lblFilaP4) {
		this.lblFilaP4 = lblFilaP4;
	}

	public JLabel getLblFilaP5() {
		return lblFilaP5;
	}

	public void setLblFilaP5(JLabel lblFilaP5) {
		this.lblFilaP5 = lblFilaP5;
	}

	public JLabel getLblProximoPacDesc() {
		return lblProximoPacDesc;
	}

	public void setLblProximoPacDesc(JLabel lblProximoPacDesc) {
		this.lblProximoPacDesc = lblProximoPacDesc;
	}

	public JLabel getLblFila1() {
		return lblFila1;
	}

	public void setLblFila1(JLabel lblFila1) {
		this.lblFila1 = lblFila1;
	}

	public JLabel getLblFila2() {
		return lblFila2;
	}

	public void setLblFila2(JLabel lblFila2) {
		this.lblFila2 = lblFila2;
	}

	public JLabel getLblFila3() {
		return lblFila3;
	}

	public void setLblFila3(JLabel lblFila3) {
		this.lblFila3 = lblFila3;
	}

	public JLabel getLblFila4() {
		return lblFila4;
	}

	public void setLblFila4(JLabel lblFila4) {
		this.lblFila4 = lblFila4;
	}

	public JLabel getLblFila5() {
		return lblFila5;
	}

	public void setLblFila5(JLabel lblFila5) {
		this.lblFila5 = lblFila5;
	}	

}
