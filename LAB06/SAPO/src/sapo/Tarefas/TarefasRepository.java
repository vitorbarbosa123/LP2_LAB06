package sapo.Tarefas;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import sapo.Atividades.Atividades;

public class TarefasRepository {

    private Map<String, Tarefas> tarefas;

    public TarefasRepository(){
        this.tarefas = new HashMap<>();
    }

    public Tarefas cadastrarTarefa(String tarefaID, String nome, String[] habilidades, Atividades atividade) {
        Tarefas novaTarefa = new Tarefas(tarefaID, nome, habilidades, atividade);
        this.tarefas.put(tarefaID, novaTarefa);
        return novaTarefa;
    }

    public void removerTarefa(String idTarefa){
        this.recuperarTarefa(idTarefa);
        tarefas.remove(idTarefa);
    }

    public Tarefas recuperarTarefa(String idTarefa){
        if(tarefas.containsKey(idTarefa)) return tarefas.get(idTarefa);
        throw new NoSuchElementException("Tarefa não existe");
    }
}
