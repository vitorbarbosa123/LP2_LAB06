package sapo.Atividades;

import java.util.HashMap;
import java.util.NoSuchElementException;

import sapo.Tarefas.Tarefas;

public class AtividadesController {

	
	private HashMap<String, Atividades> atividades;
		          
    public String cadastrarAtividade(String nome, String descricao, String cpf) {
    	 Atividades novaAtividade = new Atividades(nome, descricao, cpf);
         String codigo = criaCodigoAtividade(nome);
    	 this.atividades.put(codigo, novaAtividade);
        return codigo;
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

    public void encerrarAtividade(String codigo) {
    	Atividades atividade = this.atividades.get(codigo);
    	atividade.encerrarAtividade(codigo);
    }

    public void desativarAtividade(String codigo) {
    	Atividades atividade = recuperaAtividade(codigo);
    	atividade.desativarAtividade(codigo);
    }

    public void reabrirAtividade(String codigo) {
    	Atividades atividade = recuperaAtividade(codigo);
    	atividade.reabrirAtividade(codigo);
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

    public Atividades recuperaAtividade(String codigo){
        if(atividades.containsKey(codigo)) return atividades.get(codigo);
        throw new NoSuchElementException("Essa atividade não existe");
    }
}