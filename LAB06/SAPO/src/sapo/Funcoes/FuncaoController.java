package sapo.Funcoes;

import java.util.List;

import sapo.Pessoas.Pessoa;
import sapo.Pessoas.PessoasController;
import sapo.Tarefas.Tarefas;
import sapo.Tarefas.TarefasController;

public class FuncaoController {
    private FuncaoService funcaoService;
    private PessoasController pessoaController;
    
    public FuncaoController(FuncaoService funcaoService, PessoasController pc ){
        this.funcaoService = funcaoService;
        this.pessoaController = pc;
    }

    public void cadastrarAluno(String cpf,String nome, String matr, int periodo, String[] habilidades){
    	this.pessoaController.cadastrarPessoa(cpf, nome, habilidades);
    	Funcao funcao = new FuncaoAluno(matr, periodo);
    	this.pessoaController.definirFuncaoPessoa(cpf, funcao);
    }
    
    public void cadastrarProfessor(
    	String cpf,
    	String nome,
    	String siape,
    	String[]  disciplinas,
    	String[] habilidades
    		
    ){
    	this.pessoaController.cadastrarPessoa(cpf, nome, habilidades);
    	Funcao funcao = new FuncaoProfessor(disciplinas, siape);
    	this.pessoaController.definirFuncaoPessoa(cpf, funcao);
    }
    
    public void definirFuncaoProfessor(String cpf,String siape,String[]  disciplinas, TarefasController tarefasController){
    	Pessoa pessoa = this.pessoaController.recuperarPessoa(cpf);
    	Funcao funcaoAntiga = pessoa.getFuncao();
    	
    	List<Tarefas> tarefas = tarefasController.recuperarTarefasPessoa(cpf);
    	int nivelAnterior = funcaoAntiga.pegaNivel(tarefas, pessoa);
    	
    	List<String> codigosTarefasAnteriores = funcaoAntiga.codigosTarefasAnteriores;
    	for(Tarefas tarefa: tarefas) codigosTarefasAnteriores.add(tarefa.getCodigo());
    	
    	Funcao novaFuncao = new FuncaoProfessor(
	    							disciplinas, 
	    							siape,
	    							nivelAnterior,
	    							codigosTarefasAnteriores
    						);
    	
    	this.pessoaController.definirFuncaoPessoa(cpf, novaFuncao);
    }
   
    public void definirFuncaoAluno(String cpf,String matr,int  periodo, TarefasController tarefasController){
    	Pessoa pessoa = this.pessoaController.recuperarPessoa(cpf);
    	Funcao funcaoAntiga = pessoa.getFuncao();
    	
    	List<Tarefas> tarefas = tarefasController.recuperarTarefasPessoa(cpf);
    	int nivelAnterior = funcaoAntiga.pegaNivel(tarefas, pessoa);
    	
    	List<String> codigosTarefasAnteriores = funcaoAntiga.codigosTarefasAnteriores;
    	for(Tarefas tarefa: tarefas) codigosTarefasAnteriores.add(tarefa.getCodigo());
    	
    	Funcao novaFuncao = new FuncaoAluno(
    								matr, 
    								periodo,
    								nivelAnterior,
	    							codigosTarefasAnteriores
    						);
    	
    	this.pessoaController.definirFuncaoPessoa(cpf, novaFuncao);
    }
	
    public void removerFuncao(String cpf,  TarefasController tarefasController) {
    	Pessoa pessoa = this.pessoaController.recuperarPessoa(cpf);
    	Funcao funcaoAntiga = pessoa.getFuncao();
    	
    	List<Tarefas> tarefas = tarefasController.recuperarTarefasPessoa(cpf);
    	
    	int nivelAnterior = funcaoAntiga.pegaNivel(tarefas, pessoa);
    	
    	List<String> codigosTarefasAnteriores = funcaoAntiga.codigosTarefasAnteriores;
    	for(Tarefas tarefa: tarefas) codigosTarefasAnteriores.add(tarefa.getCodigo());
    	
    	Funcao novaFuncao = new SemFuncao(
    								nivelAnterior,
	    							codigosTarefasAnteriores
    						);
    	
    	this.pessoaController.definirFuncaoPessoa(cpf, novaFuncao);
    };
    
    public int pegarNivel(String cpf, TarefasController tarefasController) {
    	Pessoa pessoa = this.pessoaController.recuperarPessoa(cpf);
    	Funcao funcao = pessoa.getFuncao();
    	
    	List<Tarefas> tarefas = tarefasController.recuperarTarefasPessoa(cpf);
    	
    	return funcao.pegaNivel(tarefas, pessoa);
    };

    public String[] listarPessoas() {
    	return new String[0];
    }
}

