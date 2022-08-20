package sapo.Atividades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

import sapo.Tarefas.Tarefas;

import java.util.List;

public class Atividades {
    
    private String nome;
    private String cpf;
    private String descricao;
	// pensar em um nome melhor
	private Tarefas tarefa;
    private ArrayList<Tarefas> tarefas;
    private boolean concluida;
	private int tarefasConcluidas;
 
    public Atividades(String nome, String descricao, String cpf) {
    	this.nome = nome;
    	this.descricao = descricao;
    	this.cpf = cpf;
    	this.concluida = false;
    	
    	if(cpf.isEmpty() || cpf.isBlank()  ) {
    		throw new IllegalArgumentException("CPF VAZIO OU NULO");
    	}
    }

	public String getNome() {
		return this.nome;
	}
        
    public int getQuantidadeTarefas(){
        return this.tarefas.size();
    }

    public void cadastrarTarefa(Tarefas novaTarefa){
        tarefas.add(novaTarefa);
    }

    public void removerTarefa(String idTarefa){
        for(int i = 0; i < tarefas.size(); i++){
            if(this.tarefas.get(i).getCodigo() == idTarefa){
                this.tarefas.remove(i);
            }
        }
    }

	public void alterarDescricaoAtividade(String novaDescricao) {
		this.descricao = novaDescricao;
	}

	public void alterarResponsavelAtividade(String novoCpf) {
		this.cpf = novoCpf;
	}

	public String exibirAtividade(String codigo) {
		
		return codigo + ":" + this.nome
				+ "Responsável(s): " + this.getResponsaveisTarefa() + " – " + this.cpf
				+ "==="
				+ this.descricao
				+ "==="
				+ "Tarefas:" + this.tarefasConcluidas + "/" + tarefas.size()
				+ "-" +  tarefas.get(0)
				+ "-" +  tarefas.get(1)
				+ "-" +  tarefas.get(2);
	}

	public void concluirAtividade() {
        this.concluida = true;
    }

	public int getTarefasConcluidas() {
		for (Tarefas tarefas : this.tarefas) {
			if (tarefa.getConcluida() == true) {
				this.tarefasConcluidas += 1;
			}
		}
		return this.tarefasConcluidas;
	}

	public String getResponsaveisTarefa() {
		for (String chave : tarefa.keySet()) {
			return tarefa.get(chave);
		}
	}
	
	public String encerrarAtividade(String atividadeId) {
		for (Tarefas tarefa : this.tarefas) {
			if (tarefa.getConcluida() == false) {
				throw new IllegalStateException("Não é possível encerrar uma atividade com tarefas pendentes");
			}
		}
		return "Atividade encerrada com sucesso";
	}

	public void reabrirAtividade(String codigo) {
		if (this.concluida == true) {
			throw new IllegalStateException("Não é possível reabrir uma atividade já aberta.");
		} else {
			this.concluida = false;	
		}
	}
	
	public void desativarAtividade(String codigo) {
		for (Tarefas tarefa : this.tarefas) {
			if (tarefa.getConcluida() == false) {
				throw new IllegalStateException("Não é possível desativar uma atividade com tarefas pendentes");
			} else {
				this.concluirAtividade();
			}
		}	
	}
}