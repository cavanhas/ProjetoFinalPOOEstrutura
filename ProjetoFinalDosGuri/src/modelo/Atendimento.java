package modelo;

import java.text.DateFormat;
import java.util.Date;

public class Atendimento {
	
	private Paciente p;
	private String senha;
	private Date dataHora;
	
	public Atendimento() {
		
	}

	public Atendimento(Paciente p, String senha, Date dataHora) {
		super();
		this.p = p;
		this.senha = senha;
		this.dataHora = dataHora;
	}

	public Paciente getP() {
		return p;
	}
	
	public void setP(Paciente p) {
		this.p = p;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	
}
