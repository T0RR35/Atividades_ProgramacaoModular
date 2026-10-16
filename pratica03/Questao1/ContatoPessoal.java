package Questao1;

public class ContatoPessoal extends Contato {
    private String data_aniversario;
    private String parentesco;

    public String getData_aniversario() {
        return data_aniversario;
    }

    public void setData_aniversario(String data_aniversario) {
        this.data_aniversario = data_aniversario;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    @Override
    public String toString() {
        return "ContatoPessoal [nome=" + getNome() + ", email=" + getEmail() + ", telefone=" + getTelefone()
                + ", aniversario=" + data_aniversario + ", parentesco=" + parentesco + "]";
    }
}