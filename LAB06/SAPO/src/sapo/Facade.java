package sapo;

public class Facade {

    private PessoasController pessoasController;
    private AtividadesController atividadesController;
    private TarefasController tarefasController;

    public Facade() {
        this.pessoasController = new PessoasController();
        this.atividadesController = new AtividadesController();
        this.tarefasController = new TarefasController();
    }

    public PessoasController getPessoasController() {
        return pessoasController;
    }

    public AtividadesController getAtividadesController() {
        return atividadesController;
    }

    public TarefasController getTarefasController() {
        return tarefasController;
    }

    // cadastrarPessoa e demais métodos abaixo

}