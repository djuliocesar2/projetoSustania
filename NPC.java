package projetoSustania;

public class NPC {
   private String nome;

   public NPC(String nome) {
       this.nome = nome;
   }

   public void falar(String mensagem) {
       System.out.println(nome + ": " + mensagem);
   }
}