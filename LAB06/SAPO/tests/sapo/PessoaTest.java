package sapo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class PessoaTest extends BaseTest {

  @Test 
  void testAlternarNomePessoa() {
    this.facade.alterarNomePessoa(CPF_PESSOA_HERNANDES, "Vitor");
  }

  @Test 
  void testAlterarHabilidadesPessoas() {
	String[] novasHabilidades = {"Global no Cs", "Exímio Procrastinador"};
    this.facade.alterarHabilidadesPessoa(CPF_PESSOA_HERNANDES, novasHabilidades);
  }

  @Test 
  void testRemoverPessoas() {
    this.facade.removerPessoa(CPF_PESSOA_HERNANDES);
  }

}
