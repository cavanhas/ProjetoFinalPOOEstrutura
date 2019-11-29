package modelo;

import java.sql.Time;
import java.util.Date;

public class Atendimento {
	
	private Paciente p;
	private String senha;
	private Time hora;
	private Date data;
	
	public Atendimento() {
		
	}

	public Atendimento(Paciente p, String senha, Time hora, Date data) {
		super();
		this.p = p;
		this.senha = senha;
		this.hora = hora;
		this.data = data;
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

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
