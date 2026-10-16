package Questao1;

public class ContatoProfissional extends Contato {
    private String empresa;
    private String cargo;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "ContatoProfissional [nome=" + getNome() + ", email=" + getEmail() + ", telefone=" + getTelefone()
                + ", empresa=" + empresa + ", cargo=" + cargo + "]";
    }
}