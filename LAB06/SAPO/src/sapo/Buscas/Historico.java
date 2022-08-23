package sapo.Buscas;

import java.util.ArrayList;

public class Historico {
    
    private ArrayList<String> historico;

    public Historico(String tipo, String[] array) {
        this.historico = new ArrayList<>();
        preencherHistorico(tipo, array);
    }

    private void preencherHistorico(String tipo, String[] array) {
        this.historico.add(tipo);
        for (String elemento : array) {
            historico.add(elemento);
        }
    }

    public ArrayList<String> getHistorico() {
        return historico;
    }

    public String historicoToString() {
        String saida = "";
        for (int i = 0; i < historico.size(); i++) {
            saida += historico.get(i) + "\n";
        }
        return saida;
    }

}
