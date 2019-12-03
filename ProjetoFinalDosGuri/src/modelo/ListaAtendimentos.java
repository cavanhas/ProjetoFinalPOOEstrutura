package modelo;

public class ListaAtendimentos {
	
	private NoAtendimento primeiro;
	
	public ListaAtendimentos() {
		// TODO Auto-generated constructor stub
		this.primeiro = null;
	}
	
	public boolean estaVazia(){
		if(this.primeiro == null){
			return true;
		}
		return false;
	}
	
	public void addAtendimento(Atendimento at) {
			
		NoAtendimento novo = new NoAtendimento();
		novo.setAt(at);
		novo.setProximo(this.primeiro);
		this.primeiro = novo;
		
	}
	
	public void exibirLista() {
		
		NoAtendimento aux;
		
		for(aux = this.primeiro; aux != null; aux = aux.getProximo()) {
			System.out.println(aux.getAt().getP().getNome());
		}
		
	}
	
	public Atendimento retornarPrimeiro() {
		NoAtendimento aux = this.primeiro;
		if(aux != null) {
			return aux.getAt();
		}		
		return null;
	}
	
	public void limpar() {
		primeiro = null;
	}

}
