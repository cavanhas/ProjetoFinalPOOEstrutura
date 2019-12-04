package visão;

import javax.swing.JPanel;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class TelaTriagem extends JPanel {
	
	private JCheckBox checkBoxEntubado;
	private JCheckBox checkBoxApneia;
	private JCheckBox checkBoxSemPulso;
	private JCheckBox checkBoxSemReacao;
	private JCheckBox checkBoxRisco;
	private JCheckBox checkBoxConfuso;
	private JCheckBox checkBoxDesorientado;
	private JCheckBox checkBoxLetargico;
	private JCheckBox checkBoxDorAguda;
	private JRadioButton radioButtonSim;
	private JRadioButton radioButtonNao;
	private JPanel painelExpandido;
	private JLabel lblQuantos;
	private JPanel painelExpandido2;
	private JTextField textFieldFreqCardiaca;
	private JLabel lblFrequnciaCardaca;
	private JLabel lblFreqRespiratoria;
	private JTextField textFieldFreqRespiratoria;
	private JLabel lblTempCorporal;
	private JTextField textFieldTempCorporal;
	private JLabel lblOximetria;
	private JTextField textFieldOximetria;
	private JLabel lbIndiceFluxoResp;
	private JTextField textFieldIndiceFluxoResp;
	private JButton btnConcluirTriagem;
	private JButton btnIrParaFila;
	private JRadioButton radioButtonSimProc;
	private JRadioButton radioButtonNaoProc;
<<<<<<< HEAD
	private ButtonGroup bGroup;
	private ButtonGroup btnGroupProc;
	private JLabel lblAviso;
	private JButton btnLimpar;
=======
	private JLabel lblAviso;
>>>>>>> branch 'master' of https://github.com/cavanhas/ProjetoFinalPOOEstrutura

	public TelaTriagem() {
		
		setLayout(new MigLayout("", "[grow]", "[][][][][][][][]"));
		
		JLabel lblTriagem = new JLabel("Triagem");
		lblTriagem.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblTriagem, "flowx,cell 0 0");
		
		JLabel lblInfo1 = new JLabel("Preencha os campos de acordo com a situa\u00E7\u00E3o do paciente");
		add(lblInfo1, "cell 0 1");
		
		checkBoxEntubado = new JCheckBox("Entubado");
		add(checkBoxEntubado, "flowx,cell 0 2");
		
		checkBoxApneia = new JCheckBox("Apneia");
		add(checkBoxApneia, "cell 0 2");
		
		checkBoxSemPulso = new JCheckBox("Sem pulso");
		add(checkBoxSemPulso, "cell 0 2");
		
		checkBoxSemReacao = new JCheckBox("Sem rea\u00E7\u00E3o");
		add(checkBoxSemReacao, "cell 0 2");
		
		checkBoxRisco = new JCheckBox("Situa\u00E7\u00E3o de risco");
		add(checkBoxRisco, "cell 0 2");
		
		checkBoxConfuso = new JCheckBox("Confuso");
		add(checkBoxConfuso, "flowx,cell 0 3");
		
		checkBoxDesorientado = new JCheckBox("Desorientado");
		add(checkBoxDesorientado, "cell 0 3");
		
		checkBoxLetargico = new JCheckBox("Let\u00E1rgico");
		add(checkBoxLetargico, "cell 0 3");
		
		checkBoxDorAguda = new JCheckBox("Dor aguda");
		add(checkBoxDorAguda, "cell 0 3");
		
		JLabel lblInfo2 = new JLabel("O paciente necessita realizar mais procedimentos al\u00E9m da consulta m\u00E9dica?");
		add(lblInfo2, "cell 0 4");
		
		radioButtonSim = new JRadioButton("Sim");
		radioButtonSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expandeFormulario();
			}
		});
		add(radioButtonSim, "flowx,cell 0 5");
		
		radioButtonNao = new JRadioButton("N\u00E3o");
		radioButtonNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recolheFormulario();
			}
		});
		add(radioButtonNao, "cell 0 5");
		
		bGroup = new ButtonGroup();
		bGroup.add(radioButtonSim);
		bGroup.add(radioButtonNao);
		
		painelExpandido = new JPanel();
		painelExpandido.setVisible(false);
		add(painelExpandido, "cell 0 5,grow");
		painelExpandido.setLayout(new MigLayout("", "[42px][86px]", "[19px]"));
		
		lblQuantos = new JLabel("Mais de um procedimento?");
		painelExpandido.add(lblQuantos, "cell 0 0,alignx left,aligny center");
		
		radioButtonSimProc = new JRadioButton("Sim");
		radioButtonSimProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expandeFormulario2();
			}
		});
		painelExpandido.add(radioButtonSimProc, "flowx,cell 1 0");
		
		radioButtonNaoProc = new JRadioButton("N\u00E3o");
		radioButtonNaoProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recolheFormulario2();
			}
		});
		painelExpandido.add(radioButtonNaoProc, "cell 1 0");
		
		painelExpandido2 = new JPanel();
		painelExpandido2.setVisible(false);
		add(painelExpandido2, "cell 0 6,grow");
		painelExpandido2.setLayout(new MigLayout("", "[][][][]", "[][][][]"));
		
		lblFrequnciaCardaca = new JLabel("Frequ\u00EAncia card\u00EDaca");
		painelExpandido2.add(lblFrequnciaCardaca, "flowx,cell 0 0");
		
		lblFreqRespiratoria = new JLabel("Frequ\u00EAncia Respirat\u00F3ria");
		painelExpandido2.add(lblFreqRespiratoria, "flowx,cell 1 0");
		
		lblTempCorporal = new JLabel("Temperatura corporal");
		painelExpandido2.add(lblTempCorporal, "flowx,cell 0 1");
		
		textFieldFreqRespiratoria = new JTextField();
		painelExpandido2.add(textFieldFreqRespiratoria, "cell 1 0,growx");
		textFieldFreqRespiratoria.setColumns(10);
		
		textFieldFreqCardiaca = new JTextField();
		painelExpandido2.add(textFieldFreqCardiaca, "cell 0 0,growx");
		textFieldFreqCardiaca.setColumns(10);
		
		textFieldTempCorporal = new JTextField();
		painelExpandido2.add(textFieldTempCorporal, "cell 0 1,growx");
		textFieldTempCorporal.setColumns(10);
		
		lblOximetria = new JLabel("Oximetria do pulso");
		painelExpandido2.add(lblOximetria, "flowx,cell 1 1");
		
		textFieldOximetria = new JTextField();
		painelExpandido2.add(textFieldOximetria, "cell 1 1,growx");
		textFieldOximetria.setColumns(10);
		
		lbIndiceFluxoResp = new JLabel("\u00CDndice de pico do fluxo respirat\u00F3rio");
		painelExpandido2.add(lbIndiceFluxoResp, "flowx,cell 0 2");
		
		textFieldIndiceFluxoResp = new JTextField();
		painelExpandido2.add(textFieldIndiceFluxoResp, "cell 0 2,growx");
		textFieldIndiceFluxoResp.setColumns(10);
		
		btnConcluirTriagem = new JButton("Concluir Triagem");
		add(btnConcluirTriagem, "flowx,cell 0 7");
		
		btnIrParaFila = new JButton("Ir para as filas de atendimento");
		add(btnIrParaFila, "cell 0 7");
		
		btnGroupProc = new ButtonGroup();
		btnGroupProc.add(radioButtonSimProc);
		btnGroupProc.add(radioButtonNaoProc);
		
		lblAviso = new JLabel("");
