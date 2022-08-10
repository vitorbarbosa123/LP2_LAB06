package sapo;

import java.util.HashMap;

public class AtividadesController {

    private HashMap<String, Atividades> atividades;

    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        return "";
    }

    public void encerrarAtividade(String atividadeId) {

    }

    public void desativarAtividade(String atividadeId) {

    }

    public void reabrirAtividade(String atividadeId) {

    }

    public String exibirAtividade(String atividadeId) {
        return "";
    }

    public void alterarDescricaoAtividade(String atividadeId, String descricao) {

    }

    public void alterarResponsavelAtividade(String atividadeId, String cpf) {

    }

    public int getQuantidadeTaferas(String atividadeId){
        Atividades atividade = this.atividades.get(atividadeId);
        return atividade.getQuantidadeTarefas();
    }
    
    public void cadastrarTarefa(String atividadeId, Tarefas tarefa){
        Atividades atividade = this.atividades.get(atividadeId);
        atividade.cadastrarTarefa(tarefa);
    }

    public void removerTarefa(String atividadeId, String idTarefa){
        Atividades atividade = this.atividades.get(atividadeId);
        atividade.removerTarefa(idTarefa);
    }


}