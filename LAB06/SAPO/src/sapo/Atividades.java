package sapo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.List;

public class Atividades {
    
    private String nome;

    private String autorCpf;
    
    private String descricao;

    private ArrayList<Tarefas> tarefas;
    
    private boolean concluida;
    
 
    public Atividades(String nome, String descricao, String cpf) {
    	this.nome = nome;
    	this.descricao = descricao;
    	this.autorCpf = cpf;
    	this.concluida = false;
    	
    	
    	if(cpf.isEmpty() || cpf.isBlank()  ) {
    		throw new IllegalArgumentException("CPF VAZIO OU NULO");
    	}
    }
        
    public int getQuantidadeTarefas(){
        return this.tarefas.size();
    }

    public void cadastrarTarefa(Tarefas novaTarefa){
        tarefas.add(novaTarefa);
    }


	public void alterarDescricaoAtividade(String novaDescricao) {
		this.descricao = novaDescricao;
	}


	public void alterarResponsavelAtividade(String novoCpf) {
		this.autorCpf = novoCpf;
	}


	public String exibirAtividade(String codigo) {
		
		return codigo + ":" + this.nome
				+ "Responsável: Matheus Gaudencio do Rêgo – " + cpf
				+ "==="
				+ this.descricao
				+ "==="
				+ "Tarefas:" + tarefasRealizadas + "/" + tarefasCadastradas
				+ "-" +  tarefas.get(0)
				+ "-" +  tarefas.get(1)
				+ "-" +  tarefas.get(2);
		
	}


	public void concluirAtividade() {
        this.concluida = true;
    }
	
	public void encerrarAtividade(String atividadeId) {
		for (Tarefas i : this.tarefas) {
			if (this.tarefas.getConcluidas() == false) {
				throw new IllegalStateException("Não é possível encerrar uma atividade com tarefas pendentes")
			}
		}
		
	}


	public void reabrirAtividade(String codigo) {
		// TODO Auto-generated method stub
	}


	public void desativarAtividade(String codigo) {
		for (Tarefas i : this.tarefas) {
			if (this.tarefas.getConcluidas() == false) {
				throw new IllegalStateException("Não é possível desativar uma atividade com tarefas pendentes")
			}
		}
		
	}
}