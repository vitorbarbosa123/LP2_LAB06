package sapo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class PessoaTest extends BaseTest {

  @Test
  void testCriarAtividadeComCamposVazios(){ // nome e cpf não podem ser vazias/nulas.
	String[] habilidadesVazias = {};
    assertThrows(IllegalArgumentException.class, () -> this.facade.cadastrarPessoa("","", habilidadesVazias));
  }

  @Test 
  void testbuscarPessoa() {
    assertEquals("014-212-456-15", this.facade.buscarPessoa(CPF_PESSOA_HERNANDES));
  }

  @Test 
  void testExibirPessoa() {
    assertEquals("Hernandes", this.facade.exibirPessoa(CPF_PESSOA_HERNANDES));
  }

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

  @Test 
  void testAdicionarComentarioPessoa() {
    this.facade.adicionarComentarioPessoa(CPF_PESSOA_HERNANDES, "Esse cara é foda", "12345678900");
  }

  @Test 
  void testListarComentarioPessoa() {
    this.facade.adicionarComentarioPessoa(CPF_PESSOA_HERNANDES, "Esse cara é foda", CPF_PESSOA_VITOR);
    
    assertEquals(
      "Hernandes - 014-212-456-15" +
      "Comentários:" +
      "-- Esse cara é foda (Vitor)", 
      this.facade.listarComentariosPessoa(CPF_PESSOA_HERNANDES));
  }
}
