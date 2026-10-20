public class IngressoVIP extends Ingresso {
    private boolean acessoBackstage;
    private int numeroLounge;

    public IngressoVIP(int codigo, String nomeEvento, String setor,
            double valorBase, boolean acessoBackstage, int numeroLounge) {
        super(codigo, nomeEvento, setor, valorBase);
        this.acessoBackstage = acessoBackstage;
        this.numeroLounge = numeroLounge;
    }

    public boolean isAcessoBackstage() {
        return acessoBackstage;
    }

    public int getNumeroLounge() {
        return numeroLounge;
    }

    @Override
    public double calcularValorFinal() {
        return getValorBase() * 1.8;
    }

    @Override
    public String obterBeneficios() {
        StringBuilder sb = new StringBuilder("Acesso ao lounge VIP nº " + numeroLounge);
        if (acessoBackstage) {
            sb.append(" | Acesso ao backstage");
        }
        return sb.toString();
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Tipo: Ingresso VIP");
        super.exibirInformacoes();
        System.out.println("Lounge: " + numeroLounge);
        System.out.println("Acesso ao backstage: " + (acessoBackstage ? "Sim" : "Não"));
        System.out.printf("Valor final: R$ %.2f%n", calcularValorFinal());
    }
}