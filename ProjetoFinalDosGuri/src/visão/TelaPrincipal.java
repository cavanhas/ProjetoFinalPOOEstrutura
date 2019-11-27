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
	private JMenuItem mntmAtendimentoTeste;
	private TelaCadastro tcad;

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
		
		mntmAtendimentoTeste = new JMenuItem("Atendimento Teste");
		mntmAtendimentoTeste.setActionCommand("menuAtendimento");
		mnFile.add(mntmAtendimentoTeste);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tcad = new TelaCadastro();
		
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

	public JMenuItem getMntmAtendimentoTeste() {
		return mntmAtendimentoTeste;
	}

	public void setMntmAtendimentoTeste(JMenuItem mntmAtendimentoTeste) {
		this.mntmAtendimentoTeste = mntmAtendimentoTeste;
	}
	
}
