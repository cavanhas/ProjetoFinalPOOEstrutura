package visão;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuItem mntmCadastrarNovoPaciente;
	private TelaCadastro tcad;
	private TelaConsulta tcon;
	private TelaAtendimento tatend;
	private TelaTriagem ttriagem;
	//private TelaConsultaMedica tmedico;
	private JMenuItem mntmProcurarUmPaciente;
	private JMenuItem mntmAtendimento;
	private JMenuItem mntmSair;
	private JMenu mnMdico;
	private JMenuItem mntmChamarUmNovo;
	private JPanel panel;
	private JLabel lblImg;

	public TelaPrincipal() {
		setTitle("Sistema de Controle de Emerg\u00EAncia Hospitalar");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmCadastrarNovoPaciente = new JMenuItem("Cadastrar novo paciente");
		mntmCadastrarNovoPaciente.setActionCommand("menuCad");
		mnFile.add(mntmCadastrarNovoPaciente);
		
		mntmProcurarUmPaciente = new JMenuItem("Procurar um paciente");
		getMntmProcurarUmPaciente().setActionCommand("menuCon");
		mnFile.add(mntmProcurarUmPaciente);
		
		mntmAtendimento = new JMenuItem("Atendimento");
		mntmAtendimento.setActionCommand("menuAtend");
		mnFile.add(mntmAtendimento);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.setActionCommand("menuSair");
		mnFile.add(mntmSair);
		
		mnMdico = new JMenu("M\u00E9dico");
		menuBar.add(mnMdico);
		
		mntmChamarUmNovo = new JMenuItem("Iniciar uma consulta");
		mntmChamarUmNovo.setActionCommand("menuMedico");
		mnMdico.add(mntmChamarUmNovo);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		lblImg = new JLabel(new ImageIcon(TelaCadastro.class.getResource("/img/ufcspa.png"))); 
		lblImg.setBackground(new Color(102, 205, 170));
		panel.add(lblImg, "cell 0 0,alignx center");
		lblImg.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblImg);
		
		/*tcad = new TelaCadastro();
		tcon = new TelaConsulta();
		tatend = new TelaAtendimento();
		ttriagem = new TelaTriagem();*/
		//tmedico = new TelaConsultaMedica();
		
	}

	public JMenuItem getMntmCadastrarNovoPaciente() {
		return mntmCadastrarNovoPaciente;
	}

	public void setMntmCadastrarNovoPaciente(JMenuItem mntmCadastrarNovoPaciente) {
		this.mntmCadastrarNovoPaciente = mntmCadastrarNovoPaciente;
	}

	public TelaCadastro getTcad() {
		return tcad;
	}

	public void setTcad(TelaCadastro tcad) {
		this.tcad = tcad;
	}
	

	public TelaConsulta getTcon() {
		return tcon;
	}	

	public void setTcon(TelaConsulta tcon) {
		this.tcon = tcon;
	}
	
	public JMenuItem getMntmProcurarUmPaciente() {
		return mntmProcurarUmPaciente;
	}

	public void setMntmProcurarUmPaciente(JMenuItem mntmProcurarUmPaciente) {
		this.mntmProcurarUmPaciente = mntmProcurarUmPaciente;
	}

	public TelaAtendimento getTatend() {
		return tatend;
	}

	public void setTatend(TelaAtendimento tatend) {
		this.tatend = tatend;
	}

	public JMenuItem getMntmAtendimento() {
		return mntmAtendimento;
	}

	public void setMntmAtendimento(JMenuItem mntmAtendimento) {
		this.mntmAtendimento = mntmAtendimento;
	}

	public JMenuItem getMntmSair() {
		return mntmSair;
	}

	public void setMntmSair(JMenuItem mntmSair) {
		this.mntmSair = mntmSair;
	}

	public TelaTriagem getTtriagem() {
		return ttriagem;
	}

	public void setTtriagem(TelaTriagem ttriagem) {
		this.ttriagem = ttriagem;
	}

	public JMenuItem getMntmChamarUmNovo() {
		return mntmChamarUmNovo;
	}

	public void setMntmChamarUmNovo(JMenuItem mntmChamarUmNovo) {
		this.mntmChamarUmNovo = mntmChamarUmNovo;
	}

	/*public TelaConsultaMedica getTmedico() {
		return tmedico;
	}

	public void setTmedico(TelaConsultaMedica tmedico) {
		this.tmedico = tmedico;
	}*/
	
	
	
}
