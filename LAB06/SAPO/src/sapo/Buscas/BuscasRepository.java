package sapo.Buscas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class BuscaRepository {

	private List<HistoricoBusca> buscas;

	BuscaRepository() {
		this.buscas = new ArrayList<>();
	}

	public void adicionaBusca(Buscas busca, DocumentoDTO[] documentos) {
		String[] ids = Stream.of(documentos)
			.map(DocumentoDTO::getId)
			.collect(Collectors.toList())
			.toArray(new String[] {});
		this.buscas.add(new HistoricoBusca(busca, ids));
	}

	public HistoricoBusca recuperar(int numero) {
		return this.buscas.get(numero);
	}

}

