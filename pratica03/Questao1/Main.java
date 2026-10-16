package Questao1;

import java.util.Scanner;

public class Main {

    private static String ler(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    private static void adicionarContato(Scanner sc, Agenda a) {
        String tipo = ler(sc, "Tipo (1-Pessoal, 2-Profissional, 3-Emergencia): ");
        Contato c;

        switch (tipo) {
            case "1": {
                ContatoPessoal p = new ContatoPessoal();
                c = p;
                break;
            }
            case "2":
                c = new ContatoProfissional();
                break;
            case "3":
                c = new ContatoEmergencia();
                break;
            default:
                System.out.println("Tipo invalido!");
                return;
        }

        c.setNome(ler(sc, "Nome: "));
        c.setEmail(ler(sc, "Email: "));
        c.setTelefone(ler(sc, "Telefone: "));

        if (c instanceof ContatoPessoal) {
            ContatoPessoal p = (ContatoPessoal) c;
            p.setData_aniversario(ler(sc, "Data de aniversario: "));
            p.setParentesco(ler(sc, "Parentesco: "));
        } else if (c instanceof ContatoProfissional) {
            ContatoProfissional p = (ContatoProfissional) c;
            p.setEmpresa(ler(sc, "Empresa: "));
            p.setCargo(ler(sc, "Cargo: "));
        } else {
            ContatoEmergencia e = (ContatoEmergencia) c;
            try {
                e.setGrauPrioridade(Integer.parseInt(ler(sc, "Grau de prioridade (numero): ")));
            } catch (NumberFormatException ex) {
                System.out.println("Valor invalido, prioridade definida como 0.");
                e.setGrauPrioridade(0);
            }
            e.setObservacao(ler(sc, "Observacao: "));
        }

        a.addContato(c);
    }

    private static void removerContato(Scanner sc, Agenda a) {
        String criterio = ler(sc, "Deseja procurar por telefone, email ou nome? ").trim().toLowerCase();
        Contato c;

        switch (criterio) {
            case "nome":
                c = a.pesquisaContatoPorNome(ler(sc, "Nome: "));
                break;
            case "email":
                c = a.pesquisaContatoPorEmail(ler(sc, "Email: "));
                break;
            case "telefone":
                c = a.pesquisaContatoPorTelefone(ler(sc, "Telefone: "));
                break;
            default:
                System.out.println("Criterio invalido!");
                return;
        }

        // Se for null, a Agenda ja informou que o contato nao existe
        if (c != null) {
            a.removerContato(c);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String res = "";
        Agenda a = new Agenda();

        while (!res.equals("g")) {
            System.out.println("\n(a) Adicionar contato"
                + "\n(b) Remover contato"
                + "\n(c) Buscar contato por nome"
                + "\n(d) Buscar contato por email"
                + "\n(e) Buscar contato por telefone"
                + "\n(f) Consultar tamanho da Agenda"
                + "\n(g) Finalizar");
            res = sc.nextLine().trim().toLowerCase();

            switch (res) {
                case "a":
                    adicionarContato(sc, a);
                    break;

                case "b":
                    removerContato(sc, a);
                    break;

                case "c": {
                    Contato c = a.pesquisaContatoPorNome(ler(sc, "Nome: "));
                    if (c != null) System.out.println(c);
                    break;
                }

                case "d": {
                    Contato c = a.pesquisaContatoPorEmail(ler(sc, "Email: "));
                    if (c != null) System.out.println(c);
                    break;
                }

                case "e": {
                    Contato c = a.pesquisaContatoPorTelefone(ler(sc, "Telefone: "));
                    if (c != null) System.out.println(c);
                    break;
                }

                case "f":
                    System.out.println("A agenda possui " + a.getQuantidade_contatos() + " contato(s).");
                    break;

                case "g":
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        }

        sc.close();
    }
}