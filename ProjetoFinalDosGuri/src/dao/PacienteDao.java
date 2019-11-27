package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import modelo.Lista;
import modelo.Paciente;

public class PacienteDao {

	public PacienteDao() {
		
	}
	
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
		
//		Lista listaCad = new Lista();
//		
//		listaCad.addPaciente(pac);
//		
//		listaCad.exibirLista();
		
		return true;
	}
	
}
