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
import visão.TelaPrincipal;
import visão.TelaTriagem;

public class PacienteDao {
	
	Lista listaCad = new Lista();
	Fila filaPac = new Fila();
	Fila filaP1 = new Fila();
	Fila filaP2 = new Fila();
	Fila filaP3 = new Fila();
	Fila filaP4 = new Fila();
	Fila filaP5 = new Fila();

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
	
	// Aloca o paciente na fila de prioridade correta
	public boolean realizaTriagem(TelaPrincipal tp) {
			
		Atendimento aux = new Atendimento();
		
		aux = filaPac.removerAtendimento();
			
		if(tp.getTtriagem().getCheckBoxEntubado().isSelected() || tp.getTtriagem().getCheckBoxApneia().isSelected()
				|| tp.getTtriagem().getCheckBoxSemPulso().isSelected() || tp.getTtriagem().getCheckBoxSemReacao().isSelected()) {
				filaP1.enfileira(aux);
				return true;
		}
		if(tp.getTtriagem().getCheckBoxRisco().isSelected() || tp.getTtriagem().getCheckBoxConfuso().isSelected()
				|| tp.getTtriagem().getCheckBoxDesorientado().isSelected() || tp.getTtriagem().getCheckBoxLetargico().isSelected()
				|| tp.getTtriagem().getCheckBoxDorAguda().isSelected()) {
			filaP2.enfileira(aux);
			return true;
		}
		if(tp.getTtriagem().getRadioButtonSim().isSelected() && tp.getTtriagem().getRadioBtnSimProc().isSelected()) {
			if(Integer.parseInt(tp.getTtriagem().getTextFieldFreqCardiaca().getText()) > 90
					|| Integer.parseInt(tp.getTtriagem().getTextFieldFreqRespiratoria().getText()) > 20
					|| (Integer.parseInt(tp.getTtriagem().getTextFieldTempCorporal().getText()) < 36
							|| Integer.parseInt(tp.getTtriagem().getTextFieldTempCorporal().getText()) > 38)
					|| (Integer.parseInt(tp.getTtriagem().getTextFieldOximetria().getText()) < 90)
					|| (Integer.parseInt(tp.getTtriagem().getTextFieldIndiceFluxoResp().getText()) < 200)) {
				filaP2.enfileira(aux);
				return true;
			} else {
				filaP3.enfileira(aux);
				return true;
			}
		}
		if(tp.getTtriagem().getRadioButtonSim().isSelected() && tp.getTtriagem().getRadioBtnNaoProc().isSelected()) {
			filaP4.enfileira(aux);
			return true;
		}
		if(tp.getTtriagem().getRadioButtonNao().isSelected()) {
			filaP5.enfileira(aux);
			return true;
		}
		
		return false;
			
	}
	
	public Atendimento listarPacientes() {
		
		Atendimento aux = null;
		
		if(filaP1.estaVazia() == true) {
			if(filaP2.estaVazia() == true) {
				if(filaP3.estaVazia() == true) {
					if(filaP4.estaVazia() == true) {
						if(filaP5.estaVazia() == true) {
							
						} else {
							aux = filaP5.retornarPrimeiro();
							return aux;
						}
					} else {
						aux = filaP4.retornarPrimeiro();
						return aux;
					}
				} else {
					aux = filaP3.retornarPrimeiro();
					return aux;
				}
			} else {
				aux = filaP2.retornarPrimeiro();
				return aux;
			}
		}
		else {
			aux = filaP1.retornarPrimeiro();
			return aux;
		}
		
		return aux;
	}
	
}
