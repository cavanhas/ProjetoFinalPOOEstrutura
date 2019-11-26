package modelo;

import java.util.Date;

public class Paciente {
	private String cpf;
	private String nome;
	private String dataNasc;

	public Paciente(String cpf, String nome, String dataaux) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = dataaux;
	}

	public Paciente() {

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	

}
