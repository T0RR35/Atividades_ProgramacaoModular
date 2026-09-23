import java.util.Arrays;
import java.util.Scanner;

//COMPARACAO DE NUMS
public class Q2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int[] vetor = new int[3];
        
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        sc.close();
        
        vetor[0] = x;
        vetor[1] = y;
        vetor[2] = z;

        int menor = Arrays.stream(vetor).min().getAsInt();
        int maior = Arrays.stream(vetor).max().getAsInt();
        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);

        if (x > y && x < z) {
            System.out.println("X está dentro do intervalo [y, z]");
        } else {
            System.out.println("X está fora do intervalo [y, z]");
        }

        if (x % y == 0 && x % z == 0) {
            System.out.println("X eh divisivel por y e por z");
        }
    }
}
