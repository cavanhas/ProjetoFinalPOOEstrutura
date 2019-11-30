package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dao.PacienteDao;
import modelo.Atendimento;
import modelo.Lista;
import modelo.Paciente;
import visão.TelaPrincipal;

public class PacienteControle implements ActionListener {
	
	private Paciente pa;
	private TelaPrincipal tp;
	private PacienteDao dao;

	public PacienteControle(Paciente pa, TelaPrincipal tp) {
		this.pa = pa;
		this.tp = tp;
		this.tp.getMntmCadastrarNovoPaciente().addActionListener(this);
		this.tp.getMntmProcurarUmPaciente().addActionListener(this);
		this.tp.getMntmAtendimento().addActionListener(this);
		this.tp.getMntmChamarUmNovo().addActionListener(this);
		this.tp.getTcad().getBtnCadastrar().addActionListener(this);
		this.tp.getTcad().getBtnLimpar().addActionListener(this);
		this.tp.getTcon().getBtnConsultar().addActionListener(this);
		this.tp.getTcon().getBtnEncaminharParaAtendimento().addActionListener(this);
		this.tp.getTatend().getBtnChamarSenha().addActionListener(this);
		this.tp.getTatend().getBtnIniciarAtendimento().addActionListener(this);
		this.tp.getTtriagem().getBtnConcluirTriagem().addActionListener(this);
		this.tp.getTtriagem().getBtnIrParaFila().addActionListener(this);
		this.tp.getTtriagem().getBtnConcluirTriagem().addActionListener(this);
		this.tp.getMntmSair().addActionListener(this);
		dao = new PacienteDao();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("menuCad")) {
			this.tp.setContentPane(this.tp.getTcad());
			this.tp.revalidate();
			this.tp.repaint();
		}
		
		if(e.getActionCommand().equals("menuCon")) {
			this.tp.setContentPane(this.tp.getTcon());
			this.tp.revalidate();
			this.tp.repaint();
		}
		
		if(e.getActionCommand().equals("menuAtend")) {
			this.tp.setContentPane(this.tp.getTatend());
			this.tp.revalidate();
			this.tp.repaint();
		}
		
		if(e.getActionCommand().equals("menuMedico") || e.getActionCommand().equals("Ir para as filas de atendimento")) {
			this.tp.setContentPane(this.tp.getTmedico());
			this.tp.revalidate();
			this.tp.repaint();
			
			
//			Atendimento at = new Atendimento();
//			while(at != null) {
//				at = dao.listarPacientes();
//				
//				this.tp.getTmedico().getTextArea().set;
//			}
		}
		
		if (e.getActionCommand().equals("Cadastrar")) {
			String nomeaux = this.tp.getTcad().getTextFieldnome().getText();
			String cpfaux = this.tp.getTcad().getTextFieldcpf().getText();
			String dataaux = this.tp.getTcad().getTextFieldData().getText();

			Paciente p = new Paciente(cpfaux, nomeaux, dataaux);

			dao.cadastrarPaciente(p);

			this.tp.getTcad().limpar();
			
		}
		
		if(e.getActionCommand().equals("menuSair")){
			System.exit(0);
		}
		
		if (e.getActionCommand().equals("Limpar")) {
			this.tp.getTcad().limpar();
		}
		
		if(e.getActionCommand().equals("Consultar")) {
			
			String cpf = this.tp.getTcon().getTextFieldCpfPaciente().getText();
			
			Paciente p = dao.consultarPaciente(cpf);
			
			if(p != null) {
				this.tp.getTcon().mostrarSenha();
				this.tp.getTcon().getLabelStatus().setText("Paciente encontrado");
			}
			else {
				this.tp.getTcon().getLabelStatus().setText("Paciente não encontrado");
			}		
		}
		
		if(e.getActionCommand().equals("Encaminhar para Atendimento")) {
			
			String cpf = this.tp.getTcon().getTextFieldCpfPaciente().getText();
			String senha = this.tp.getTcon().getTextFieldSenha().getText();
			
			Paciente p = dao.consultarPaciente(cpf);
			
			Date data = new Date();
			Date hora  = new Date();
			
			Atendimento at = new Atendimento(p, senha, data, hora);
			
			if(p != null) {
				dao.filaAtendimento(at);
			}
			else {   
				this.tp.getTcon().getLabelStatus().setText("Paciente não encontrado");
			}
			
			this.tp.getTcon().getTextFieldCpfPaciente().setText("");
			this.tp.getTcon().getTextFieldSenha().setText("");
			
		}
		
		if(e.getActionCommand().equals("Chamar senha")) {
			String senha = dao.chamarSenha();
			
			if(senha != null) {
				this.tp.getTatend().getTextFieldSenha().setText(senha);
			}
			else {
				this.tp.getTatend().getTextFieldSenha().setText("Não há pacientes na fila de atendimento");
			}
		}
		
		if(e.getActionCommand().equals("Iniciar atendimento")) {
			this.tp.setContentPane(this.tp.getTtriagem());
			this.tp.revalidate();
			this.tp.repaint();
		}
		
		if(e.getActionCommand().equals("Concluir Triagem")) {
			
			boolean retorno = dao.realizaTriagem(tp);
			
			if(retorno != false) {
				System.out.println("Triagem concluída. Paciente em espera");
			} else {
				System.out.println("Ocorreu algum erro");
			}
			
		}
		
	}
	
}