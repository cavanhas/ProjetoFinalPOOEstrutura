package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import modelo.Lista;
import modelo.Paciente;

public class PacienteDao {

	public PacienteDao() {
		
	}
	
	Lista listaCad = new Lista();
	
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
		
		listaCad.exibirLista();
		
		return true;
	}
	
	public Paciente consultarPaciente(String cpf) {
		Paciente p = listaCad.bucarPaciente(cpf);
		
		if(p == null) {
			System.out.println("Paciente NAO ENCONTRADO");
			return p;
		}
		else
			return null;
	}
	
}
