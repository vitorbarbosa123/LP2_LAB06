package sapo;

import java.util.*;

public class PessoasController {
                    
    private HashMap<String, Pessoa> pessoas;

    public PessoasController() {
        this.pessoas = new HashMap<>();
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
        this.pessoas.put(cpf, new Pessoa(cpf, nome, habilidades));
    }

    public Pessoa buscarPessoa(String cpf) {
        return this.pessoas.get(cpf);
    }

    public String exibirPessoa(String cpf) {
        Pessoa pessoa = this.pessoas.get(cpf);
        String saida = pessoa.getNome() + " - " + pessoa.getCpf() + "\n";
        String[] habilidades = pessoa.getHabilidades();
        for (int i = 0 ; i < habilidades.length; i++) {
            saida = saida + "- " + habilidades[i] + "\n";
        }
        return saida;
    }

    public void alterarNomePessoa(String cpf, String novoNome) {
        this.pessoas.get(cpf).setNovoNome(novoNome);
    }

    public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
        this.pessoas.get(cpf).setNovasHabilidades(novasHabilidades);
    }

    public void removerPessoa(String cpf) {
        this.pessoas.remove(cpf);
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
        this.pessoas.get(cpf).setComentario("-- " + comentario + " (" + autorCpf + ")");
    }

    public String listarComentariosPessoa(String cpf) {
        Pessoa pessoa = this.pessoas.get(cpf);
        String saida = pessoa.getNome() + " - " + pessoa.getCpf() + "\n";
        ArrayList<String> comentarios = pessoa.getComentarios();
        for (int i = 0 ; i < comentarios.size(); i++) {
            saida = saida + "-- " + comentarios.get(i) + "\n";
        }
        return saida;
    }

    Pessoa recuperarPessoaOrException(String cpf){
        if(pessoas.containsKey(cpf)) return pessoas.get(cpf);
        throw new NoSuchElementException("Pessoa não existe");
    }
}