package sapo.Atividades;

public class AtividadesService {
    
    private AtividadesRepository atividadesRepository;


    public AtividadesService(){
        this.atividadesRepository = new AtividadesRepository();
    }

    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        return this.atividadesRepository.cadastrarAtividade(nome, descricao, cpf);
    }
          
   public void encerrarAtividade(String codigo) {
       this.atividadesRepository.encerrarAtividade(codigo);
   }

   public void desativarAtividade(String codigo) {
      this.atividadesRepository.desativarAtividade(codigo);
   }

   public void reabrirAtividade(String codigo) {
       this.atividadesRepository.reabrirAtividade(codigo);
   }

   public String exibirAtividade(String codigo) {
       Atividades atividade = atividadesRepository.recuperaAtividade(codigo);
       return atividade.exibirAtividade(codigo);
   }

   public void alterarDescricaoAtividade(String codigo, String descricao) {
       Atividades atividade = atividadesRepository.recuperaAtividade(codigo);
       atividade.alterarDescricaoAtividade(descricao);
   }

   public void alterarResponsavelAtividade(String codigo, String cpf) {
       Atividades atividade = atividadesRepository.recuperaAtividade(codigo);
       atividade.alterarResponsavelAtividade(cpf);
   }

   public int getQuantidadeTarefas(String atividadeId){
       Atividades atividade = this.atividadesRepository.recuperaAtividade(atividadeId);
       return atividade.getQuantidadeTarefas();
   }
   
   public Atividades recuperaAtividade(String atividadeId) {
        return this.atividadesRepository.recuperaAtividade(atividadeId);
   }
}
