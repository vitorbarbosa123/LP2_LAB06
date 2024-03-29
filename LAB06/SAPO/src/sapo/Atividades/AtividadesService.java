package sapo.Atividades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import sapo.Pessoas.PessoasController;
import sapo.Tarefas.Tarefas;
import sapo.Tarefas.TarefasGerenciais;
public class AtividadesService {
    
    private AtividadesRepository atividadesRepository;

    public AtividadesService(){
        this.atividadesRepository = new AtividadesRepository();
    }

    public String cadastrarAtividade(String nome, String descricao, String cpf, PessoasController pc) {
        return this.atividadesRepository.cadastrarAtividade(nome, descricao, cpf, pc);
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

   public int getQuantidadeTarefasGerenciais(String atividadeId){
       Atividades atividade = this.atividadesRepository.recuperaAtividade(atividadeId);
       return atividade.getQuantidadeTarefas();
   }
   
   public Atividades recuperaAtividade(String atividadeId) {
        return this.atividadesRepository.recuperaAtividade(atividadeId);
   }

    public Collection<Atividades> getMapa() {
        return this.atividadesRepository.getMapa();
    }

    public HashMap<String, Atividades> getAtividade() {
        return this.atividadesRepository.getAtividade();
    }

    public ArrayList<String> getTermos(String atividadeId) {
        return this.atividadesRepository.getTermos(atividadeId);
    }

    public void cadastrarTarefa(String atividadeId, Tarefas novaTarefa) {
        Atividades atividade = this.atividadesRepository.recuperaAtividade(atividadeId);
        atividade.cadastrarTarefa (novaTarefa);
    }

    public void cadastrarTarefaGerencial(String atividadeId, TarefasGerenciais novaTarefa) {
        Atividades atividade = this.atividadesRepository.recuperaAtividade(atividadeId);
        atividade.cadastrarTarefaGerencial (novaTarefa);
    }
    
    public void alteraEstadoAtvidade(String atividadeId, boolean novoEstado) {
        Atividades atividade = this.atividadesRepository.recuperaAtividade(atividadeId);
        atividade.setConcluida(novoEstado);
    }
}
