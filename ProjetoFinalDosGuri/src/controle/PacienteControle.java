package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dao.PacienteDao;
import modelo.Atendimento;
import modelo.ListaPacientes;
import modelo.Paciente;
import visão.TelaPrincipal;

public class PacienteControle implements ActionListener {

	private Paciente pa;
	private TelaPrincipal tp;
	private PacienteDao dao;
	private int i = 0, j = 0;

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
		this.tp.getTmedico().getBtnChamarPaciente().addActionListener(this);
		this.tp.getTmedico().getBtnRelatrios().addActionListener(this);
		this.tp.getMntmSair().addActionListener(this);
		this.tp.getMntmExibeRelat().addActionListener(this);
		this.tp.getTandamento().getBtnEncerrarAtendimento().addActionListener(this);
		dao = new PacienteDao();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		//troca para a tela de cadastro
		if (e.getActionCommand().equals("menuCad")) {
			this.tp.setContentPane(this.tp.getTcad());
			this.tp.revalidate();
			this.tp.repaint();
		}

		//troca para a tela de controle
		if (e.getActionCommand().equals("menuCon")) {
			this.tp.setContentPane(this.tp.getTcon());
			this.tp.revalidate();
			this.tp.repaint();
		}

		//troca para a tela de atendimento
		if (e.getActionCommand().equals("menuAtend")) {
			this.tp.setContentPane(this.tp.getTatend());
			this.tp.revalidate();
			this.tp.repaint();
		}

		//troca para a tela das filas de atendimento, assim como exibe o próximo paciente a ser atendido e o número de pacientes em cada fila
		if (e.getActionCommand().equals("menuMedico")
				|| e.getActionCommand().equals("Ir para as filas de atendimento")) {

			this.tp.setContentPane(this.tp.getTmedico());
			this.tp.revalidate();
			this.tp.repaint();

			Atendimento proximo = dao.listarPacientes();
			
			if (proximo != null) {
				this.tp.getTmedico().getLblProximoPacDesc()
						.setText(proximo.getP().getNome() + "          Senha: " + proximo.getSenha());
			} else {
				this.tp.getTmedico().getLblProximoPacDesc().setText("Não há pacientes na fila");
			}

			dao.exibirFilas(tp);

		}

		//Realiza o cadastro de um paciente
		if (e.getActionCommand().equals("Cadastrar")) {
			String nomeaux = this.tp.getTcad().getTextFieldnome().getText();
			String cpfaux = this.tp.getTcad().getTextFieldcpf().getText();
			String dataaux = this.tp.getTcad().getTextFieldData().getText();

			Paciente p = new Paciente(cpfaux, nomeaux, dataaux);

			dao.cadastrarPaciente(p);

			this.tp.getTcad().limpar();

		}

		//Fecha o programa
		if (e.getActionCommand().equals("menuSair")) {
			System.exit(0);
		}

		//Limpa os TextFields da tela de cadastro
		if (e.getActionCommand().equals("Limpar")) {
			this.tp.getTcad().limpar();
		}

		//Consulta se o cpf informado existe na lista de pacientes cadastrados
		if (e.getActionCommand().equals("Consultar")) {

			String cpf = this.tp.getTcon().getTextFieldCpfPaciente().getText();

			Paciente p = dao.consultarPaciente(cpf);

			if (p != null) {
				this.tp.getTcon().mostrarSenha();
				this.tp.getTcon().getLabelStatus().setText("Paciente encontrado");
			} else {
				this.tp.getTcon().getLabelStatus().setText("Paciente não encontrado");
			}
		}

		//Encaminha o paciente para o atendimento
		if (e.getActionCommand().equals("Encaminhar para Atendimento")) {

			String cpf = this.tp.getTcon().getTextFieldCpfPaciente().getText();
			String senha = this.tp.getTcon().getTextFieldSenha().getText();

			Paciente p = dao.consultarPaciente(cpf);

			if (p != null) {
				Date dataHora = new Date();
				Atendimento at = new Atendimento(p, senha, dataHora);
				dao.filaAtendimento(at);
			} else {
				this.tp.getTcon().getLabelStatus().setText("Paciente não encontrado");
			}

			this.tp.getTcon().getTextFieldCpfPaciente().setText("");
			this.tp.getTcon().getTextFieldSenha().setText("");
			
			this.tp.setContentPane(this.tp.getTatend());
			this.tp.revalidate();
			this.tp.repaint();

		}

		//Chama uma senha
		if (e.getActionCommand().equals("Chamar senha")) {
			String senha = dao.chamarSenha();

			if (senha != null) {
				this.tp.getTatend().getTextFieldSenha().setText(senha);
			} else {
				this.tp.getTatend().getTextFieldSenha().setText("Não há pacientes na fila de atendimento");
			}
		}

		//Inicia o atendimento
		if (e.getActionCommand().equals("Iniciar atendimento")) {
			this.tp.setContentPane(this.tp.getTtriagem());
			this.tp.revalidate();
			this.tp.repaint();

			this.tp.getTatend().limpar();
		}

