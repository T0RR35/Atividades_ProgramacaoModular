import java.util.ArrayList;
import java.util.List;

public class Bilheteria {
    private List<Ingresso> ingressos = new ArrayList<>();

    public void adicionarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    public boolean removerIngresso(int codigo) {
        Ingresso ingresso = buscarIngresso(codigo);
        if (ingresso != null) {
            ingressos.remove(ingresso);
            return true;
        }
        return false;
    }

    public Ingresso buscarIngresso(int codigo) {
        for (Ingresso i : ingressos) {
            if (i.getCodigo() == codigo) {
                return i;
            }
        }
        return null;
    }

    public void listarIngressos() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }
        for (Ingresso i : ingressos) {
            i.exibirInformacoes();
            System.out.println("------------------------------");
        }
    }

    public double calcularArrecadacaoTotal() {
        double total = 0;
        for (Ingresso i : ingressos) {
            total += i.calcularValorFinal();
        }
        return total;
    }

    public void listarBeneficios() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }
        for (Ingresso i : ingressos) {
            System.out.println("Ingresso " + i.getCodigo() + " (" + i.getNomeEvento() + "): "
                    + i.obterBeneficios());
        }
    }
}