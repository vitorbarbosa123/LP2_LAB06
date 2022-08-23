package sapo.Tarefas;

public class TarefasGerenciais {
  
  private String TarefasGerenciaisId;
  private String nome;
  private boolean concluida;
  private int horasTotais;

  private TarefasService tarefasService;
  private String habilidades; 

  public TarefasGerenciais (String TarefasGerenciaisId, String nome, String[] habilidades) {
    this.TarefasGerenciaisId = TarefasGerenciaisId;
    this.nome = nome;
    this.habilidades = this.recuperaHabilidadesDeTarefas();
    this.concluida = false;
    this.horasTotais = this.recuperaHorasDeTarefas();
  }

  public void concluirTarefaGerencial() {
    this.concluida = true;
  }

  public int recuperaHorasDeTarefas() {
    int horasDeTarefa = this.tarefasService.getHorasDeTodasAsTarefas();

    return horasDeTarefa;
  }

  public String recuperaHabilidadesDeTarefas() {
    String habilidades = this.tarefasService.getHabilidadesDeTodasAsTarefas();

    return habilidades;
  }


  public void adicionarHoras(int novasHoras) {
    this.seTarefaConcluidaException();
    this.horasTotais += novasHoras;
  }

  public void removerHoras(int horasRemover) {
    this.seTarefaConcluidaException();

    if(horasRemover > this.horasTotais) this.horasTotais = 0;
    else this.horasTotais -= horasRemover;
  }

  private void seTarefaConcluidaException(){
    if(this.concluida) throw new IllegalStateException("Tarefa gerencial já está concluida");
}
}
