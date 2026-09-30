
public class Organizador{
    private String nome;
    private String cpf;
    private String telefone;
    private String area_atuacao;
    private Salao salao_responsavel;

    
    public Organizador(String nome, String cpf, String telefone, String area_atuacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.area_atuacao = area_atuacao;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getArea_atuacao() {
        return area_atuacao;
    }
    public void setArea_atuacao(String area_atuacao) {
        this.area_atuacao = area_atuacao;
    }
    public Salao getSalao_responsavel() {
        return salao_responsavel;
    }
    public void setSalao_responsavel(Salao salao_responsavel) {
        this.salao_responsavel = salao_responsavel;
    }

    

}