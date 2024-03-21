package test.program.com;

//Interface que representa um estado
interface Estado {
 void inserirMoeda();
 void ejetarMoeda();
 void selecionarProduto();
 void dispensarProduto();
}

//Implementação de um estado específico: SemMoeda
class SemMoeda implements Estado {
 @Override
 public void inserirMoeda() {
     System.out.println("Moeda inserida. Agora você pode selecionar um produto.");
 }

 @Override
 public void ejetarMoeda() {
     System.out.println("Nenhuma moeda inserida. Não é possível ejetar.");
 }

 @Override
 public void selecionarProduto() {
     System.out.println("Nenhuma moeda inserida. Selecione um produto depois de inserir uma moeda.");
 }

 @Override
 public void dispensarProduto() {
     System.out.println("Nenhuma moeda inserida. Não é possível dispensar um produto.");
 }
}

//Implementação de um estado específico: ComMoeda
class ComMoeda implements Estado {
 @Override
 public void inserirMoeda() {
     System.out.println("Já há uma moeda inserida.");
 }

 @Override
 public void ejetarMoeda() {
     System.out.println("Moeda ejetada. Volte para o estado SemMoeda.");
 }

 @Override
 public void selecionarProduto() {
     System.out.println("Produto selecionado. Agora você pode dispensar o produto.");
 }

 @Override
 public void dispensarProduto() {
     System.out.println("Produto dispensado. Volte para o estado SemMoeda.");
 }
}

//Contexto que mantém o estado atual
class MaquinaDeBebidas {
 private Estado estadoAtual;

 public MaquinaDeBebidas() {
     estadoAtual = new SemMoeda(); // Inicializa com o estado SemMoeda
 }

 public void setEstadoAtual(Estado novoEstado) {
     this.estadoAtual = novoEstado;
 }

 public void inserirMoeda() {
     estadoAtual.inserirMoeda();
 }

 public void ejetarMoeda() {
     estadoAtual.ejetarMoeda();
 }

 public void selecionarProduto() {
     estadoAtual.selecionarProduto();
 }

 public void dispensarProduto() {
     estadoAtual.dispensarProduto();
 }
}

//Exemplo de uso
public class Main {
 public static void main(String[] args) {
     MaquinaDeBebidas maquina = new MaquinaDeBebidas();

     maquina.inserirMoeda();
     maquina.selecionarProduto();
     maquina.dispensarProduto();

     maquina.ejetarMoeda();
     maquina.selecionarProduto();
 }
}
