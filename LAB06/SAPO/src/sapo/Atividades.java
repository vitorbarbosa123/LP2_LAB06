package sapo;

import java.util.List;

public class Atividades {
    private String id;
    
    private String cpf;

    private String nome;

    private str[] habilidades;

    private String novoNome;

    private str[] novasHabilidades;

    private String comentario;

    private String autorCpf;

    private List<Tarefas> tarefas;


    public int getQuantidadeTarefas(){
        return this.tarefas.size();
    }

    public void cadastrarTarefa(Tarefas novaTarefa){
        tarefas.add(novaTarefa);
    }
}