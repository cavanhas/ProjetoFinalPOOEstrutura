package modelo;

public class Fila {

	private NoAtendimento primeiro;
	
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
	
	// Adiciona o atendimento no final da fila
	public void enfileira(Atendimento at) {
		
		if(estaVazia()) {
			
			NoAtendimento novo = new NoAtendimento();
			novo.setAt(at);
			novo.setProximo(this.primeiro);
			this.primeiro = novo;
			
		} else {
			
			NoAtendimento novo = new NoAtendimento();
			novo.setAt(at);
			
			NoAtendimento aux = this.primeiro;
			
			while(aux.getProximo() != null) {
				aux = aux.getProximo();
			}
			
			aux.setProximo(novo);
			
		}
		
	}
	
	// Remove e retorna o primeiro atendimento
	public Atendimento removerAtendimento() {
		
		if(estaVazia()) {
			return null;
		} else {
			
			NoAtendimento aux = this.primeiro;
			this.primeiro = this.primeiro.getProximo();
			
			if(!estaVazia()) {
				this.primeiro.setProximo(null);
			}
			
			return aux.getAt();
		}
		
	}
	
	// Retorna o próximo (primeiro) da fila
	public Atendimento retornarPrimeiro() {
		
		return this.primeiro.getAt();
		
	}
	
	// Esvazia a fila
	public void esvaziarFila() {
		
		this.primeiro = null;
		
	}
	
	// Retorna o tamanho da fila
	public int tamanhoFila() {
		
		NoAtendimento aux;
		int tam = 0;
		
		for(aux = this.primeiro; aux != null; aux = aux.getProximo()) {
			tam++;
		}
		
		return tam;
		
	}
	
	// Exibe os atendimentos na fila
	public void exibirFila() {
		
		NoAtendimento aux;
		
		for(aux = this.primeiro; aux != null; aux = aux.getProximo()) {
			System.out.println(aux.getAt().getP().getNome());
		}
		
	}
	
	// Git ignorante
	
}
