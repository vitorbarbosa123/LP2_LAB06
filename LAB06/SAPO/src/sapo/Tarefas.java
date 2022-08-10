package sapo;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Tarefas {
    private String codigo;

    private Atividades atividade;
    private boolean concluida;

    private Map<String, Pessoa> responsaveis;

    private int horasGasta;

    private String nome;

    private String[] habilidades;

    public Tarefas(String taferaID, String nome, String[] habilidades) {
        this.codigo = taferaID;
        this.nome = nome;
        this.concluida = false;
        this.habilidades = habilidades;
    }


    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarHoras(int novasHoras) {
        if(this.concluida) return;
        this.horasGasta += novasHoras;
    }

    /**
	 * função de remover horas, e caso as horas ser removida sejam maior que as horas atuais, vai zerar as 0.
	 *  
	 * @param horasRemover 
	 */
    public void removerHoras(int horasRemover) {
        if(this.concluida) return;

        if(horasRemover > this.horasGasta) this.horasGasta = 0;
        else this.horasGasta -= horasRemover;
    }

    public void concluirTarefa() {
        this.concluida = true;
    }

    public void adicionarNovoResponsavel(String cpf, Pessoa pessoa){
        responsaveis.put(cpf, pessoa);
    }

    public void removerResponsavel(String cpf){
        verificarResponsavel(cpf);
        responsaveis.remove(cpf);
    }

    private void verificarResponsavel(String cpf){
        if(responsaveis.containsKey(cpf)) return; 
        throw new NoSuchElementException("Pessoa não está nessa tarefa");
    }

    @Override
    public String toString() {
        String result = " Preparar material de estudo - STD-0-15 \n"
                + "- " + this.nome + " \n"
                + "Professor, Objetos \n"
                + "(" + this.horasGasta + " hora(s) executada(s)) \n"
                + "=== \n"
                + this.getResponsaveisString();

        return result;
    }

    private String getResponsaveisString(){
        String result = "Equipe: \n";
        for (var entry : this.responsaveis.entrySet()) {
            result += entry.getValue().toString()+" \n";
        }

        return result;
    }

    public String getCodigo() {
        return codigo;
    }

}