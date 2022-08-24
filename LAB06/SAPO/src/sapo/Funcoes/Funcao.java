package sapo.Funcoes;
import java.util.ArrayList;
import java.util.List;

import sapo.Pessoas.Pessoa;
import sapo.Tarefas.Tarefas;

public abstract class Funcao {
    protected int nivelAnterior;
    protected List<String> codigosTarefasAnteriores;
    
    Funcao(int nivelAnterior,  List<String> codigoTarefasAnteriores){
        this.nivelAnterior = nivelAnterior;
        this.codigosTarefasAnteriores = codigoTarefasAnteriores;
    }

    abstract int pegaNivel(List<Tarefas> tarefas, Pessoa pessoa);
    abstract String representacao();

    public List<String> getCodigosTarefasAnteriores() {
        return codigosTarefasAnteriores;
    }

	public int getNivelAnterior() {
		return nivelAnterior;
	}
	
	protected void removerTarefasAnteriores(List<Tarefas> tarefas){
		List<String> tarefasString = new ArrayList<>();
		for(Tarefas tarefa : tarefas) tarefasString.add(tarefa.getCodigo());
		
		for(String codigoTarefa: this.codigosTarefasAnteriores) {
			if(tarefasString.contains(codigoTarefa)) {
				int index = tarefasString.indexOf(codigoTarefa);
				tarefasString.remove(index);
				tarefas.remove(index);
			}
		}
	}

}
