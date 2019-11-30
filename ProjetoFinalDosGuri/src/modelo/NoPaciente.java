package modelo;

public class NoPaciente {
	
	private NoPaciente proximo;
	private Paciente pac;
	
	public NoPaciente() {
		// TODO Auto-generated constructor stub
	}

	public NoPaciente getProximo() {
		return proximo;
	}

	public void setProximo(NoPaciente proximo) {
		this.proximo = proximo;
	}

	public Paciente getPac() {
		return pac;
	}

	public void setPac(Paciente pac) {
		this.pac = pac;
	}

}
