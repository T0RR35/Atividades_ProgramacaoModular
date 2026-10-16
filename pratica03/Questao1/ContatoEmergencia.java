package Questao1;

public class ContatoEmergencia extends Contato {
    private int grauPrioridade;
    private String observacao;

    public int getGrauPrioridade() {
        return grauPrioridade;
    }

    public void setGrauPrioridade(int grauPrioridade) {
        this.grauPrioridade = grauPrioridade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "ContatoEmergencia [nome=" + getNome() + ", email=" + getEmail() + ", telefone=" + getTelefone()
                + ", grauPrioridade=" + grauPrioridade + ", observacao=" + observacao + "]";
    }
}