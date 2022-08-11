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



    public String cadastrarTarefa(String atividadeId, String nome, String[] habilidades) {
        String tarefaID =  this.tarefasController.cadastrarTarefa(atividadeId, nome, habilidades, atividadesController);
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
        this.tarefasController.removerTarefa(idTarefa, this.atividadesController);
    }

    public String exibirTarefa(String idTarefa) {
        return this.tarefasController.exibirTarefa(idTarefa);
    }
    
    public void associarPessoaTarefa(String cpf, String idTarefa) {
       //Pessoa pessoa = this.pessoasController.buscarPessoa(cpf);
       //this.tarefasController.associarPessoaTarefa(cpf, idTarefa, pessoa);
    }  

    public void removerPessoaTarefa(String cpf, String idTarefa) {
        this.tarefasController.removerPessoaTarefa(cpf, idTarefa);
    } 

}