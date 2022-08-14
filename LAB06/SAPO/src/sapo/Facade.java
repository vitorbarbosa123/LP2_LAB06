package sapo;

import sapo.Atividades.AtividadesController;
import sapo.Pessoas.Pessoa;
import sapo.Pessoas.PessoasController;
import sapo.Tarefas.TarefasController;

public class Facade {

    private PessoasController pessoasController;
    private AtividadesController atividadesController;
    private TarefasController tarefasController;

    public Facade() {
        this.pessoasController = new PessoasController();
        this.atividadesController = new AtividadesController();
        this.tarefasController = new TarefasController();
    }

    public PessoasController getPessoasController() {
        return pessoasController;
    }

    public AtividadesController getAtividadesController() {
        return atividadesController;
    }

    public TarefasController getTarefasController() {
        return tarefasController;
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
        this.pessoasController.cadastrarPessoa(cpf, nome, habilidades);
    }

    public Pessoa buscarPessoa(String cpf) {
        return this.pessoasController.buscarPessoa(cpf);
    }

    public String exibirPessoa(String cpf) {
        return this.pessoasController.exibirPessoa(cpf);
    }

    public void alterarNomePessoa(String cpf, String novoNome) {
        this.pessoasController.alterarNomePessoa(cpf, novoNome);
    }

    public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
        this.pessoasController.alterarHabilidadesPessoa(cpf, novasHabilidades);
    }

    public void removerPessoa(String cpf) {
        this.pessoasController.removerPessoa(cpf);
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
        this.pessoasController.adicionarComentarioPessoa(cpf, comentario, autorCpf);
    }

    public String listarComentariosPessoa(String cpf) {
        return this.pessoasController.listarComentariosPessoa(cpf);
    }

    Pessoa recuperarPessoaOrException(String cpf){
        return this.pessoasController.recuperarPessoaOrException(cpf);
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
       Pessoa pessoa = this.pessoasController.recuperarPessoaOrException(cpf);
       this.tarefasController.associarPessoaTarefa(cpf, idTarefa, pessoa);
    }  

    public void removerPessoaTarefa(String cpf, String idTarefa) {
        this.tarefasController.removerPessoaTarefa(cpf, idTarefa);
    }
    
    public boolean verificarTarefaIsConcluida(String idTarefa) {
        return this.tarefasController.verificarTarefaIsConcluida(idTarefa);
    }

}