package sapo.Buscas;

// SOCORRO
public class HistoricoBusca {

	private Buscas busca;
	private String[] documentosIds; // para que mudo?

	public HistoricoBusca(Buscas busca, String[] documentosIds) {
		this.busca = busca;
		this.documentosIds = documentosIds;
	}

	public String debug() {
        // preciso mesmo desse metodo?
		return this.busca.descreveConsulta();
	}

    // como pego os ids de pessoas, atividades e tarefas?
	public String[] ids() {
		return documentosIds;
	}

}