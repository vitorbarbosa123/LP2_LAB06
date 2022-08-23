package sapo.Pessoas;

import java.util.Collection;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class PessoasRepository {

    private HashMap<String, Pessoa> pessoas;

    public PessoasRepository(){
        this.pessoas = new HashMap<>();
    }

    public Collection<Pessoa> getMapa() {
        return this.pessoas.values();
    }

    public Pessoa cadastrarPessoa(String cpf, String nome, String[] habilidades) {
        return this.pessoas.put(cpf, new Pessoa(cpf, nome, habilidades));
    }

    public void removerPessoa(String cpf){
        this.recuperarPessoa(cpf);
        this.pessoas.remove(cpf);
    }

    public Pessoa recuperarPessoa(String cpf){
        if (pessoas.containsKey(cpf)) return this.pessoas.get(cpf);
        throw new NoSuchElementException("Pessoa não existe");
    }
    
}
