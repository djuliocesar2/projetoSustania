package projetoSustania;

import projetoSustania.Fase;
import java.util.Scanner;

public class FaseEnchente extends Fase {
   public FaseEnchente(Jogador jogador, NPC anciao, Scanner scanner) {
       super(jogador, anciao, scanner);
   }

   @Override
   public void jogar() {
       System.out.println(jogador.getNome() + ", você está na fase: Enchente");
       anciao.falar("Enchentes estão se tornando mais frequentes em Sustainia devido ao desmatamento.");
       anciao.falar("Use a técnica de plantio de árvores para controlar o fluxo de água.");

       // Escolha da arma
       String armaEscolhida = escolherArma();
       System.out.println("Você escolheu a arma: " + armaEscolhida);

       // Verifica se a arma escolhida é a ideal para solucionar o problema
       if (armaEscolhida.equals("Super Sugar")) {
           System.out.println("Parabéns! Você escolheu a arma ideal para prevenir as enchentes!");
           concluida = true;
       } else {
           System.out.println("A arma escolhida não é eficaz para prevenir as enchentes. Você perdeu vida no processo.");
           reduzirVida(30); // Reduz a vida do jogador
       }
   }
}