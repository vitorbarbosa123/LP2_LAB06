package sapo.Atividades;

public class AtividadesService {
    
    private AtividadesRepository atividadesRepository;

    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        return this.atividadesRepository.cadastrarAtividade(nome, descricao, cpf);
    }
          
   public void encerrarAtividade(String codigo) {
       this.atividadesRepository.encerrarAtividade(codigo)
   }

   public void desativarAtividade(String codigo) {
      this.atividadesRepository.desativarAtividade(codigo);
   }

   public void reabrirAtividade(String codigo) {
       this.atividadesRepository.reabrirAtividade(codigo);
   }

   public String exibirAtividade(String codigo) {
       Atividades atividade = recuperaAtividade(codigo);
       return atividade.exibirAtividade(codigo);
   }

   public void alterarDescricaoAtividade(String codigo, String descricao) {
       Atividades atividade = recuperaAtividade(codigo);
       atividade.alterarDescricaoAtividade(descricao);
   }

   public void alterarResponsavelAtividade(String codigo, String cpf) {
       Atividades atividade = recuperaAtividade(codigo);
       atividade.alterarResponsavelAtividade(cpf);
   }

   public int getQuantidadeTarefas(String atividadeId){
       Atividades atividade = this.atividades.get(atividadeId);
       return atividade.getQuantidadeTarefas();
   }
   
   public void cadastrarTarefa(String atividadeId, Tarefas tarefa){
       this.atividadesRepository.cadastrarTarefa(atividadeId, tarefa);
   }

   public void removerTarefa(String atividadeId, String idTarefa){
       this.atividadesRepository.removerTarefa(atividadeId, idTarefa);
   }
}
