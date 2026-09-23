import java.util.Scanner;

//CORRECAO DE GABARITO
public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] gabarito = new char[8];
        int totalAlunos = 10;
        int aprovados = 0;

        System.out.println("DIGITE O GABARITO: ");
        for (int i = 0; i < 8; i++) {
            System.out.print("Questao " + (i) + ": ");
            gabarito[i] = sc.next().toUpperCase().charAt(0);
        }

        for (int i = 1; i <= totalAlunos; i++) {
            System.out.print("\nDigite a matricula do aluno " + i + ": ");
            int numeroAluno = sc.nextInt();

            int nota = 0;
            System.out.println("Digite as respostas do aluno:");
            for (int j = 0; j < 8; j++) {
                System.out.print("Resposta da questao " + (j) + ": ");
                char resposta = sc.next().toUpperCase().charAt(0);

                if (resposta == gabarito[j]) {
                    nota++;
                }
            }

            System.out.println("aluno " + numeroAluno + " | nota final: " + nota);

            if (nota >= 6) {
                aprovados++;
            }
        }

        double porcentagemAprovacao = ((double) aprovados / totalAlunos) * 100;
        System.out.printf("Porcentagem de aprovação: %.2f%%\n", porcentagemAprovacao);

        sc.close();
    }
}