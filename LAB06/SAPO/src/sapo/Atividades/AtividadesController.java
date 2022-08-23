package sapo.Atividades;

import sapo.Tarefas.Tarefas;

public class AtividadesController {

	private AtividadesService atividadesService;

    public AtividadesController( AtividadesService atividadesService) {
        this.atividadesService = atividadesService;
    }
		          
    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        return this.atividadesService.cadastrarAtividade(nome, descricao, cpf);
    }
    public String cadastrarTarefaGerencial(String nome, String descricao, String cpf) {
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

    public void cadastrarTarefa(String atividadeId, Tarefas novaTarefa) {
        this.cadastrarTarefa(atividadeId, novaTarefa);
    }

    public void removerTarefa(String idAtividade, String idTarefa) {
        this.removerTarefa(idAtividade, idTarefa);
    }
}