import java.util.Scanner;

public class desafio {
    public static void main(String[] args) {
        String[] jogos = new String[15];
        char[] times = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'};
        char campeao;

        Scanner sc = new Scanner(System.in);

        int cont = 2;
        int jogoQueInteressa = 14;

        for(int jogo = 14; jogo >= 0; jogo--){
            System.out.println("Digite o placar do jogo " + (jogo+1) +": ");
            String placar = sc.nextLine();
            int saldo1, saldo2;
            saldo1= (int)(placar.charAt(0));
            saldo2= (int)(placar.charAt(1));
            jogos[jogo] = placar;

            if(jogo == jogoQueInteressa && cont <= 8){
                if(saldo1>saldo2){
                    jogoQueInteressa -= cont;
                    cont *= 2;
                }else{
                    jogoQueInteressa -= cont - 1;
                    cont = (cont * 2) - 1;
                }
                System.out.println("Jogo que me interessa: " + (jogoQueInteressa+1));
            }
        }
        sc.close();

        int saldo1, saldo2;
        saldo1= (int)(jogos[jogoQueInteressa].charAt(0));
        saldo2= (int)(jogos[jogoQueInteressa].charAt(1));    
        
        if(saldo1>saldo2){
            campeao = times[((jogoQueInteressa+1)*2) -2];
        }else{
            campeao = times[((jogoQueInteressa+1)*2)-1];
        }

        System.out.println("Vencedor: " + campeao);
    }
}