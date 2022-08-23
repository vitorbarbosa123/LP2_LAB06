package sapo;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AtividadesTest extends BaseTest {

    @Test
    void testVerificarCodigoTarefa(){
        assertEquals("STD-0", this.codigoAtividade ); // não está vindo o que deveria vir
    }

    @Test
    void testCriarAtividadeComCamposVazios(){// nome, descricao e cpf nao pode ser vazio 
        assertThrows(IllegalArgumentException.class, () -> this.facade.cadastrarAtividade("","", ""));
    }

    @Test
    void testEncerrarAtividade(){
    	// existe metodo encerrar atividade porém ele não muda nenhum atributo
    	// da classe Atividade.
    	this.facade.encerrarAtividade(this.codigoAtividade );
    	System.out.println("alou");
    }
    
    @Test
    void testExibirAtividade(){
        String stringAtividade = this.facade.exibirAtividade(this.codigoAtividade);
        assertEquals(
            this.codigoAtividade+": Estudar OO\n"
            + "Responsável: Hernandes – "+ CPF_PESSOA + "\n"
            + "==="+ "\n"
            + "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.\n"
            + "==="+ "\n"
            + "Tarefas:0/0\n", stringAtividade );
    }
}
