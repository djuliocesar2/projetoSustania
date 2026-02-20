package projetoSustania;

import java.util.Scanner;
import projetoSustania.*;

public abstract class Fase {
   protected Jogador jogador;
   protected NPC anciao;
   protected Scanner scanner;
   protected boolean concluida;
   protected int vidaJogador;

   public Fase(Jogador jogador, NPC anciao, Scanner scanner) {
       this.jogador = jogador;
       this.anciao = anciao;
       this.scanner = scanner;
       this.concluida = false;
       this.vidaJogador = 100; // Vida inicial do jogador
   }

   public boolean isConcluida() {
       return concluida;
   }

   public abstract void jogar();

   // Método para o jogador escolher uma arma
   protected String escolherArma() {
       System.out.println("\nEscolha uma arma para usar nesta fase:");
       System.out.println("1. Força da Floresta");
       System.out.println("2. Super Sugar");
       System.out.println("3. Chamado da Natureza");
       System.out.print("Escolha: ");
       int escolha = scanner.nextInt();
       switch (escolha) {
           case 1:
               return "Força da Floresta";
           case 2:
               return "Super Sugar";
           case 3:
               return "Chamado da Natureza";
           default:
               System.out.println("Opção inválida. Usando a arma padrão.");
               return "Força da Floresta";
       }
   }

   // Método para reduzir a vida do jogador
   protected void reduzirVida(int dano) {
       vidaJogador -= dano;
       if (vidaJogador <= 0) {
           System.out.println("Você perdeu toda a sua vida! Fim de jogo.");
           System.exit(0); // Encerra o jogo se a vida do jogador acabar
       }
       System.out.println("Sua vida atual: " + vidaJogador);
   }
}