package projetoSustania;

import java.util.Scanner;
import java.util.InputMismatchException;
import projetoSustania.Jogador;
import projetoSustania.NPC;
import projetoSustania.*;

public class MainJogo {
   public static void main(String[] args) {
       System.out.println("Bem-vindo ao Sustainia: A Jornada pela Ecologia!");
       System.out.println("Prepare-se para enfrentar desastres ambientais e salvar nossa cidade!");

       Scanner scanner = new Scanner(System.in);
       boolean jogoAtivo = true;
       Jogador jogador = criarJogador(scanner);
       NPC anciao = new NPC("Ancião");

       while (jogoAtivo) {
           System.out.println("\nSelecione:");
           System.out.println("1. Iniciar game");
           System.out.println("2. Sair do jogo\n");
           System.out.print("Escolha uma opção: ");

           try {
               int opcao = scanner.nextInt();

               switch (opcao) {
                   case 1:
                       jogarJogo(jogador, anciao, scanner);
                       break;
                   case 2:
                       System.out.println("Obrigado por jogar Sustainia! Até a próxima!");
                       jogoAtivo = false;
                       break;
                   default:
                       System.out.println("Opção inválida. Por favor, escolha novamente.");
               }
           } catch (InputMismatchException e) {
               System.out.println("Entrada inválida. Por favor, insira um número.");
               scanner.next(); // Limpa a entrada inválida
           }
       }
       scanner.close();
   }

   private static Jogador criarJogador(Scanner scanner) {
       System.out.print("\nDigite o nome do seu personagem: ");
       String nomeJogador = scanner.next();
       return new Jogador(nomeJogador);
   }

   private static void jogarJogo(Jogador jogador, NPC anciao, Scanner scanner) {
       Fase[] fases = {
               new FaseEnchente(jogador, anciao, scanner),
               new FasePoluicaoAr(jogador, anciao, scanner),
               new FaseMudancaClimatica(jogador, anciao, scanner)
       };

       for (Fase fase : fases) {
           fase.jogar();
           if (!fase.isConcluida()) {
               System.out.println("Você não concluiu esta fase. Deseja tentar novamente? (s/n)");
               String opcao = scanner.next();
               if (!opcao.equalsIgnoreCase("s")) {
                   System.out.println("Fim de jogo. Você não salvou Sustainia.");
                   return;
               }
           }
       }

       System.out.println("\nParabéns! Você concluiu todas as fases e salvou Sustainia!");
   }
}