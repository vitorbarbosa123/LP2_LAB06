package sapo.Atividades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import sapo.Tarefas.Tarefas;
import sapo.Tarefas.TarefasGerenciais;

public class AtividadesController {

	private AtividadesService atividadesService;

    public AtividadesController(AtividadesService atividadesService) {
        this.atividadesService = atividadesService;
    }
		          
    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        return this.atividadesService.cadastrarAtividade(nome, descricao, cpf);
    }    
    public void encerrarAtividade(String codigo) {
    	this.atividadesService.encerrarAtividade(codigo);
    }

    public void desativarAtividade(String codigo) {
    	this.atividadesService.desativarAtividade(codigo);
    }

    public void reabrirAtividade(String codigo) {
    	this.atividadesService.reabrirAtividade(codigo);
    }

    public String exibirAtividade(String codigo) {
    	return this.atividadesService.exibirAtividade(codigo);
    }

    public void alterarDescricaoAtividade(String codigo, String descricao) {
    	this.atividadesService.alterarDescricaoAtividade(codigo, descricao);
    }

    public void alterarResponsavelAtividade(String codigo, String cpf) {
    	this.atividadesService.alterarResponsavelAtividade(codigo, cpf);
    }

    public Atividades recuperaAtividade(String atividadeId) {
        return this.atividadesService.recuperaAtividade(atividadeId);
    }

    public int getQuantidadeTaferas(String atividadeId) {
        return this.atividadesService.getQuantidadeTarefas(atividadeId);
    }

    public int getQuantidadeTarefasGerenciais(String atividadeId) {
        return this.atividadesService.getQuantidadeTarefasGerenciais(atividadeId);
    }

    public void cadastrarTarefa(String atividadeId, Tarefas novaTarefa) {
        this.atividadesService.cadastrarTarefa(atividadeId, novaTarefa);
    }

    public void cadastrarTarefaGerencial(String atividadeId, TarefasGerenciais novaTarefaGerencial) {
        this.atividadesService.cadastrarTarefaGerencial(atividadeId, novaTarefaGerencial);
    }

    public void removerTarefa(String idAtividade, String idTarefa) {
        this.removerTarefa(idAtividade, idTarefa);
    }

    public Collection<Atividades> getMapa() {
        return this.atividadesService.getMapa();
    }

    public HashMap<String, Atividades> getAtividade() {
        return this.atividadesService.getAtividade();
    }

    public ArrayList<String> getTermos(String atividadeId) {
        return this.atividadesService.getTermos(atividadeId);
    }

    public void alteraEstadoAtvidade(String atividadeId, boolean novoEstado) {
        this.atividadesService.alteraEstadoAtvidade(atividadeId, novoEstado);
    }
    
}