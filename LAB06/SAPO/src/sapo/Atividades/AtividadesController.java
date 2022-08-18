package sapo.Atividades;

public class AtividadesController {

	private AtividadesService atividadesService;

    public AtividadesController( AtividadesService atividadesService) {
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
    	return this.atividadesService.exibeAtividade(codigo);
    }

    public void alterarDescricaoAtividade(String codigo, String descricao) {
    	this.atividadesService.alteraDecricaoAtividade(codigo, descricao);
    }

    public void alterarResponsavelAtividade(String codigo, String cpf) {
    	this.atividadesService.alterarResponsavelAtividade(codigo, cpf);
    }
}