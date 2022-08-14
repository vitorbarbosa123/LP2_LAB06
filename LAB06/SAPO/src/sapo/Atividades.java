package sapo;

import java.util.List;

public class Atividades {
    
    private String nome;

    private String autorCpf;
    
    private String descricao;

    private List<Tarefas> tarefas;
    
    public Atividades (String nome, String descricao, String cpf) {
    	this.nome = nome;
    	this.descricao = descricao;
    	this.autorCpf = cpf;
    }


    public int getQuantidadeTarefas(){
        return this.tarefas.size();
    }

    public void cadastrarTarefa(Tarefas novaTarefa){
        tarefas.add(novaTarefa);
    }
}