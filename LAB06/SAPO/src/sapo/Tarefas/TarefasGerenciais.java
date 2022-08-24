package sapo.Tarefas;

public class TarefasGerenciais {
  
  private String TarefasGerenciaisId;
  private String nome;
  private boolean concluida;
  private int tempoRealizacao;

  private TarefasService tarefasService;
  private String habilidades; 

  public TarefasGerenciais (String TarefasGerenciaisId, String nome, String[] habilidades) {
    this.TarefasGerenciaisId = TarefasGerenciaisId;
    this.nome = nome;
    this.habilidades = this.recuperaHabilidadesDeTarefas();
    this.concluida = false;
    this.tempoRealizacao = tempoRealizacao;
  }

  public void concluirTarefaGerencial() {
    this.concluida = true;
  }

  public String recuperaHabilidadesDeTarefas() {
    String habilidades = this.tarefasService.getHabilidadesDeTodasAsTarefas();

    return habilidades;
  }


  public void adicionarHoras(int novasHoras) {
    this.seTarefaConcluidaException();
    this.tempoRealizacao += novasHoras;
  }

  public void removerHoras(int horasRemover) {
    this.seTarefaConcluidaException();

    if(horasRemover > this.tempoRealizacao) this.tempoRealizacao = 0;
    else this.tempoRealizacao -= horasRemover;
  }

  private void seTarefaConcluidaException(){
    if(this.concluida) throw new IllegalStateException("Tarefa gerencial já está concluida");
}
}
