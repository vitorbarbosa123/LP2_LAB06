package sapo;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import sapo.Atividades.Atividades;

public class AtividadesTest extends BaseTest {

    @Test
    void testVerificarCodigoTarefa(){
        assertEquals("STD-0", this.codigoAtividade );
    }

    @Test
    void testCriarAtividadeComCamposVazios(){
        assertThrows(IllegalArgumentException.class, () -> this.facade.cadastrarAtividade("","", ""));
    }

    @Test
    void testEncerrarAtividade(){
    	// existe metodo encerrar atividade porém ele não muda nenhum atributo
    	// da classe Atividade.
    	this.facade.encerrarAtividade(this.codigoAtividade);
    }
    
    @Test
    void testExibirAtividade(){
        String stringAtividade = this.facade.exibirAtividade(this.codigoAtividade);
        assertEquals(this.codigoAtividade+": Estudar OO\n"
            + "Responsável: Hernandes – "+ CPF_PESSOA + "\n"
            + "==="+ "\n"
            + "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.\n"
            + "==="+ "\n"
            + "Tarefas:0/0\n", stringAtividade
        );
    }

    @Test
    void testDesativarAtividade() {
    	this.facade.desativarAtividade(this.codigoAtividade);
    }

    @Test
    public void testReabrirAtividade() {
    	this.facade.reabrirAtividade(this.codigoAtividade);
    }

    @Test
    public void testAlterarDescricaoAtividade() {
    	this.facade.alterarDescricaoAtividade(this.codigoAtividade, "teste");
    	Atividades atividade = this.facade.recuperaAtividade(this.codigoAtividade);
        assertEquals("teste", atividade.getDescricao());
    }
    
    @Test
    public void testAlterarResponsavel(){
    	String[] habilidades = {"sleep", "dormi", "andar"};
    	String novoCpf = "214-14012";
    	this.methodFactoryPessoa(novoCpf, "teste",habilidades);
    	
    	this.facade.alterarResponsavelAtividade(this.codigoAtividade,novoCpf);
    	Atividades atividade = this.facade.recuperaAtividade(this.codigoAtividade);
        assertEquals(novoCpf, atividade.getCPF());
    }

}
