import java.util.Scanner;

//TEMPERATURAS DO ANO
public class Q7{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float[] temperaturas = new float[12];
        String[] meses = {
            "janeiro", "fevereiro", "marco", "abril", "maio", "junho",
            "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"
        };

        for (int i = 0; i < 12; i++) {
            System.out.print("Digite a temperatura media de " + meses[i] + ": ");
            temperaturas[i] = sc.nextFloat();
        }

        int iMaior = 0;
        int iMenor = 0;

        for (int i = 1; i < 12; i++) {
            if (temperaturas[i] > temperaturas[iMaior]) {
                iMaior = i;
            }
            if (temperaturas[i] < temperaturas[iMenor]) {
                iMenor = i;
            }
        }

        System.out.println("\nMaior temperatura: " + temperaturas[iMaior] + "°C (" + (iMaior + 1) + " - " + meses[iMaior] + ")");
        System.out.println("Menor temperatura: " + temperaturas[iMenor] + "°C (" + (iMenor + 1) + " - " + meses[iMenor] + ")");

        sc.close();
    }
}