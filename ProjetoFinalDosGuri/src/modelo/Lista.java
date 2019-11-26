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
	
	// Método para adicionar paciente no final da lista, em ordem alfabética
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
			
			int comparacao = novo.getPac().getNome().compareTo(aux.getPac().getNome());
			
			if(comparacao < 0) {
				
				if(aux == this.primeiro) {
					
					aux.setProximo(null);
					this.primeiro = novo;
					novo.setProximo(aux);
					
				} else {
					
					No aux2 = this.primeiro;
					
					while(aux2.getProximo() != aux) {
						aux2 = aux2.getProximo();
					}
					
					aux2.setProximo(novo);
					novo.setProximo(aux);
										
				}
				
			} else {
				
				aux.setProximo(novo);
				
			}
		
		}
		
	}
	
	public Paciente bucarPaciente(String cpf) {
		
		No aux;
		
		for(aux = this.primeiro; aux != null; aux = aux.getProximo()) {
			
			if(aux.getPac().getCpf() == cpf) {
				
				return aux.getPac();
				
			}
			
		}
		
		return null;
		
	}
	
	public void removerPaciente() {
		
	}
	
	// Exibição da lista (para testes)
	public void exibirLista() {
		
		No aux;
		
		for(aux = this.primeiro; aux != null; aux = aux.getProximo()) {
			System.out.println(aux.getPac().getNome());
		}
		
	}

}
