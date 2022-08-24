package sapo.Tarefas;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import sapo.Atividades.Atividades;

public class TarefasRepository {

    private Map<String, Tarefas> tarefas;
    private Map<String, TarefasGerenciais> tarefasGerenciais;

    public TarefasRepository(){
        this.tarefas = new HashMap<>();
    }

    public Collection<Tarefas> getMapa() {
        return this.tarefas.values();
    }

    public Tarefas cadastrarTarefa(String tarefaID, String nome, String[] habilidades, Atividades atividade) {
        Tarefas novaTarefa = new Tarefas(tarefaID, nome, habilidades, atividade);
        this.tarefas.put(tarefaID, novaTarefa);
        return novaTarefa;
    }

    public TarefasGerenciais cadastrarTarefaGerencial(String idTarefaGerencial, String nome, String[] habilidades, Atividades atividade) {
        TarefasGerenciais novaTarefaGerencial = new TarefasGerenciais(idTarefaGerencial, nome, habilidades);
        this.tarefasGerenciais.put(idTarefaGerencial, novaTarefaGerencial);
        return novaTarefaGerencial;
    }

    public void removerTarefa(String idTarefa){
        this.recuperarTarefa(idTarefa);
        tarefasGerenciais.remove(idTarefa);
    }

    public void removerDaTarefaGerencial(String idTarefaGerencial, String idTarefa){
        this.recuperarTarefaGerencial(idTarefa);
        tarefas.remove(idTarefa);
    }

    public Tarefas recuperarTarefa(String idTarefa){
        if(tarefas.containsKey(idTarefa)) return tarefas.get(idTarefa);
        throw new NoSuchElementException("Tarefa não existe");
    }

    public Tarefas recuperarTarefaGerencial(String idTarefa){
        if(tarefasGerenciais.containsKey(idTarefa)) return tarefas.get(idTarefa);
        throw new NoSuchElementException("Tarefa não existe dentro de uma tarefa gerencial");
    }

    public int getHorasTarefas() {
        int horasTotais = 0;

        for (Tarefas tarefas : tarefas.values()) {
            horasTotais += tarefas.getHoras();
        }

        return horasTotais;
    }

    public String getHabilidadesTarefas() {
        String habilidadeObrigatoria = "gestão";
        String habilidades = "";
        String result = habilidades + habilidadeObrigatoria;
        for (Tarefas tarefas : tarefas.values()) {
            habilidades = tarefas.getHabilidadesString();
        }

        return result;
    }

    public int contarTodasTarefasNaTarefaGerencial(String idTarefaGerencial) {
        int totalTarefas = 0;
        this.recuperarTarefaGerencial(idTarefaGerencial);
        totalTarefas += tarefasGerenciais.size();
        return totalTarefas;
    }
}
