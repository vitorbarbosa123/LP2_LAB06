package sapo.Pessoas;

import java.util.ArrayList;
import java.util.Collection;

import sapo.Funcoes.Funcao;

public class PessoasService {

    private PessoasRepository pessoasRepository;

    public PessoasService(){
        pessoasRepository = new PessoasRepository();
    }

    public Pessoa cadastrarPessoa(String cpf, String nome, String[] habilidades) {
    	return this.pessoasRepository.cadastrarPessoa(cpf, nome, habilidades);
    }

    public String buscarPessoa(String cpf) {
        Pessoa pessoa = this.pessoasRepository.recuperarPessoa(cpf);
        String saida = pessoa.getNome() + " - " + pessoa.getCpf() + "\n";
        String[] habilidades = pessoa.getHabilidades();
        for (int i = 0 ; i < habilidades.length; i++) {
            saida = saida + "- " + habilidades[i] + "\n";
        }
        return saida;
    }

    public void alterarNomePessoa(String cpf, String novoNome) {
        Pessoa pessoa = this.pessoasRepository.recuperarPessoa(cpf);
        pessoa.setNovoNome(novoNome);
    }

    public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
        Pessoa pessoa = this.pessoasRepository.recuperarPessoa(cpf);
        pessoa.setNovasHabilidades(novasHabilidades);
    }

    public void removerPessoa(String cpf) {
        this.pessoasRepository.removerPessoa(cpf);
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
        Pessoa pessoa = this.pessoasRepository.recuperarPessoa(cpf);
        pessoa.setComentario("-- " + comentario + " (" + autorCpf + ")");
    }

    public String listarComentariosPessoa(String cpf) {
        Pessoa pessoa = this.pessoasRepository.recuperarPessoa(cpf);
        String buscaPessoa = pessoa.getNome() + " - " + pessoa.getCpf() + "\n";
        String result = "";
        ArrayList<String> comentarios = pessoa.getComentarios();
        for (int i = 0 ; i < comentarios.size(); i++) {
            result = 
                buscaPessoa + "\n" + 
                "Comentários:" + 
                "-- " + comentarios.get(i) + "(" + pessoa.getNome() + ")" +  "\n";
            }
        return result;
    }
    
    public void definirFuncaoPessoa(String cpf, Funcao funcao) {
    	Pessoa pessoa = this.recuperarPessoa(cpf);
    	pessoa.definirFuncaoPessoa(funcao);
    }
    public Pessoa recuperarPessoa(String cpf){
    	return this.pessoasRepository.recuperarPessoa(cpf);
    }
    
    public Collection<Pessoa> getMapa() {
        return this.pessoasRepository.getMapa();
    }
    
}
