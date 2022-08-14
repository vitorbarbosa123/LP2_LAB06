package sapo;

import java.util.*;

public class TarefasController {

    private HashMap<String, Tarefas> tarefas;

    public Tarefas cadastrarTarefa(String tarefaID, String nome, String[] habilidades) {
        Tarefas novaTarefa = new Tarefas(tarefaID, nome, habilidades);
        this.tarefas.put(tarefaID, novaTarefa);
        return novaTarefa;
    }

    public void alterarNomeTarefa(String idTarefa, String novoNome) {
        Tarefas tarefa =this.recuperarTarefaOrException(idTarefa);
        tarefa.setNome(novoNome);
    }

    public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {
        Tarefas tarefa =this.recuperarTarefaOrException(idTarefa);
        tarefa.setHabilidades(habilidades);
    }

    public void adicionarHorasTarefa(String idTarefa, int horas) {
        Tarefas tarefa =this.recuperarTarefaOrException(idTarefa);
        tarefa.adicionarHoras(horas);
    }

    public void removerHorasTarefa(String idTarefa, int horas) {
        Tarefas tarefa =this.recuperarTarefaOrException(idTarefa);
        tarefa.removerHoras(horas);
    }

    public void concluirTarefa(String idTarefa) {
        Tarefas tarefa =this.recuperarTarefaOrException(idTarefa);
        tarefa.concluirTarefa();
    }

    public void removerTarefa(String idTarefa) {

    }

    public String exibirTarefa(String idTarefa) {
        Tarefas tarefa =this.recuperarTarefaOrException(idTarefa);
        return tarefa.toString();
    }

    public void associarPessoaTarefa(String cpf, String idTarefa, Pessoa pessoa) {
        Tarefas tarefa =this.recuperarTarefaOrException(idTarefa);
        tarefa.adicionarNovoResponsavel(cpf, pessoa);
    }

    public void removerPessoaTarefa(String cpf, String idTarefa) {
        Tarefas tarefa = this.recuperarTarefaOrException(idTarefa);
        tarefa.removerResponsavel(cpf);
    }


    private Tarefas recuperarTarefaOrException(String idTarefa){
        if(tarefas.containsKey(idTarefa)) return tarefas.get(idTarefa);
        throw new NoSuchElementException("Tarefa não existe");
    }
}