<<<<<<< HEAD
		add(lblAviso, "cell 0 0");
		
		btnLimpar = new JButton("Limpar");
		add(btnLimpar, "cell 0 7");
=======
		add(lblAviso, "cell 0 0,alignx right");
>>>>>>> branch 'master' of https://github.com/cavanhas/ProjetoFinalPOOEstrutura
		
	}
	
	public void expandeFormulario() {
		painelExpandido.setVisible(true);
	}
	
	public void expandeFormulario2() {
		painelExpandido2.setVisible(true);
	}
	
	public void recolheFormulario() {
		painelExpandido.setVisible(false);
	}
	
	public void recolheFormulario2() {
		painelExpandido2.setVisible(false);
	}
	
	public void limparCampos() {
		
		getCheckBoxApneia().setSelected(false);
		getCheckBoxConfuso().setSelected(false);
		getCheckBoxDesorientado().setSelected(false);
		getCheckBoxDorAguda().setSelected(false);
		getCheckBoxEntubado().setSelected(false);
		getCheckBoxLetargico().setSelected(false);
		getCheckBoxRisco().setSelected(false);
		getCheckBoxSemPulso().setSelected(false);
		getCheckBoxSemReacao().setSelected(false);
		getbGroup().clearSelection();
		getBtnGroupProc().clearSelection();
		getTextFieldFreqCardiaca().setText("");
		getTextFieldFreqRespiratoria().setText("");
		getTextFieldIndiceFluxoResp().setText("");
		getTextFieldOximetria().setText("");
		getTextFieldTempCorporal().setText("");
		getLblAviso().setText("");
		
	}
	
	public ButtonGroup getBtnGroupProc() {
		return btnGroupProc;
	}

	public void setBtnGroupProc(ButtonGroup btnGroupProc) {
		this.btnGroupProc = btnGroupProc;
	}

	public ButtonGroup getbGroup() {
		return bGroup;
	}

	public void setbGroup(ButtonGroup bGroup) {
		this.bGroup = bGroup;
	}

	public JRadioButton getRadioBtnSimProc() {
		return radioButtonSimProc;
	}

	public void setRadioBtnSimProc(JRadioButton radioBtnSimProc) {
		this.radioButtonSimProc = radioBtnSimProc;
	}

	public JRadioButton getRadioBtnNaoProc() {
		return radioButtonNaoProc;
	}

	public void setRadioBtnNaoProc(JRadioButton radioBtnNaoProc) {
		this.radioButtonNaoProc = radioBtnNaoProc;
	}

	public JCheckBox getCheckBoxEntubado() {
		return checkBoxEntubado;
	}

	public void setCheckBoxEntubado(JCheckBox checkBoxEntubado) {
		this.checkBoxEntubado = checkBoxEntubado;
	}

	public JCheckBox getCheckBoxApneia() {
		return checkBoxApneia;
	}

	public void setCheckBoxApneia(JCheckBox checkBoxApneia) {
		this.checkBoxApneia = checkBoxApneia;
	}

	public JCheckBox getCheckBoxSemPulso() {
		return checkBoxSemPulso;
	}

	public void setCheckBoxSemPulso(JCheckBox checkBoxSemPulso) {
		this.checkBoxSemPulso = checkBoxSemPulso;
	}

	public JCheckBox getCheckBoxSemReacao() {
		return checkBoxSemReacao;
	}

	public void setCheckBoxSemReacao(JCheckBox checkBoxSemReacao) {
		this.checkBoxSemReacao = checkBoxSemReacao;
	}

	public JCheckBox getCheckBoxRisco() {
		return checkBoxRisco;
	}

	public void setCheckBoxRisco(JCheckBox checkBoxRisco) {
		this.checkBoxRisco = checkBoxRisco;
	}

	public JCheckBox getCheckBoxConfuso() {
		return checkBoxConfuso;
	}

	public void setCheckBoxConfuso(JCheckBox checkBoxConfuso) {
		this.checkBoxConfuso = checkBoxConfuso;
	}

	public JCheckBox getCheckBoxDesorientado() {
		return checkBoxDesorientado;
	}

	public void setCheckBoxDesorientado(JCheckBox checkBoxDesorientado) {
		this.checkBoxDesorientado = checkBoxDesorientado;
	}

	public JCheckBox getCheckBoxLetargico() {
		return checkBoxLetargico;
	}

	public void setCheckBoxLetargico(JCheckBox checkBoxLetargico) {
		this.checkBoxLetargico = checkBoxLetargico;
	}

	public JCheckBox getCheckBoxDorAguda() {
		return checkBoxDorAguda;
	}

	public void setCheckBoxDorAguda(JCheckBox checkBoxDorAguda) {
		this.checkBoxDorAguda = checkBoxDorAguda;
	}

	public JRadioButton getRadioButtonSim() {
		return radioButtonSim;
	}

	public void setRadioButtonSim(JRadioButton radioButtonSim) {
		this.radioButtonSim = radioButtonSim;
	}

	public JRadioButton getRadioButtonNao() {
		return radioButtonNao;
	}

	public void setRadioButtonNao(JRadioButton radioButtonNao) {
		this.radioButtonNao = radioButtonNao;
	}

	public JPanel getPainelExpandido() {
		return painelExpandido;
	}

	public void setPainelExpandido(JPanel painelExpandido) {
		this.painelExpandido = painelExpandido;
	}

	public JPanel getPainelExpandido2() {
		return painelExpandido2;
	}

	public void setPainelExpandido2(JPanel painelExpandido2) {
		this.painelExpandido2 = painelExpandido2;
	}

	public JTextField getTextFieldFreqCardiaca() {
		return textFieldFreqCardiaca;
	}

	public void setTextFieldFreqCardiaca(JTextField textFieldFreqCardiaca) {
		this.textFieldFreqCardiaca = textFieldFreqCardiaca;
	}

	public JTextField getTextFieldFreqRespiratoria() {
		return textFieldFreqRespiratoria;
	}

	public void setTextFieldFreqRespiratoria(JTextField textFieldFreqRespiratoria) {
		this.textFieldFreqRespiratoria = textFieldFreqRespiratoria;
	}

	public JTextField getTextFieldTempCorporal() {
		return textFieldTempCorporal;
	}

	public void setTextFieldTempCorporal(JTextField textFieldTempCorporal) {
		this.textFieldTempCorporal = textFieldTempCorporal;
	}

	public JTextField getTextFieldOximetria() {
		return textFieldOximetria;
	}

	public void setTextFieldOximetria(JTextField textFieldOximetria) {
		this.textFieldOximetria = textFieldOximetria;
	}

	public JTextField getTextFieldIndiceFluxoResp() {
		return textFieldIndiceFluxoResp;
	}

	public void setTextFieldIndiceFluxoResp(JTextField textFieldIndiceFluxoResp) {
		this.textFieldIndiceFluxoResp = textFieldIndiceFluxoResp;
	}

	public JButton getBtnConcluirTriagem() {
		return btnConcluirTriagem;
	}

	public void setBtnConcluirTriagem(JButton btnConcluirTriagem) {
		this.btnConcluirTriagem = btnConcluirTriagem;
	}

	public JButton getBtnIrParaFila() {
		return btnIrParaFila;
	}

	public void setBtnIrParaFila(JButton btnIrParaFila) {
		this.btnIrParaFila = btnIrParaFila;
	}
<<<<<<< HEAD

	public JLabel getLblAviso() {
		return lblAviso;
	}

	public void setLblAviso(JLabel lblAviso) {
		this.lblAviso = lblAviso;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}
=======
>>>>>>> branch 'master' of https://github.com/cavanhas/ProjetoFinalPOOEstrutura

	public JLabel getLblAviso() {
		return lblAviso;
	}

	public void setLblAviso(JLabel lblAviso) {
		this.lblAviso = lblAviso;
	}
	
	
	
}
