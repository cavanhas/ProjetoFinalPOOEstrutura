package controle;

import modelo.Fila;
import modelo.ListaPacientes;
import modelo.Paciente;
import vis�o.TelaPrincipal;

public class App {
	
	public static void main(String[] args) {
		
		//TelaPrincipal t = new TelaPrincipal();
		t.setVisible(true);
		Paciente p = new Paciente();
		PacienteControle pcon = new PacienteControle(p, t);
		
	}
	
}
