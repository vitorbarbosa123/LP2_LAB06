package sapo.Atividades;

import java.util.ArrayList;
import sapo.Tarefas.Tarefas;
import sapo.Pessoas.Pessoa;
import sapo.Pessoas.PessoasController;

public class Atividades {
    private String nome;
    private String cpf;
    private String descricao;
		// pensar em um nome melhor
		private Tarefas tarefa;

    private ArrayList<Tarefas> tarefas;
		private ArrayList<Tarefas> tarefasGerenciais;
    private boolean concluida;

		private PessoasController pessoasController;

    public Atividades(String nome, String descricao, String cpf, PessoasController pc) {
    	this.nome = nome;
    	this.descricao = descricao;
    	this.cpf = cpf;
    	this.concluida = false;
    	this.tarefas = new ArrayList<>();
		this.pessoasController = pc; 
    	
    	if(cpf.isEmpty() || cpf.isBlank()) {
    		throw new IllegalArgumentException("CPF VAZIO OU NULO");
    	}
    }

	public String getNome() {
		return this.nome;
	}

        
    public int getQuantidadeTarefas(){
        return this.tarefas.size();
    }

    public int getQuantidadeTarefasGerenciais(){
        return this.tarefasGerenciais.size();
    }

    public void cadastrarTarefa(Tarefas novaTarefa){
        tarefas.add(novaTarefa);
    }
    public void cadastrarTarefaGerencial(Tarefas novaTarefaGerencial){
			tarefasGerenciais.add(novaTarefaGerencial);
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
		System.out.println(this.getResponsavelAtividade());
		return codigo + ": " + this.nome + "\n"
				+ "Responsável: " + this.getResponsavelAtividade() + " – " + this.cpf + "\n"
				+ "===" + "\n"
				+ this.descricao + "\n"
				+ "===" + "\n"
				+ "Tarefas:" + getTarefasConcluidas() + "/" + tarefas.size() + "\n"
				+ this.tarefasPendentesString();
	}

	public void concluirAtividade() {
        this.concluida = true;
    }

	public int getTarefasConcluidas() {
		int tarefasConcluidas = 0;

		for (Tarefas tarefa : this.tarefas) {
			if (tarefa.getConcluida() == true) {
				tarefasConcluidas += 1;
			}
		}
		return tarefasConcluidas;
	}

	public String getResponsavelAtividade() {
		Pessoa pessoa = this.pessoasController.recuperarPessoa(cpf);
		return pessoa.getNome();
	
	}
	
	public String tarefasPendentesString(){
		int count = 0;
		String result = "";
		for(Tarefas t: this.tarefas){
			if(t.getConcluida() == false && count < 3){
				result += " - "+t.toStringNomeAndCodigo() +"\n";
				count ++;
			}
		}
		return result;
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
	
	public String getDescricao(){
		return this.descricao;
	}

	public String getCPF(){
		return this.cpf;
	}

	public ArrayList<Tarefas> getTarefas() {
		return tarefas;
	}

	public void setConcluida (boolean valor) {
		this.concluida = valor;
	}

}