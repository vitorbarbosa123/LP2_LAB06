package sapo.Pessoas;

import java.util.ArrayList;
import java.util.Collection;

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
        String saida = pessoa.getNome() + " - " + pessoa.getCpf() + "\n";
        ArrayList<String> comentarios = pessoa.getComentarios();
        for (int i = 0 ; i < comentarios.size(); i++) {
            saida = saida + "-- " + comentarios.get(i) + "\n";
        }
        return saida;
    }

    public Collection<Pessoa> getMapa() {
        return this.pessoasRepository.getMapa();
    }
    
}
