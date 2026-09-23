import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double[] precos = new double[10];
        int[] quantidades = new int[10];
        
        System.out.println("Digite os precos e as quantidades vendidas para os 10 objetos:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Preco do objeto " + (i + 1) + ": ");
            precos[i] = sc.nextDouble();
            System.out.print("Quantidade vendida do objeto " + (i + 1) + ": ");
            quantidades[i] = sc.nextInt();
        }
        
        double valorGeralVendas = 0;
        int maiorQuantidade = quantidades[0];
        int posMaisVendido = 0;
        
        System.out.println("\n\n\n");
        for (int i = 0; i < 10; i++) {
            double valorTotalObjeto = precos[i] * quantidades[i];
            valorGeralVendas += valorTotalObjeto;
            
            if (quantidades[i] > maiorQuantidade) {
                maiorQuantidade = quantidades[i];
                posMaisVendido = i;
            }
            
            System.out.println("Objeto " + (i + 1) + " | Quantidade: " + quantidades[i] + " | Valor Unitario: RS " + precos[i] + " | Valor Total: RS " + valorTotalObjeto);
        }
        
        double comissao = valorGeralVendas * 0.05;
        double salarioTotal = 545.00 + comissao;
        
        System.out.println("\n--- RESUMO GERAL ---");
        System.out.println("Valor geral das vendas: RS " + valorGeralVendas);
        System.out.println("Comissão do vendedor (5%): RS " + comissao);
        System.out.println("Salário total do vendedor: RS " + salarioTotal);
        System.out.println("Valor do objeto mais vendido: RS " + precos[posMaisVendido] + " (Posição no vetor: " + posMaisVendido + ")");
        
        sc.close();
    }
}