public class IngressoEstudante extends Ingresso {
    private String instituicaoEnsino;

    public IngressoEstudante(int codigo, String nomeEvento, String setor,
            double valorBase, String instituicaoEnsino) {
        super(codigo, nomeEvento, setor, valorBase);
        this.instituicaoEnsino = instituicaoEnsino;
    }

    public String getInstituicaoEnsino() {
        return instituicaoEnsino;
    }

    @Override
    public double calcularValorFinal() {
        return getValorBase() * 0.5; 
    }

    @Override
    public String obterBeneficios() {
        return "Direito à meia-entrada (50% de desconto).";
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Tipo: Ingresso Estudante");
        super.exibirInformacoes();
        System.out.println("Instituição de ensino: " + instituicaoEnsino);
        System.out.printf("Valor final: R$ %.2f%n", calcularValorFinal());
    }
}