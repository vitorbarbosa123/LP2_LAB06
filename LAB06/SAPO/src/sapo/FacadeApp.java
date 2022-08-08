package sapo;

public class FacadeApp {

    private PessoasController pessoasController;

    private AtividadesController atividadesController;

    private TarefasController tarefasController;

    public PessoasController getPessoasController() {

    }

    public AtividadesController getAtividadesController() {

    }

    public TarefasController getTarefasController() {

    }



    // todo: mudar futuramente
    public String cadastrarTarefa(String atividadeId, String nome, String[] habilidades) {
        int finalDoIDTarefa = this.atividadesController.getQuantidadeTaferas(atividadeId);
        String tarefaID = atividadeId+"-"+finalDoIDTarefa;

        Tarefas novaTarefa =  this.tarefasController.cadastrarTarefa(tarefaID, nome, habilidades);
        this.atividadesController.cadastrarTarefa(atividadeId, novaTarefa);

        return tarefaID;
    }

    public void alterarNomeTarefa(String idTarefa, String novoNome) {
        this.tarefasController.alterarNomeTarefa(idTarefa, novoNome);
    }

    public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {
        this.tarefasController.alterarHabilidadesTarefa(idTarefa, habilidades);
    }

    public void adicionarHorasTarefa(String idTarefa, int horas) {
        this.tarefasController.adicionarHorasTarefa(idTarefa, horas);
    }

    public void removerHorasTarefa(String idTarefa, int horas) {
        this.tarefasController.removerHorasTarefa(idTarefa, horas);
    }

    public void concluirTarefa(String idTarefa) {
        this.tarefasController.concluirTarefa(idTarefa);
    }

    public void removerTarefa(String idTarefa) {
        this.tarefasController.removerTarefa(idTarefa);
    }

    public String exibirTarefa(String idTarefa) {
        this.tarefasController.exibirTarefa(idTarefa)
    }
    
    public void associarPessoaTarefa(String cpf, String idTarefa) {
       //Pessoa pessoa = this.pessoasController.recuperarPessoa(cpf);
       //this.tarefasController.associarPessoaTarefa(cpf, idTarefa, pessoa);
    }  

    public void removerPessoaTarefa(String cpf, String idTarefa) {
        this.tarefasController.removerPessoaTarefa(cpf, idTarefa);
    } 

}