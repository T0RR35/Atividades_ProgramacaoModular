package Questao1;

import java.util.Objects;

public abstract class Contato {
    private String nome;
    private String email;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Necessario para que ArrayList.contains() detecte contatos repetidos
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Contato))
            return false;
        Contato c = (Contato) o;
        return Objects.equals(nome, c.nome)
                && Objects.equals(email, c.email)
                && Objects.equals(telefone, c.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, telefone);
    }

    @Override
    public String toString() {
        return "Contato [nome=" + nome + ", email=" + email + ", telefone=" + telefone + "]";
    }
}