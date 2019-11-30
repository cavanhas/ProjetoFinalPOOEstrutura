package modelo;

import java.text.DateFormat;
import java.util.Date;

public class Atendimento {
	
	private Paciente p;
	private String senha;
	private Date data;
	private Date hora;
	
	public Atendimento() {
		
	}

	public Atendimento(Paciente p, String senha, Date dataHora, Date hora) {
		super();
		this.p = p;
		this.senha = senha;
		this.data = dataHora;
		this.setHora(hora);
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
		return data;
	}

	public void setDataHora(Date dataHora) {
		this.data = dataHora;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
	
}
