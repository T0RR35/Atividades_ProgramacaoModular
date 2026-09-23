import java.util.Scanner;

//INTERSECAO DE MATRICULAS
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] alunosPM = new int[n];
        int[] alunosCalculo = new int[n];
        int[] intersecao = new int[n];

        for (int i = 0; i < n; i++){
            System.out.println("Digite o aluno "+ i + " de PM: ");
            alunosPM[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++){
            System.out.println("Digite o aluno "+ i + " de Calculo: ");
            alunosCalculo[i] = sc.nextInt();
        }
        sc.close();
        
        //CALCULANDO INTERSEÇÃO NA MAO: 
        int qnt_repetidos = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(alunosPM[i] == alunosCalculo[j]){
                    intersecao[qnt_repetidos] = alunosPM[i];
                    qnt_repetidos++;
                }
            }
        }

        System.out.print("Repetidos: ");
        for(int i = 0; i < qnt_repetidos; i++){
            System.out.print(intersecao[i]);
        }
    }
}
