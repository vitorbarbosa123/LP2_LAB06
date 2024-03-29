package sapo.Tarefas;

import java.util.Collection;
import java.util.List;

import sapo.Atividades.Atividades;
import sapo.Atividades.AtividadesController;
import sapo.Pessoas.Pessoa;

public class TarefasService {
    private TarefasRepository tarefasRepository;

    public TarefasService() {
		this.tarefasRepository = new TarefasRepository(); 
	}

    public String cadastrarTarefa(String atividadeId, String nome, String[] habilidades, AtividadesController atividadesC) {
        Atividades atividade = atividadesC.recuperaAtividade(atividadeId);
        int finalDoIDTarefa = atividadesC.getQuantidadeTaferas(atividadeId);
        String tarefaID = atividadeId+"-"+finalDoIDTarefa;

        Tarefas novaTarefa = this.tarefasRepository.cadastrarTarefa(tarefaID, nome, habilidades, atividade);
        atividadesC.cadastrarTarefa(atividadeId, novaTarefa);
       
        return tarefaID;
    }

    public String cadastrarTarefaGerencial(
    		String atividadeId,
    		String nome,
    		String[] habilidades,
    		String[] idTarefas,
    		AtividadesController atividadesC
    ){
        Atividades atividade = atividadesC.recuperaAtividade(atividadeId);
        int finalDoIDTarefa = atividadesC.getQuantidadeTarefasGerenciais(atividadeId);
        String tarefaGerencialID = atividadeId+"-"+finalDoIDTarefa;

        TarefasGerenciais novaTarefaGerencial = this.tarefasRepository.cadastrarTarefaGerencial(tarefaGerencialID, nome, habilidades, atividade);
        atividadesC.cadastrarTarefaGerencial(atividadeId, novaTarefaGerencial);
       
        return tarefaGerencialID;
    }

    public Tarefas buscarTarefa(String idTarefa){
        return this.tarefasRepository.recuperarTarefa(idTarefa);
    }

    public void alterarNomeTarefa(String idTarefa, String novoNome) {
        Tarefas tarefa = this.tarefasRepository.recuperarTarefa(idTarefa);
        tarefa.setNome(novoNome);
    }

    public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {
        Tarefas tarefa = this.tarefasRepository.recuperarTarefa(idTarefa);
        tarefa.setHabilidades(habilidades);
    }

    public void adicionarHorasTarefa(String idTarefa, int horas) {
        Tarefas tarefa = this.tarefasRepository.recuperarTarefa(idTarefa);
        tarefa.adicionarHoras(horas);
    }

    public void removerHorasTarefa(String idTarefa, int horas) {
        Tarefas tarefa = this.tarefasRepository.recuperarTarefa(idTarefa);
        tarefa.removerHoras(horas);
    }

    public void concluirTarefa(String idTarefa) {
        Tarefas tarefa = this.tarefasRepository.recuperarTarefa(idTarefa);
        tarefa.concluirTarefa();
    }

    public void removerTarefa(String idTarefa, AtividadesController ac) {
        this.tarefasRepository.removerTarefa(idTarefa);
  
        String idAtividade = getIDAtividadeOnTarefa(idTarefa);
        ac.removerTarefa(idAtividade, idTarefa);
    }

    private String getIDAtividadeOnTarefa(String idTarefa){
        String [] parts = idTarefa.split("-");
        String idAtividade = parts[0] +"-"+ parts[0];
        return idAtividade;
    }

    public String exibirTarefa(String idTarefa) {
        Tarefas tarefa = this.tarefasRepository.recuperarTarefa(idTarefa);
        return tarefa.toString();
    }

    public void associarPessoaTarefa(String cpf, String idTarefa, Pessoa pessoa) {
        Tarefas tarefa = this.tarefasRepository.recuperarTarefa(idTarefa);
        tarefa.adicionarNovoResponsavel(cpf, pessoa);
    }

    public void removerPessoaTarefa(String cpf, String idTarefa) {
        Tarefas tarefa = this.tarefasRepository.recuperarTarefa(idTarefa);
        tarefa.removerResponsavel(cpf);
    }

    public boolean verificarTarefaIsConcluida(String idTarefa) {
        Tarefas tarefa = this.tarefasRepository.recuperarTarefa(idTarefa);
        return tarefa.getConcluida();
    }
    
    public List<Tarefas> recuperarTarefasPessoa(String cpf){
    	 return this.tarefasRepository.recuperarTarefasPessoa(cpf);
    }
    

    public int getHorasDeTodasAsTarefas() {
        int tempoTotal = this.tarefasRepository.getHorasTarefas();
        return tempoTotal;
    }

    public String getHabilidadesDeTodasAsTarefas() {
        String habilidades = this.tarefasRepository.getHabilidadesTarefas();
        return habilidades;
        
    }
    public boolean getTarefasConcluidas() {
        boolean isConcluida = this.tarefasRepository.getConcluidaTarefas();
        return isConcluida;
        
    }
    public Collection<Tarefas> getMapa() {
        return this.tarefasRepository.getMapa();

    }

    public void validaEstadoTarefasDeTarefasGerencial(String idAtividade, AtividadesController ac) {
       boolean novoEstado = this.getTarefasConcluidas();
  
        if (novoEstado == false) {
            novoEstado = false;
        }
        ac.alteraEstadoAtvidade(idAtividade, novoEstado);
    }


}
