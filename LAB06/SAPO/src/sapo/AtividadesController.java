package sapo;

import java.util.HashMap;

public class AtividadesController {

    private HashMap<String, Atividades> atividades;
    private HashMap<String, Tarefas> tarefas;

    public String cadastrarAtividade(String nome, String descricao, String cpf) {
    	this.atividades.put(criaCodigoAtividade(nome), new Atividades( nome, descricao, cpf));
    	return "";
    }
    
    public String criaCodigoAtividade(String nome) {
    	String codigo = "";
    	String marcador = "X";
    	
    	codigo = nome.replaceAll("[aeiou]", "");
    	    	
    	if(codigo.length() < 3) {
    		codigo = codigo + marcador; 
    	}
    	    	
    	codigo = codigo + "-" + tamanhoDeAtividades(atividades);
    	
    	return codigo;
    }
    
    public String tamanhoDeAtividades(HashMap<String, Atividades> atividades) {
    	return Integer.toString(atividades.size());
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

}