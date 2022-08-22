package sapo.Buscas;

import java.util.ArrayList;
import java.util.Map;

import sapo.Atividades.Atividades;
import sapo.Atividades.AtividadesRepository;
import sapo.Pessoas.Pessoa;
import sapo.Pessoas.PessoasRepository;
import sapo.Tarefas.Tarefas;


// CORRIGIR ERROS
public class BuscasController {

    private BuscasService buscasService;

    public BuscasController(BuscasService buscasService) {
        this.buscasService = buscasService;
    }
    
    public String[] exibirPessoas(String consulta) {
        String[] termosConsulta = consulta.split(" ");
        String[] nomes;
        int i = 0;
        for (Pessoa pessoa : this.pessoas.values()) {
            if (pessoa.getTermos().contains(termosConsulta)) {
                nomes[i] = ("- " + pessoa.getNome() + "\n");
                i++;
            }
        }
        return nomes;
    }

    // A busca retorna uma lista de representações com cada atividade, ordenadas pelo ID.
    public String[] buscarAtividade(String consulta) {
        String[] termosConsulta = consulta.split(" ");
        String[] nomes;
        int i = 0;
        for (AtividadesRepository atividade : this.atividades.values()) {
            if (atividade.getTermos().contains(termosConsulta)) {
                nomes[i] = ("- " + atividade.criaCodigoAtividade(nomes) + "\n");
                i++;
            }
        }
        return nomes;
    }

    // busca em todas as atividades
    public String[] buscarTarefas(String nome){
        String[] termosConsulta = nome.split(" ");
        String[] nomeTarefa = tarefas.getNome().split(" ");
        String[] representacoes;
        int i = 0;
        for (Tarefas tarefa : this.tarefas.values()) {
            if (nomeTarefa.contains(termosConsulta)) {
                representacoes[i] = ("- " + tarefa.toStringNomeAndCodigo() + "\n");
                i++;
            }
        }
        return representacoes;
    }

    // limita a busca para 1 atividade
    public String[] buscarTarefas(String idAtividade, String nome) {
        String[] termosConsulta = nome.split(" ");
        String[] nomeTarefa = tarefas.get(idAtividade).getNome().split(" ");
        String[] representacoes;
        int i = 0;
        for (Tarefas tarefa : this.tarefas.get(idAtividade).values()) {
            if (nomeTarefa.contains(termosConsulta)) {
                representacoes[i] = ("- " + tarefa.toStringNomeAndCodigo() + "\n");
                i++;
            }
        }
        return representacoes;
    }


    // ??? NÃO SEI FAZER / NÃO ENTENDI
    public String[] sugerirTarefas(String id) {

    }

    // HistoricoBuscas
    public String[] buscasMaisRecentes(int nBuscas) {

    }

    public String[] exibirHistóricoBusca(int indexBusca) {

    }
}
