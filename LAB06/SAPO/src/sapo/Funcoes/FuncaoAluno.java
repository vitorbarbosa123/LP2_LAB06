package sapo.Funcoes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sapo.Pessoas.Pessoa;
import sapo.Tarefas.Tarefas;

public class FuncaoAluno extends Funcao {
    private String matricula;
    private int periodo;

    FuncaoAluno(String matricula, int periodo){
    	super(0,  new ArrayList<>());
        this.matricula = matricula;
        this.periodo = periodo;
    }
    FuncaoAluno(String matricula, int periodo, int nivelAnterior,  List<String> codigoTarefasAnteriores){
        super(nivelAnterior, codigoTarefasAnteriores);
        this.matricula = matricula;
        this.periodo = periodo;
    }
	@Override
	int pegaNivel(List<Tarefas> tarefas, Pessoa pessoa) {
		this.removerTarefasAnteriores(tarefas);
		int numeroTarefasPendete = 0;
		int numeroTarefasFinalizadas = 0;
		int numeroTarefasQueBatemHabilidades = 0;
		for(Tarefas tarefa: tarefas) {
			if(tarefa.getConcluida()) { 
				numeroTarefasFinalizadas++;
				numeroTarefasQueBatemHabilidades+= this.habilidadePessoaBateComTarefa(tarefa, pessoa);
			}
			else numeroTarefasPendete++;
		}
		
		int niveisQueBatem = (int)Math.ceil(numeroTarefasQueBatemHabilidades*1.5);
		int nivel = (numeroTarefasPendete/2) + numeroTarefasFinalizadas+(niveisQueBatem);
		nivel += this.nivelAnterior;
		return nivel;

	}
	
	private int habilidadePessoaBateComTarefa(Tarefas tarefa, Pessoa pessoa) {
		List<String> habilidadesTarefa =  Arrays.asList(tarefa.getHabilidades());
		String[] habilidadesPessoa =  pessoa.getHabilidades();
		for(String habilidade: habilidadesPessoa)
			if(habilidadesTarefa.contains(habilidade)) return 1;
		
		return 0;
	}
	
	@Override
	String representacao() {
		return "Aluno - "+ this.matricula + " - " + this.periodo;
	}

}
