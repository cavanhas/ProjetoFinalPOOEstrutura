package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import modelo.Atendimento;
import modelo.Fila;
import modelo.Lista;
import modelo.Paciente;

public class PacienteDao {
	
	Lista listaCad = new Lista();
	Fila filaPac = new Fila();

	public PacienteDao() {
		
	}
	
	//Adiciona pacientes la lista de cadastro
	public boolean cadastrarPaciente(Paciente pac) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter("cadastro.txt",true);
			bw = new BufferedWriter(fw);
			
			bw.write(pac.getNome()+"#"+pac.getCpf()+"#"+pac.getDataNasc());
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				fw.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		listaCad.addPaciente(pac);
		
		return true;
	}
	
	public Paciente consultarPaciente(String cpf) {
		Paciente p = listaCad.bucarPaciente(cpf);
		
		if(p != null) {
			return p;
		}
		else {
			return null;
		}
	}
	
	// Colocando os pacientes na fila de atendimento
	public void filaAtendimento(Atendimento at) {
		
		DateFormat horaFormat = DateFormat.getTimeInstance(DateFormat.FULL);
		DateFormat dataFormat = DateFormat.getDateInstance(DateFormat.FULL);
		
		System.out.println("Hora do atendimento: " + horaFormat.format(at.getDataHora()));
		System.out.println("Data do atendimento: " + dataFormat.format(at.getDataHora()));	
		System.out.println("Nome do paciente: " + at.getP().getNome());
		
		
		filaPac.enfileira(at);	
		
	}
	
	//chama uma senha caso a haja pacientes na fila
	public String chamarSenha() {
		if(filaPac.estaVazia() == true) {
			return null;
		}
		else {
			Atendimento a = filaPac.retornarPrimeiro();
			return a.getSenha(); 
		}
	}
	
}
