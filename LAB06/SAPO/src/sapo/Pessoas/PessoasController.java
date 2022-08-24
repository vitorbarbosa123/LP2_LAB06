package sapo.Pessoas;

import java.util.Collection;
import sapo.Funcoes.Funcao;

public class PessoasController {
                    
    private PessoasService pessoasService;

    public PessoasController(PessoasService pessoasService) {
        this.pessoasService = pessoasService;
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
        this.pessoasService.cadastrarPessoa(cpf, nome, habilidades);
    }

    public String buscarPessoa(String cpf) {
        return this.pessoasService.buscarPessoa(cpf);
    }

    public String exibirPessoa(String cpf) {
        return this.pessoasService.buscarPessoa(cpf);
    }

    public void alterarNomePessoa(String cpf, String novoNome) {
        this.pessoasService.alterarNomePessoa(cpf, novoNome);
    }

    public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
        this.pessoasService.alterarHabilidadesPessoa(cpf, novasHabilidades);
    }

    public void removerPessoa(String cpf) {
        this.pessoasService.removerPessoa(cpf);
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
        this.pessoasService.adicionarComentarioPessoa(cpf, comentario, autorCpf);
    }

    public String listarComentariosPessoa(String cpf) {
        return this.pessoasService.listarComentariosPessoa(cpf);
    }
    
    public void definirFuncaoPessoa(String cpf, Funcao funcao) {
    	this.pessoasService.definirFuncaoPessoa(cpf, funcao);
    }

    public Pessoa recuperarPessoa(String cpf){
        return this.pessoasService.recuperarPessoa(cpf);
    }

    public Collection<Pessoa> getMapa() {
        return this.pessoasService.getMapa();
    }

}