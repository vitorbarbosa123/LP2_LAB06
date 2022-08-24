package sapo;

import java.util.ArrayList;

import sapo.Atividades.AtividadesController;
import sapo.Atividades.AtividadesService;
import sapo.Buscas.BuscasController;
import sapo.Buscas.BuscasService;

import sapo.Atividades.Atividades;
import sapo.Funcoes.FuncaoController;
import sapo.Funcoes.FuncaoService;
import sapo.Pessoas.Pessoa;
import sapo.Pessoas.PessoasController;
import sapo.Pessoas.PessoasService;
import sapo.Tarefas.Tarefas;
import sapo.Tarefas.TarefasController;
import sapo.Tarefas.TarefasService;

public class Facade {

    private PessoasController pessoasController;
    private AtividadesController atividadesController;
    private TarefasController tarefasController;
    private BuscasController buscasController;
    private FuncaoController funcaoController;

    public Facade() {
    	
        var pessoasService = new PessoasService();
        var AtividadesService = new AtividadesService();
        var tarefasService = new TarefasService();
        var buscasService = new BuscasService();
        var funcaoService = new FuncaoService();
        
        this.pessoasController = new PessoasController(pessoasService);
        this.atividadesController = new AtividadesController(AtividadesService);
        this.tarefasController = new TarefasController(tarefasService);
        this.buscasController = new BuscasController(buscasService);
        this.funcaoController = new FuncaoController(funcaoService, pessoasController);
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

    public BuscasController getBuscasController() {
        return buscasController;
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
        this.pessoasController.cadastrarPessoa(cpf, nome, habilidades);
    }

    public String buscarPessoa(String cpf) {
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
        return this.pessoasController.recuperarPessoa(cpf);
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
       Pessoa pessoa = this.pessoasController.recuperarPessoa(cpf);
       this.tarefasController.associarPessoaTarefa(cpf, idTarefa, pessoa);
    }  

    public void removerPessoaTarefa(String cpf, String idTarefa) {
        this.tarefasController.removerPessoaTarefa(cpf, idTarefa);
    }
    
    public boolean verificarTarefaIsConcluida(String idTarefa) {
        return this.tarefasController.verificarTarefaIsConcluida(idTarefa);
    }


    // Atividades
    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        String codigo = this.atividadesController.cadastrarAtividade(nome, descricao, cpf, this.pessoasController);
        return codigo;
    }    

    public void encerrarAtividade(String codigo) {
    	this.atividadesController.encerrarAtividade(codigo);
    }

    public void desativarAtividade(String codigo) {
    	this.atividadesController.desativarAtividade(codigo);
    }

    public void reabrirAtividade(String codigo) {
    	this.atividadesController.reabrirAtividade(codigo);
    }

    public String exibirAtividade(String codigo) {
    	String exibeAtividade = this.atividadesController.exibirAtividade(codigo);
    	return exibeAtividade;
    }

    public void alterarDescricaoAtividade(String codigo, String descricao) {
    	System.out.println("teste");
    	this.atividadesController.alterarDescricaoAtividade(codigo, descricao);
    }

    public void alterarResponsavelAtividade(String codigo, String cpf) {
    	this.atividadesController.alterarResponsavelAtividade(codigo, cpf);
    }

    public ArrayList<String> exibirPessoas(String consulta) {
        return this.buscasController.exibirPessoas(consulta, this.pessoasController);
    }

    public Atividades recuperaAtividade(String atividadeId) {
        return this.atividadesController.recuperaAtividade(atividadeId);
    }
    
    
    // Funcoes
    
    public void cadastrarAluno(String cpf,String nome, String matr, int periodo, String[] habilidades){
    	this.funcaoController.cadastrarAluno(cpf, nome, matr, periodo, habilidades);	
    }
    
    public void cadastrarProfessor(
        	String cpf,
        	String nome,
        	String siape,
        	String[]  disciplinas,
        	String[] habilidades
        		
    ){
    	this.funcaoController.cadastrarProfessor(cpf, nome, siape, disciplinas, habilidades);
    }
    
    public void definirFuncaoProfessor(String cpf,String siape,String[]  disciplinas){
    	this.funcaoController.definirFuncaoProfessor(cpf, siape, disciplinas, this.tarefasController);
    }
    
    public void definirFuncaoAluno(String cpf,String matr,int  periodo){
    	this.funcaoController.definirFuncaoAluno(cpf, matr, periodo, this.tarefasController);
    }
    
    public void removerFuncao(String cpf) {
    	this.funcaoController.removerFuncao(cpf, this.tarefasController);
    }
    
    public int pegarNivel(String cpf) {
    	return this.funcaoController.pegarNivel(cpf, this.tarefasController);
    };
    
}