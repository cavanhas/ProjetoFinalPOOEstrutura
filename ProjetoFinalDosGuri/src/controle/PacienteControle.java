package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import dao.PacienteDao;
import modelo.Paciente;
import vis�o.TelaPrincipal;

public class PacienteControle implements ActionListener {
	private Paciente pa;
	private TelaPrincipal tp;
	private PacienteDao dao;

	public PacienteControle(Paciente pa, TelaPrincipal tp) {
		this.pa = pa;
		this.tp = tp;
		this.tp.getMntmCadastrarNovoPaciente().addActionListener(this);
		this.tp.getTcad().getBtnCadastrar().addActionListener(this);
		this.tp.getTcad().getBtnLimpar().addActionListener(this);
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
	}
}
//TESTE NOVAMENTE