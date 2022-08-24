package sapo.Funcoes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sapo.Pessoas.Pessoa;
import sapo.Tarefas.Tarefas;

public class FuncaoProfessor extends Funcao {
	private String[] disciplinas;
    private String codigoSIAPE;

    FuncaoProfessor(String[] disciplinas, String codigoSIAPE){
    	super(0,  new ArrayList<>());
        this.disciplinas = disciplinas;
        this.codigoSIAPE = codigoSIAPE;
    }
    
    FuncaoProfessor(String[] disciplinas, String codigoSIAPE, int nivelAnterior,  List<String> codigoTarefasAnteriores){
        super(nivelAnterior, codigoTarefasAnteriores);
        this.disciplinas = disciplinas;
        this.codigoSIAPE = codigoSIAPE;
    }
    
	@Override
	int pegaNivel(List<Tarefas> tarefas, Pessoa pessoa) {
		this.removerTarefasAnteriores(tarefas);
		int numeroTarefasPendete = 0;
	
		int numeroTarefasQueBatemHabilidades = 0;
		for(Tarefas tarefa: tarefas) {
			if(tarefa.getConcluida()) { 
				numeroTarefasQueBatemHabilidades+= this.habilidadeProfessorBateComTarefa(tarefa, pessoa);
			}
			else numeroTarefasPendete++;
		}
		
		int nivel = (numeroTarefasPendete/4) +(numeroTarefasQueBatemHabilidades);
		nivel += this.nivelAnterior;
		return nivel;
	}
	
	private int habilidadeProfessorBateComTarefa(Tarefas tarefa, Pessoa pessoa) {
		List<String> habilidadesTarefa =  Arrays.asList(tarefa.getHabilidades());
		String[] habilidadesPessoa =  pessoa.getHabilidades();
		
		for(String habilidade: habilidadesPessoa)
			if(habilidadesTarefa.contains(habilidade)) return 1;
		
		for(String disciplina: disciplinas)
			if(habilidadesTarefa.contains(disciplina)) return 1;
		
		return 0;
	}
	@Override
	String representacao() {
		String representacaoDisciplina = "";
		for(String disciplina: disciplinas) representacaoDisciplina+= disciplina+",";
		return "Professor - "+ this.codigoSIAPE + " - " + representacaoDisciplina;
	}
}
