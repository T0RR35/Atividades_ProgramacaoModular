import java.util.Scanner;

//CALCULAR FATORIAL
public class Q1 {
    public static int fat(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fat(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fat(sc.nextInt()));
        sc.close();
    }
}
