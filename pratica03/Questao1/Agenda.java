package Questao1;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contato> contatos;
    private int quantidade_contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
        this.quantidade_contatos = 0;
    }

    public void addContato(Contato c) {
        if (this.contatos.contains(c)) {
            System.out.println("Contato ja existe!");
            return;
        }
        this.contatos.add(c);
        this.quantidade_contatos += 1;
    }

    public void removerContato(Contato c) {
        if (this.contatos.contains(c)) {
            this.contatos.remove(c);
            this.quantidade_contatos -= 1;
            System.out.println("Exclusao bem sucedida");
            return;
        }
        System.out.println("Contato nao existe");
    }

    public Contato pesquisaContatoPorNome(String nome) {
        for (Contato c : this.contatos) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        System.out.println("Este contato nao existe");
        return null;
    }

    public Contato pesquisaContatoPorEmail(String email) {
        for (Contato c : this.contatos) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        System.out.println("Este contato nao existe");
        return null;
    }

    public Contato pesquisaContatoPorTelefone(String telefone) {
        for (Contato c : this.contatos) {
            if (c.getTelefone().equals(telefone)) {
                return c;
            }
        }
        System.out.println("Este contato nao existe");
        return null;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public int getQuantidade_contatos() {
        return quantidade_contatos;
    }

    public void setQuantidade_contatos(int quantidade_contatos) {
        this.quantidade_contatos = quantidade_contatos;
    }
}