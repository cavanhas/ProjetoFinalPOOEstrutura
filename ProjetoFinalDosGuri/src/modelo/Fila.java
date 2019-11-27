package modelo;

public class Fila {

	private No primeiro;
	
	// Cria a fila vazia
	public Fila() {
		this.primeiro = null;
	}
	
	// Verifica se a fila está vazia
	public boolean estaVazia() {
		if(this.primeiro == null) {
			return true;
		}
		return false;
	}
	
	// Adiciona o paciente no final da fila
	public void addPaciente(Paciente pac) {
		
		if(estaVazia()) {
			
			No novo = new No();
			novo.setPac(pac);
			novo.setProximo(this.primeiro);
			this.primeiro = novo;
			
		} else {
			
			No novo = new No();
			novo.setPac(pac);
			
			No aux = this.primeiro;
			
			while(aux.getProximo() != null) {
				aux = aux.getProximo();
			}
			
			aux.setProximo(novo);
			
		}
		
	}
	
	// Remove e retorna o primeiro paciente
	public Paciente removerPaciente() {
		
		No aux = this.primeiro;
		this.primeiro = this.primeiro.getProximo();
		
		return aux.getPac();
		
	}
	
	// Retorna o próximo (primeiro) da fila
	public Paciente retornarPrimeiro() {
		
		return this.primeiro.getPac();
		
	}
	
	// Esvazia a fila
	public void esvaziarFila() {
		
		this.primeiro = null;
		
	}
	
	// Retorna o tamanho da fila
	public int tamanhoFila() {
		
		No aux;
		int tam = 0;
		
		for(aux = this.primeiro; aux != null; aux = aux.getProximo()) {
			tam++;
		}
		
		return tam;
		
	}
	
	// Exibe os pacientes na fila
	public void exibirFila() {
		
		No aux;
		
		for(aux = this.primeiro; aux != null; aux = aux.getProximo()) {
			System.out.println(aux.getPac().getNome());
		}
		
	}
	
}
