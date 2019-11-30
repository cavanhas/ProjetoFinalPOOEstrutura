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
		this.tp.getTcad().getBtnCadastrar().addActionListener(this);
		this.tp.getTcad().getBtnLimpar().addActionListener(this);
		this.tp.getTcon().getBtnConsultar().addActionListener(this);
		this.tp.getTcon().getBtnEncaminharParaAtendimento().addActionListener(this);
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
		
		if (e.getActionCommand().equals("Cadastrar")) {
			String nomeaux = this.tp.getTcad().getTextFieldnome().getText();
			String cpfaux = this.tp.getTcad().getTextFieldcpf().getText();
			String dataaux = this.tp.getTcad().getTextFieldData().getText();

			Paciente p = new Paciente(cpfaux, nomeaux, dataaux);

			dao.cadastrarPaciente(p);

			this.tp.getTcad().limpar();
			
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
			
			Atendimento at = new Atendimento(p, senha, data);
			
			if(p != null) {
				dao.filaAtendimento(at);
			}
			else {   
				this.tp.getTcon().getLabelStatus().setText("Paciente não encontrado");
			} 
			
		}	
	}
	
}