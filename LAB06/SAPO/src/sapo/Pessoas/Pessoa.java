package sapo.Pessoas;

import java.util.ArrayList;

import sapo.Funcoes.Funcao;
import sapo.Funcoes.SemFuncao;

public class Pessoa {

    private String cpf;
    private String nome;
    private String[] habilidades;
    private Funcao funcao;
    private ArrayList<String> comentarios;

    public Pessoa(String cpf, String nome, String[] habilidades) {
        this.cpf = cpf;
        this.nome = nome;
        this.habilidades = habilidades;
        this.funcao = new SemFuncao(0, new ArrayList<>());
    }
    
    public void definirFuncaoPessoa(Funcao funcao) {
    	this.funcao = funcao;
    }
    
    public void removerFuncao() {
    	this.funcao = new SemFuncao(funcao.getNivelAnterior(), funcao.getCodigosTarefasAnteriores());
    }
    
    public Funcao getFuncao() {
    	return this.funcao;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        String bloco1 = cpf.substring(0, 3);
	    String bloco2 = cpf.substring(3, 6);
	    String bloco3 = cpf.substring(6, 9);
	    String bloco4 = cpf.substring(9, 11);
	
	    this.cpf = bloco1 + "." + bloco2 + "." + bloco3 + "-" + bloco4;
        return this.cpf;
    }

    public String[] getHabilidades() {
        return habilidades;
    }

    public void setNovoNome(String novoNome) {
        this.nome = novoNome;
    }

    public void setNovasHabilidades(String[] novasHabilidades) {
        this.habilidades = novasHabilidades;
    }

    public void setComentario(String comentario) {
        this.comentarios.add(comentario);
    }

    public ArrayList<String> getComentarios() {
        return comentarios;
    }
    
    public ArrayList<String> getTermos() {
        ArrayList<String> termos = new ArrayList<>();
        termos.add(cpf);
        String[] nomeSplit = nome.split(" ");
        for (int i = 0; i < nomeSplit.length; i++) {
            termos.add(nomeSplit[i]);
        }
        for (int i = 0; i < habilidades.length; i++) {
            termos.add(habilidades[i]);
        }
        return termos;
    }

    
}