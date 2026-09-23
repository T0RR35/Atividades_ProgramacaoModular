
//LEITURA DE MATRIZES
public class Q10 {
    public static void main(String[] args) {
        
        int[][] matrizVendas = {
            {2500, 3100, 2800, 4000}, 
            {1800, 2100, 1950, 2300}, 
            {3000, 3200, 3100, 3500}, 
            {2200, 2400, 2100, 2600}, 
            {4100, 4300, 4500, 5000}, 
            {2900, 3000, 3200, 3100}, 
            {2700, 2800, 2600, 3000}, 
            {3100, 3300, 3400, 3800}, 
            {2800, 2900, 3100, 3000}, 
            {3500, 3700, 3600, 4000}, 
            {4800, 5200, 5000, 5800}, 
            {6000, 6500, 7000, 8500}  
        };

        String[] meses = {
            "janeiro", "fevereiro", "marco", "abril", "maio", "junho",
            "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"
        };

        int somaTotal = 0;
        int[] somaSemanas = new int[4];
        for(int i = 0; i < 12; i++){
            int somaMes = 0;
            for(int j = 0; j < 4; j++){
                somaMes += matrizVendas[i][j];
                somaTotal += matrizVendas[i][j];
                somaSemanas[j] += matrizVendas[i][j];
            }
            System.out.println("Mes " + meses[i] + ": "+ somaMes);
        }
        System.out.println("\nSoma das semanas: ");
        for(int i = 0; i < 4; i++){
            System.out.println("Semanas "+(i+1)+": "+ somaSemanas[i]);
        }

        System.out.println("\nSoma total: "+somaTotal);

    }
}
