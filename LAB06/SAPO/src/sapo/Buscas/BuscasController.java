package sapo.Buscas;

import java.util.ArrayList;

import sapo.Atividades.AtividadesController;
import sapo.Pessoas.PessoasController;
import sapo.Tarefas.TarefasController;

public class BuscasController {

    private BuscasService buscasService;

    public BuscasController(BuscasService buscasService) {
        this.buscasService = buscasService;
    }

    public ArrayList<String> exibirPessoas(String consulta, PessoasController pessoasController) {
        return this.buscasService.exibirPessoas(consulta, pessoasController);
    }

    public ArrayList<String> buscarAtividade(String consulta, AtividadesController atividadesController) {
        return this.buscasService.buscarAtividade(consulta, atividadesController);
    }

    public ArrayList<String> buscarTarefas(String nome, TarefasController tarefasController){
        return this.buscasService.buscarTarefas(nome, tarefasController);
    }

    public ArrayList<String> buscarTarefas(String idAtividade, String nome, AtividadesController atividadesController) {
        return this.buscasService.buscarTarefas(idAtividade, nome, atividadesController);
    }

    public String[] buscasMaisRecentes(int nBuscas) {
        return this.buscasService.buscasMaisRecentes(nBuscas);
    }

    public ArrayList<String> exibirHistoricoBusca(int indexBusca) {
        return this.buscasService.exibirHistoricoBusca(indexBusca);
    }

}
