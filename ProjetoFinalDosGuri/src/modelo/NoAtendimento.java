package modelo;

public class NoAtendimento {
	
	private NoAtendimento proximo;
	private Atendimento at;
	
	public NoAtendimento() {

	}

	public NoAtendimento getProximo() {
		return proximo;
	}

	public void setProximo(NoAtendimento proximo) {
		this.proximo = proximo;
	}

	public Atendimento getAt() {
		return at;
	}

	public void setAt(Atendimento at) {
		this.at = at;
	}

}
