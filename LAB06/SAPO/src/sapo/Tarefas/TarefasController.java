package sapo.Tarefas;

import java.util.Collection;

import sapo.Atividades.AtividadesController;
import sapo.Pessoas.Pessoa;

public class TarefasController {

    private TarefasService tarefasService;

    public TarefasController(TarefasService tarefasService){
        this.tarefasService = tarefasService;
    }

    public String cadastrarTarefa(String atividadeId, String nome, String[] habilidades, AtividadesController atividadesC) {
        return this.tarefasService.cadastrarTarefa(atividadeId, nome, habilidades, atividadesC);
    }
    public String cadastrarTarefaGerencial(String atividadeId, String nome, String[] habilidades, AtividadesController atividadesC) {
        return this.tarefasService.cadastrarTarefaGerencial(atividadeId, nome, habilidades, atividadesC);
    }

    public Tarefas buscarTarefa(String idTarefa){
        return this.tarefasService.buscarTarefa(idTarefa);
    }

    public void alterarNomeTarefa(String idTarefa, String novoNome) {
        this.tarefasService.alterarNomeTarefa(idTarefa, novoNome);
    }

    public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {
        this.tarefasService.alterarHabilidadesTarefa(idTarefa, habilidades);
    }

    public void adicionarHorasTarefa(String idTarefa, int horas) {
        this.tarefasService.adicionarHorasTarefa(idTarefa, horas);
    }

    public void removerHorasTarefa(String idTarefa, int horas) {
        this.tarefasService.removerHorasTarefa(idTarefa, horas);
    }

    public void concluirTarefa(String idTarefa) {
        this.tarefasService.concluirTarefa(idTarefa);
    }

    public void removerTarefa(String idTarefa, AtividadesController ac) {
        this.tarefasService.removerTarefa(idTarefa, ac);
    }

    public String exibirTarefa(String idTarefa) {
        return this.tarefasService.exibirTarefa(idTarefa);
    }

    public void associarPessoaTarefa(String cpf, String idTarefa, Pessoa pessoa) {
        this.tarefasService.associarPessoaTarefa(cpf, idTarefa, pessoa);
    }

    public void removerPessoaTarefa(String cpf, String idTarefa) {
        this.tarefasService.removerPessoaTarefa(cpf, idTarefa);
    }

    public boolean verificarTarefaIsConcluida(String idTarefa) {
        return this.tarefasService.verificarTarefaIsConcluida(idTarefa);
    }

    public Collection<Tarefas> getMapa() {
        return this.tarefasService.getMapa();
    }

    public String getHabilidadesDeTodasAsTarefas() {
        return this.tarefasService.getHabilidadesDeTodasAsTarefas();    
    }
}