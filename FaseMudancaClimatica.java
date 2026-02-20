package projetoSustania;

import projetoSustania.Fase;
import java.util.Scanner;

public class FaseMudancaClimatica extends Fase {
   public FaseMudancaClimatica(Jogador jogador, NPC anciao, Scanner scanner) {
       super(jogador, anciao, scanner);
   }

   @Override
   public void jogar() {
       System.out.println(jogador.getNome() + ", você está na fase: Mudança Climática");
       anciao.falar("A Mudança Climática está afetando Sustainia de maneira devastadora.");
       anciao.falar("É hora de usar todos os recursos que você tem para proteger o planeta!");

       // Escolha da arma
       String armaEscolhida = escolherArma();
       System.out.println("Você escolheu a arma: " + armaEscolhida);

       // Verifica se a arma escolhida é a ideal para solucionar o problema
       if (armaEscolhida.equals("Força da Floresta")) {
           System.out.println("Parabéns! Você escolheu a arma ideal para prevenir a mudança climática!");
           concluida = true;
       } else {
           System.out.println("A arma escolhida não é eficaz para prevenir a mudança climática. Você perdeu vida no processo.");
           reduzirVida(30); // Reduz a vida
       }
   }
}