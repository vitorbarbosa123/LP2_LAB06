package sapo.Buscas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import sapo.Atividades.Atividades;
import sapo.Atividades.AtividadesController;
import sapo.Pessoas.Pessoa;
import sapo.Pessoas.PessoasController;
import sapo.Tarefas.Tarefas;
import sapo.Tarefas.TarefasController;

public class BuscasService {
    
    private BuscasRepository buscasRepository;
    private ArrayList<Historico> historicos;

    public BuscasService() {
        this.buscasRepository = new BuscasRepository();
    }

    public ArrayList<String> exibirPessoas(String consulta, PessoasController pessoasController) {
        Collection<Pessoa> pessoas = this.buscasRepository.getMapaPessoa(pessoasController);
        String[] termos = consulta.split(" ");
        ArrayList<String> nomes = new ArrayList<>();

        for (Pessoa pessoa : pessoas) {
            int count = 0;
            for (int i = 0; i < termos.length; i++) {
                if (pessoa.getTermos().contains((termos[i]))) {
                    count += 1;
                }
            }
            if (count == termos.length) {
                nomes.add("- " + pessoa.getNome() + "\n");
            }
        }

        salvarBuscaNoHistorico("PESSOA:", nomes.toArray(new String[nomes.size()]));
        return nomes;
    }

    public ArrayList<String> buscarAtividade(String consulta, AtividadesController atividadesController) {
        HashMap<String, Atividades> atividades = this.buscasRepository.getAtividade(atividadesController);
        String[] termos = consulta.split(" ");
        ArrayList<String> saida = new ArrayList<>();

        for (String atividade : atividades.keySet()) {
            int count = 0;
            for (int i = 0; i < termos.length; i++) {
                if (atividadesController.getTermos(atividade).contains(termos[i])) {
                    count += 1;
                }
            }
            if (count == termos.length) {
                saida.add("- " + atividade + "\n");
            }
        }

        salvarBuscaNoHistorico("ATIVIDADE: ", saida.toArray(new String[saida.size()]));
        return saida;
    }

    public ArrayList<String> buscarTarefas(String nome, TarefasController tarefasController){
        Collection<Tarefas> tarefas = this.buscasRepository.getMapaTarefas(tarefasController);
        String[] termos = nome.split(" ");
        ArrayList<String> saida = new ArrayList<>();

        for (Tarefas tarefa : tarefas) {
            int count = 0;
            for (int i = 0; i < termos.length; i++) {
                if (tarefa.getNome().contains(termos[i])) {
                    count += 1;
                }
            }
            if(count == termos.length) {
                saida.add("- " + tarefa.toStringNomeAndCodigo() + "\n");
            }
        }

        salvarBuscaNoHistorico("TAREFA: ", saida.toArray(new String[saida.size()]));
        return saida;
    }

    public ArrayList<String> buscarTarefas(String idAtividade, String nome, AtividadesController atividadesController) {
        ArrayList<Tarefas> tarefas = this.buscasRepository.getTarefa(idAtividade, atividadesController);
        String[] termos = nome.split(" ");
        ArrayList<String> saida = new ArrayList<>();

        for (Tarefas tarefa : tarefas) {
            int count = 0;
            for (int i = 0; i < termos.length; i++) {
                if (tarefa.getNome().contains(termos[i])) {
                    count += 1;
                }
            }
            if(count == termos.length) {
                saida.add(tarefa.toStringNomeAndCodigo());
                break;
            }
        }

        salvarBuscaNoHistorico("TAREFA: ", saida.toArray(new String[saida.size()]));
        return saida;
    }

    public String[] buscasMaisRecentes(int nBuscas) {
        String[] buscas = new String[nBuscas];
        int ultimo = this.historicos.size() - 1;

        for (int i = 0; i < buscas.length; i++) {
            buscas[i] = this.historicos.get(ultimo).historicoToString();
            ultimo--;
        }

        return buscas;
    }

    public ArrayList<String> exibirHistoricoBusca(int indexBusca) {
        return buscasRepository.exibirHistoricoBusca(indexBusca);
    }

    private void salvarBuscaNoHistorico(String tipo, String[] array) {
        Historico historico = new Historico(tipo, array);
        this.historicos.add(historico);
    }

}
