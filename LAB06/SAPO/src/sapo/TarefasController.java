package sapo;

import java.util.*;

public class TarefasController {

    private Map<String, Tarefas> tarefas;

    public TarefasController(){
        this.tarefas = new HashMap<>();
    }

    public String cadastrarTarefa(String atividadeId, String nome, String[] habilidades, AtividadesController atividadesC) {
        Atividades atividade = atividadesC.buscarAtividade(atividadeId);
        int finalDoIDTarefa = atividadesC.getQuantidadeTaferas(atividadeId);
        String tarefaID = atividadeId+"-"+finalDoIDTarefa;

        Tarefas novaTarefa = new Tarefas(tarefaID, nome, habilidades, atividade);
        atividadesC.cadastrarTarefa(atividadeId, novaTarefa);
       
        this.tarefas.put(tarefaID, novaTarefa);
        return tarefaID;
    }

    public Tarefas buscarTarefa(String idTarefa){
        return this.recuperarTarefaOrException(idTarefa);
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

    public void removerTarefa(String idTarefa, AtividadesController ac) {
        tarefas.remove(idTarefa);
        
        String idAtividade = getIDAtividadeOnTarefa(idTarefa);
        ac.removerTarefa(idAtividade, idTarefa);
    }

    private String getIDAtividadeOnTarefa(String idTarefa){
        String [] parts = idTarefa.split("-");
        String idAtividade = parts[0] +"-"+ parts[0];
        return idAtividade;
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

    public boolean verificarTarefaIsConcluida(String idTarefa) {
        Tarefas tarefa = this.recuperarTarefaOrException(idTarefa);
        return tarefa.getConcluida();
    }


    private Tarefas recuperarTarefaOrException(String idTarefa){
        if(tarefas.containsKey(idTarefa)) return tarefas.get(idTarefa);
        throw new NoSuchElementException("Tarefa não existe");
    }
}