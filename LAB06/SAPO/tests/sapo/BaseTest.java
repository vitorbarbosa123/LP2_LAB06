package sapo;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BaseTest {
    public static final String CPF_PESSOA_HERNANDES = "014-212-456-15";
    public static final String CPF_PESSOA_VITOR = "012-345-678-90";
   
    protected Facade facade;
    protected String codigoAtividade;
    
    @BeforeEach
	void setUp() throws Exception {
		this.facade = new Facade();
        this.factoryPessoa();
        this.factoryAtividade();
	}

    private void factoryPessoa(){
        String[] habilidadesHernandes = {"sleep", "dormi", "andar"};
        String[] habilidadesVitor = {"CS", "Procrastinar", "Nadar"};
        this.facade.cadastrarPessoa(CPF_PESSOA_HERNANDES, "Hernandes", habilidadesHernandes);
        this.facade.cadastrarPessoa(CPF_PESSOA_VITOR, "Vitor", habilidadesVitor);
    }

    private void factoryAtividade(){
        this.codigoAtividade = this.facade.cadastrarAtividade(
            "Estudar OO",
            "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.",
            CPF_PESSOA_HERNANDES
        );
    }

    protected void factoryTarefa(){
        // pass
    }
    
    protected void methodFactoryPessoa(String cpf, String nome, String[] habilidades){
        this.facade.cadastrarPessoa(cpf, nome, habilidades);
    }
}