		//Redireciona para a tela de relatórios
		if (e.getActionCommand().equals("menuRelatorio") || e.getActionCommand().equals("Relat\u00F3rios")) {
			
			this.tp.setContentPane(this.tp.getTrelat());
			this.tp.revalidate();
			this.tp.repaint();
			
			

		}

		//Conclui a triagem
		if (e.getActionCommand().equals("Concluir Triagem")) {

				
			if(tp.getTtriagem().getCheckBoxEntubado().isSelected() || tp.getTtriagem().getCheckBoxApneia().isSelected()
					|| tp.getTtriagem().getCheckBoxSemPulso().isSelected() || tp.getTtriagem().getCheckBoxSemReacao().isSelected()) {
					dao.realizaTriagem(1);
			}
			else if(tp.getTtriagem().getCheckBoxRisco().isSelected() || tp.getTtriagem().getCheckBoxConfuso().isSelected()
					|| tp.getTtriagem().getCheckBoxDesorientado().isSelected() || tp.getTtriagem().getCheckBoxLetargico().isSelected()
					|| tp.getTtriagem().getCheckBoxDorAguda().isSelected()) {
					dao.realizaTriagem(2);
			}
			else if(tp.getTtriagem().getRadioButtonSim().isSelected() && tp.getTtriagem().getRadioBtnSimProc().isSelected()) {
				if(Integer.parseInt(tp.getTtriagem().getTextFieldFreqCardiaca().getText()) > 90
						|| Integer.parseInt(tp.getTtriagem().getTextFieldFreqRespiratoria().getText()) > 20
						|| (Integer.parseInt(tp.getTtriagem().getTextFieldTempCorporal().getText()) < 36
								|| Integer.parseInt(tp.getTtriagem().getTextFieldTempCorporal().getText()) > 38)
						|| (Integer.parseInt(tp.getTtriagem().getTextFieldOximetria().getText()) < 90)
						|| (Integer.parseInt(tp.getTtriagem().getTextFieldIndiceFluxoResp().getText()) < 200)) {
						dao.realizaTriagem(2);
				} else {
					dao.realizaTriagem(3);
				}
			}
			else if(tp.getTtriagem().getRadioButtonSim().isSelected() && tp.getTtriagem().getRadioBtnNaoProc().isSelected()) {
				dao.realizaTriagem(4);
			}
			else if(tp.getTtriagem().getRadioButtonNao().isSelected()) {
				dao.realizaTriagem(5);
			}

		}

		//Chama o próximo paciente, de acordo com as filas de prioridade
		if (e.getActionCommand().equals("Chamar paciente")) {
			
			this.tp.setContentPane(this.tp.getTandamento());
			this.tp.revalidate();
			this.tp.repaint();
			
			Atendimento aux = dao.listarPacientes();
			
			if(aux != null) {
				
				this.tp.getTandamento().getLblPacienteAtendido().setText(aux.getP().getNome());
				this.tp.getTandamento().getLblHoraAtendimento().setText(aux.getDataHora().toString());
				
				Atendimento at = dao.terminarAtendimento(aux);
				
				// Realiza a media do tempo de espera
				i++;
				dao.atualizarHora();
				Date data1 = new Date();
				Date data2 = at.getDataHora();
				long m1 = data1.getTime();
				long m2 = data2.getTime();
				long resultado = m1 - m2;
				long media = resultado/(long)i;
				this.tp.getTrelat().getLblInfoTempoEspera().setText(String.format("%03d:%02d:%02d", 
						media/3600000, (media/60000) % 60, (media/1000) % 60));
				
				Atendimento aux2 = dao.listarPacientes();
				if(aux2 != null) {
					this.tp.getTmedico().getLblProximoPacDesc()
					.setText(aux2.getP().getNome() + "          Senha: " + aux2.getSenha());
				} else {
					this.tp.getTmedico().getLblProximoPacDesc()
					.setText("Não há pacientes em espera");
				}
				
			}
			else {
				this.tp.getTmedico().getLblProximoPacDesc()
				.setText("Não há pacientes em espera");
			}
		}
		
		//Encerra o atendimento
		if (e.getActionCommand().equals("Encerrar atendimento")) {
			
			Atendimento at = dao.retornarPrimeiroEncerrado();

			if(at != null) {
				j++;
				dao.atualizarHora();
				Date data1 = new Date();
				Date data2 = at.getDataHora();
				long m1 = data1.getTime();
				long m2 = data2.getTime();
				long resultado = m1 - m2;
				long media = resultado/(long)i;
				this.tp.getTrelat().getLblInfoTempoAtendimento().setText(String.format("%03d:%02d:%02d", 
						media/3600000, (media/60000) % 60, (media/1000) % 60));

			} else {
				System.out.println("Dhiemison");
			}
									
		}

	}
	
	

}