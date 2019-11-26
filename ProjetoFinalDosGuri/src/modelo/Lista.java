package modelo;

public class Lista {
	
	private No primeiro;
	
	public Lista() {
		// TODO Auto-generated constructor stub
		this.primeiro = null;
	}
	
	public boolean estaVazia(){
		if(this.primeiro == null){
			return true;
		}
		return false;
	}
	
	public void addPaciente(Paciente pac){
		
		if(estaVazia()){
			No novo = new No();
			novo.setPac(pac);
			novo.setProximo(this.primeiro);
			this.primeiro = novo;
		} else {
			No novo = new No();
			novo.setPac(pac);
			No aux = this.primeiro;
			while(aux.getProximo() != null){
				aux = aux.getProximo();
			}
			aux.setProximo(novo);
		}
		
	}

}
