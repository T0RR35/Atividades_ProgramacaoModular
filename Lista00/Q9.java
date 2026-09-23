import java.util.Scanner;

//RELATORIO DE PARES E IMPARES
public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[6];
        
        for(int i = 0; i < 6; i++){
            System.out.println("Digite o numero " + i + ": ");
            numeros[i] = sc.nextInt();
        }

        int qntPar = 0;
        int qntImpar = 0;

        System.out.println("Pares\t| Impares");
        for(int i = 0; i < 6; i++){
            if(numeros[i] % 2 == 0){
                System.out.println(numeros[i] + " pos " + i);
                qntPar++;
            }else{
                System.out.println("\t\t" + numeros[i] + " pos " + i);
                qntImpar++;
            }
        }
        System.out.println("Quantidade pares: "+qntPar);
        System.out.println("Quantidade impares: "+qntImpar);
        
        sc.close();
    }
}
