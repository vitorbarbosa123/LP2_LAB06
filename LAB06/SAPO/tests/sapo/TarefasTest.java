package sapo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TarefasTest extends BaseTest {
	
	@BeforeEach
	private void factoryTarefa() {
		String[] lista = {"Álgebra", "FMCC2"};
		this.codigoTarefa = this.facade.cadastrarTarefa(this.codigoAtividade, "Responder miniteste", lista);
	}

	@Test
	void testVerificaCodigoTarefa() {
		assertEquals(this.codigoAtividade + "-0", this.codigoTarefa);
	}
	
	@Test
	void cadastrarTarefaVazia() {
		String[] listaVazia = {};
		assertThrows(IllegalArgumentException.class, () -> this.facade.cadastrarTarefa("","", listaVazia));
	}
	
}
