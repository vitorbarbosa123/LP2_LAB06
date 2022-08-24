package sapo.Funcoes;

import java.util.List;

import sapo.Pessoas.Pessoa;
import sapo.Tarefas.Tarefas;

public class SemFuncao extends Funcao{

	public SemFuncao(int nivelAnterior, List<String> codigosTarefasAnteriores) {
		super(nivelAnterior, codigosTarefasAnteriores);
		// TODO Auto-generated constructor stub
	}

	@Override
	int pegaNivel(List<Tarefas> tarefas, Pessoa pessoa) {
		this.removerTarefasAnteriores(tarefas);
		int numeroTarefasPendete = 0;
		int numeroTarefasFinalizadas = 0;
		
		for(Tarefas tarefa: tarefas) {
			if(tarefa.getConcluida()) numeroTarefasFinalizadas++;
			else numeroTarefasPendete++;
		}
		
		int nivel = (numeroTarefasPendete/2) + numeroTarefasFinalizadas;
		nivel += this.nivelAnterior;
		return nivel;
	}
	
	
	@Override
	String representacao() {
		// TODO Auto-generated method stub
		return null;
	}

}
