package sapo.Buscas;

public class Buscas {
    
    private String consulta;
    private String nome;
    private String idAtividade;
    // obs: antes era cpf id ???
    private String id;
    private int nBuscas;
    private int indexBusca;

    public Buscas(String consulta, String nome, String idAtividade, String id, int nBuscas, int indexBusca) {
        this.consulta = consulta;
        this.nome = nome;
        this.idAtividade = idAtividade;
        this.id = id;
        this.nBuscas = nBuscas;
        this.indexBusca = indexBusca;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(String idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getnBuscas() {
        return nBuscas;
    }

    public void setnBuscas(int nBuscas) {
        this.nBuscas = nBuscas;
    }
    
    public int getIndexBusca() {
        return indexBusca;
    }

    public void setIndexBusca(int indexBusca) {
        this.indexBusca = indexBusca;
    }

}
