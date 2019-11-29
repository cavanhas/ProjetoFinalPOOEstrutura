package visão;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuItem mntmCadastrarNovoPaciente;
	private TelaCadastro tcad;
	private TelaConsulta tcon;
	private TelaAtendimento tatend;
	private JMenuItem mntmProcurarUmPaciente;
	private JMenuItem mntmAtendimento;
	private JMenuItem mntmSair;

	public TelaPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

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
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tcad = new TelaCadastro();
		tcon = new TelaConsulta();
		tatend = new TelaAtendimento();
		
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
	
	
}
