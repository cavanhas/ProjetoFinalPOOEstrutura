package modelo;

public class Lista {
	
	private NoPaciente primeiro;
	
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
			
			NoPaciente novo = new NoPaciente();
			novo.setPac(pac);
			novo.setProximo(this.primeiro);
			this.primeiro = novo;
		
		} else {
			
			NoPaciente novo = new NoPaciente();
			novo.setPac(pac);
			
			NoPaciente aux = this.primeiro;
			
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
					
					NoPaciente aux2 = this.primeiro;
					
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
	
	//Busca paciente na lista pelo cpf
	public Paciente bucarPaciente(String cpf) {
		
		NoPaciente aux;
		aux = primeiro;
		
		while(aux != null) {
			
			if(aux.getPac().getCpf().equals(cpf)) {
				
				return aux.getPac();
				
			}
			
			aux = aux.getProximo();
		}
		
		return null;
		
	}
	
	public void removerPaciente() {
		
	}
	
	public void exibirLista() {
		
		NoPaciente aux;
		
		for(aux = this.primeiro; aux != null; aux = aux.getProximo()) {
			System.out.println(aux.getPac().getNome());
		}
		
	}
	
	public void limpar() {
		primeiro = null;
	}

}
