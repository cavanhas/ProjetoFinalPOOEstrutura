package controle;

import modelo.Paciente;
import visão.TelaPrincipal;

public class App {
	public static void main(String[] args) {
		
		TelaPrincipal t = new TelaPrincipal();
		t.setVisible(true);
		Paciente p = new Paciente();
		PacienteControle pcon = new PacienteControle(p, t);
		
		// Comentário teste
		
	} 
}
