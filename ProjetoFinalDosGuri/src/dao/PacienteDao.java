package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import modelo.Atendimento;
import modelo.Fila;
import modelo.ListaAtendimentos;
import modelo.ListaPacientes;
import modelo.Paciente;
import visão.TelaConsulta;
import visão.TelaPrincipal;
import visão.TelaTriagem;

public class PacienteDao {

	ListaPacientes listaCad = new ListaPacientes();
	ListaAtendimentos listaEncerrados = new ListaAtendimentos();
	Fila filaPac = new Fila();
	Fila filaP1 = new Fila();
	Fila filaP2 = new Fila();
	Fila filaP3 = new Fila();
	Fila filaP4 = new Fila();
	Fila filaP5 = new Fila();

	public PacienteDao() {

	}

	// Adiciona pacientes la lista de cadastro
	public boolean cadastrarPaciente(Paciente pac) {

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter("cadastro.txt", true);
			bw = new BufferedWriter(fw);

			bw.write(pac.getNome() + "#" + pac.getCpf() + "#" + pac.getDataNasc());
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				fw.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		listaCad.addPaciente(pac);

		return true;

	}

	public Paciente consultarPaciente(String cpf) {
		Paciente p = listaCad.bucarPaciente(cpf);

		if (p != null) {
			return p;
		} else {
			return null;
		}
	}

	// Colocando os pacientes na fila de atendimento
	public void filaAtendimento(Atendimento at) {

		DateFormat horaFormat = DateFormat.getTimeInstance(DateFormat.FULL);
		DateFormat dataFormat = DateFormat.getDateInstance(DateFormat.FULL);

		System.out.println("\n");
		System.out.println("Hora do atendimento: " + horaFormat.format(at.getDataHora()));
		System.out.println("Data do atendimento: " + dataFormat.format(at.getDataHora()));
		System.out.println("Nome do paciente: " + at.getP().getNome());

		filaPac.enfileira(at);

	}

	// chama uma senha caso a haja pacientes na fila
	public String chamarSenha() {
		if (filaPac.estaVazia() == true) {
			return null;
		} else {
			Atendimento a = filaPac.retornarPrimeiro();
			return a.getSenha();
		}
	}

	// Aloca o paciente na fila de prioridade correta
	public boolean realizaTriagem(int op) {

		Atendimento aux = filaPac.removerAtendimento();

		if (aux != null) {
			switch (op) {

			case 1:
				filaP1.enfileira(aux);
				return true;
				//break;
			case 2:
				filaP2.enfileira(aux);
				return true;
				//break;
			case 3:
				filaP3.enfileira(aux);
				return true;
				//break;
			case 4:
				filaP4.enfileira(aux);
				return true;
				//break;
			case 5:
				filaP5.enfileira(aux);
				return true;
				//break;
			}
		}
		
		return false;
	}

	// Retorna o próximo paciente a ser atendido
	public Atendimento listarPacientes() {

		Atendimento aux = null;

		if (filaP1.estaVazia() == true) {
			if (filaP2.estaVazia() == true) {
				if (filaP3.estaVazia() == true) {
					if (filaP4.estaVazia() == true) {
						if (filaP5.estaVazia() == true) {

						} else {
							aux = filaP5.retornarPrimeiro();
							return aux;
						}
					} else {
						aux = filaP4.retornarPrimeiro();
						return aux;
					}
				} else {
					aux = filaP3.retornarPrimeiro();
					return aux;
				}
			} else {
				aux = filaP2.retornarPrimeiro();
				return aux;
			}
		} else {
			aux = filaP1.retornarPrimeiro();
			return aux;
		}

		return aux;
	}

	// Retorna o número de pacientes em cada fila de prioridade
	public void exibirFilas(TelaPrincipal tp) {
		if (filaP1.estaVazia()) {
			tp.getTmedico().getLblFila1().setText(Integer.toString(0));
		} else {
			int p1 = filaP1.tamanhoFila();
			tp.getTmedico().getLblFila1().setText(Integer.toString(p1));
		}

		if (filaP2.estaVazia()) {
			tp.getTmedico().getLblFila2().setText(Integer.toString(0));
		} else {
			int p2 = filaP2.tamanhoFila();
			tp.getTmedico().getLblFila2().setText(Integer.toString(p2));
		}

		if (filaP3.estaVazia()) {
			tp.getTmedico().getLblFila3().setText(Integer.toString(0));
		} else {
			int p3 = filaP3.tamanhoFila();
			tp.getTmedico().getLblFila3().setText(Integer.toString(p3));
		}

		if (filaP4.estaVazia()) {
			tp.getTmedico().getLblFila4().setText(Integer.toString(0));
		} else {
			int p4 = filaP4.tamanhoFila();
			tp.getTmedico().getLblFila4().setText(Integer.toString(p4));
		}

		if (filaP5.estaVazia()) {
			tp.getTmedico().getLblFila5().setText(Integer.toString(0));
		} else {
			int p5 = filaP5.tamanhoFila();
			tp.getTmedico().getLblFila5().setText(Integer.toString(p5));
		}
	}

	// Remove o paciente que está sendo atendido e coloca ele na lista de
	// atendimentos acabados
	public boolean terminarAtendimento() {

		Atendimento aux = null;

		if (filaP1.estaVazia() == true) {
			if (filaP2.estaVazia() == true) {
				if (filaP3.estaVazia() == true) {
					if (filaP4.estaVazia() == true) {
						if (filaP5.estaVazia() == true) {

						} else {
							aux = filaP5.removerAtendimento();
							listaEncerrados.addAtendimento(aux);
							return true;
						}
					} else {
						aux = filaP4.removerAtendimento();
						listaEncerrados.addAtendimento(aux);
						return true;
					}
				} else {
					aux = filaP3.removerAtendimento();
					listaEncerrados.addAtendimento(aux);
					return true;
				}
			} else {
				aux = filaP2.removerAtendimento();
				listaEncerrados.addAtendimento(aux);
				return true;
			}
		} else {
			aux = filaP1.removerAtendimento();
			listaEncerrados.addAtendimento(aux);
			return true;
		}

		return false;

	}

	// Verifica se a fila de atendimento está vazia.
	public boolean atendimentoVazio() {
		if (filaPac.estaVazia() != true) {
			return false;
		}
		return true;
	}

	// Atualiza a hora dos objetos do tipo atendimento dentro da lista de
	// atendimentos acabados para a data e hora em que seu atendimento foi
	// finalizado
	public boolean atualizarHora() {
		Atendimento at = listaEncerrados.retornarPrimeiro();

		if (at != null) {
			Date data = new Date();
			at.setDataHora(data);
			return true;
		} else
			return false;
	}

	public Atendimento retornarPrimeiroEncerrado() {

		Atendimento aux = listaEncerrados.retornarPrimeiro();

		System.out.println("Teste: " + aux.getP().getNome());

		if (aux != null) {
			return aux;
		}
		return null;

	}
	
	public void exibirEncerrados() {
		listaEncerrados.exibirLista();
	}
}
