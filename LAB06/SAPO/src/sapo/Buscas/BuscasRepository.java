package sapo.Buscas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import sapo.Atividades.Atividades;
import sapo.Atividades.AtividadesController;
import sapo.Pessoas.Pessoa;
import sapo.Pessoas.PessoasController;
import sapo.Tarefas.Tarefas;
import sapo.Tarefas.TarefasController;

class BuscasRepository {

	private List<Historico> buscas;
	private ArrayList<Historico> historicos;

	BuscasRepository() {
		this.buscas = new ArrayList<>();
	}

	public Collection<Pessoa> getMapaPessoa(PessoasController pessoasController) {
		return pessoasController.getMapa();
	}

	public HashMap<String, Atividades> getAtividade(AtividadesController atividadesController) {
		return atividadesController.getAtividade();
	}

	public Collection<Tarefas> getMapaTarefas(TarefasController tarefasController) {
		return tarefasController.getMapa();
	} 

	public ArrayList<Tarefas> getTarefa(String idAtividade, AtividadesController atividadesController) {
		return atividadesController.recuperaAtividade(idAtividade).getTarefas();
	}

	public Historico recuperar(int numero) {
		return this.buscas.get(numero);
	}

	public ArrayList<String> exibirHistoricoBusca(int indexBusca) {
        return this.historicos.get(indexBusca).getHistorico();
    }

}

