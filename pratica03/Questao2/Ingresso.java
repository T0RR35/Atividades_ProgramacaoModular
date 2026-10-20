public abstract class Ingresso {
    private int codigo;
    private String nomeEvento;
    private String setor;
    private double valorBase;

    public Ingresso(int codigo, String nomeEvento, String setor, double valorBase) {
        this.codigo = codigo;
        this.nomeEvento = nomeEvento;
        this.setor = setor;
        this.valorBase = valorBase;
    }

    public int getCodigo() { return codigo; }
    public String getNomeEvento() { return nomeEvento; }
    public String getSetor() { return setor; }
    public double getValorBase() { return valorBase; }

    public void exibirInformacoes() {
        System.out.println("Código: " + codigo);
        System.out.println("Evento: " + nomeEvento);
        System.out.println("Setor: " + setor);
        System.out.printf("Valor base: R$ %.2f%n", valorBase);
    }

    public abstract double calcularValorFinal();

    public abstract String obterBeneficios();
}