package sapo;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    public static final String CPF_PESSOA = "014-212-456-15";
   
    protected Facade facade;
    protected String codigoAtividade;
    
    @BeforeEach
	void setUp() throws Exception {
		this.facade = new Facade();
        this.factoryPessoa();
        this.factoryAtividade();
	}

    private void factoryPessoa(){
        String[] habilidades = {"sleep", "dormi", "andar"};
        this.facade.cadastrarPessoa(CPF_PESSOA, "Hernandes", habilidades);
    }

    private void factoryAtividade(){
        this.codigoAtividade = this.facade.cadastrarAtividade(
            "Estudar OO",
            "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.",
            CPF_PESSOA
        );
    }

    protected void factoryTarefa(){
        // pass
    }
    
    protected void methodFactoryPessoa(String cpf, String nome, String[] habilidades){
        this.facade.cadastrarPessoa(cpf, nome, habilidades);
    }
}
