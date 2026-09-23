import java.util.Scanner;

//ANALISE DE DADOS DE HABITANTES
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maiorIdade = Integer.MIN_VALUE;
        int menorIdade = Integer.MAX_VALUE;
        int quantidadeMulherEspecifica = 0;

        while (true) {
            System.out.print("Digite a idade do habitante (ou -1 para encerrar): ");
            int idade = sc.nextInt();

            if (idade == -1) {
                break;
            }

            sc.nextLine(); // limpa o buffer do teclado

            System.out.print("Digite o sexo (masculino/feminino): ");
            String sexo = sc.nextLine();

            System.out.print("Digite a cor dos olhos (azuis/verdes/castanhos): ");
            String corOlhos = sc.nextLine();

            System.out.print("Digite a cor dos cabelos (louros/castanhos/pretos): ");
            String corCabelos = sc.nextLine();

            if (sexo.equals("feminino") && corOlhos.equals("Verde") && corCabelos.equals("loiro") && idade >= 18 && idade <= 35){
                quantidadeMulherEspecifica++;
            }

            if (idade > maiorIdade) {
                maiorIdade = idade;
            } else if (idade < menorIdade) {
                menorIdade = idade;
            }
        }

        System.out.println("\nMaior idade cadastrada: " + maiorIdade);
        System.out.println("Menor idade cadastrada: " + menorIdade);
        System.out.println("Quantidade do tipo especifico: " + quantidadeMulherEspecifica);

        sc.close();
    }
}