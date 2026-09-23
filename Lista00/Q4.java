import java.util.Scanner;

//UNIAO DE VETORES
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] vetor1 = new int[n];
        int[] vetor2 = new int[m];
        int[] uniao = new int[n+m];

        for (int i = 0; i < n; i++){
            System.out.println("Digite o valor "+ i + " do vetor 1: ");
            vetor1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++){
            System.out.println("Digite o valor "+ i + " do vetor 2: ");
            vetor2[i] = sc.nextInt();
        }
        sc.close();

        //CALCULANDO NA MAO
        int k = 0;

        for (int i = 0; i < n; i++) {
            boolean existe = false;
            for (int j = 0; j < k; j++) {
                if (vetor1[i] == uniao[j]) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                uniao[k] = vetor1[i];
                k++;
            }
        }

        for (int i = 0; i < m; i++) {
            boolean existe = false;
            for (int j = 0; j < k; j++) {
                if (vetor2[i] == uniao[j]) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                uniao[k] = vetor2[i];
                k++;
            }
        }

        System.out.println("Vetor Uniao:");
        for (int i = 0; i < k; i++) {
            System.out.println("Elemento " + i + ": " + uniao[i]);
        }

    }
}
