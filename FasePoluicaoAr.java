package projetoSustania;

import projetoSustania.Fase;
import java.util.Scanner;

public class FasePoluicaoAr extends Fase {
   public FasePoluicaoAr(Jogador jogador, NPC anciao, Scanner scanner) {
       super(jogador, anciao, scanner);
   }

   @Override
   public void jogar() {
       System.out.println(jogador.getNome() + ", você está na fase: Poluição do ar");
       anciao.falar("A poluição do ar é um grande problema devido ao uso excessivo de combustíveis fósseis.");
       anciao.falar("Incentive o uso de transporte público e bicicletas.");

       // Escolha da arma
       String armaEscolhida = escolherArma();
       System.out.println("Você escolheu a arma: " + armaEscolhida);

       // Verifica se a arma escolhida é a ideal para solucionar o problema
       if (armaEscolhida.equals("Chamado da Natureza")) {
           System.out.println("Parabéns! Você escolheu a arma ideal para prevenir a poluição do ar!");
           concluida = true;
       } else {
           System.out.println("A arma escolhida não é eficaz para prevenir a poluição do ar. Você perdeu vida no processo.");
           reduzirVida(30); // Reduz a vida do jogador
       }
   }
}