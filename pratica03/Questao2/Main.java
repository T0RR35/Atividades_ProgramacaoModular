import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Bilheteria bilheteria = new Bilheteria();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1: cadastrarIngresso(); break;
                case 2: removerIngresso(); break;
                case 3: buscarIngresso(); break;
                case 4: bilheteria.listarIngressos(); break;
                case 5:
                    System.out.printf("Arrecadação total: R$ %.2f%n",
                            bilheteria.calcularArrecadacaoTotal());
                    break;
                case 6: bilheteria.listarBeneficios(); break;
                case 7: System.out.println("Encerrando o programa..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 7);

        sc.close();
    }

    private static void exibirMenu() {
        System.out.println("\n===== BILHETERIA =====");
        System.out.println("1 - Cadastrar ingresso");
        System.out.println("2 - Remover ingresso");
        System.out.println("3 - Buscar ingresso por código");
        System.out.println("4 - Listar todos os ingressos");
        System.out.println("5 - Calcular arrecadação total");
        System.out.println("6 - Listar benefícios dos ingressos");
        System.out.println("7 - Finalizar");
    }

    private static void cadastrarIngresso() {
        System.out.println("\nTipo de ingresso:");
        System.out.println("1 - Comum");
        System.out.println("2 - Estudante");
        System.out.println("3 - VIP");
        int tipo = lerInteiro("Escolha o tipo: ");

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo inválido!");
            return;
        }

        int codigo = lerInteiro("Código: ");
        if (bilheteria.buscarIngresso(codigo) != null) {
            System.out.println("Já existe um ingresso com esse código!");
            return;
        }

        System.out.print("Nome do evento: ");
        String evento = sc.nextLine();
        System.out.print("Setor: ");
        String setor = sc.nextLine();
        double valorBase = lerDouble("Valor base: ");

        Ingresso ingresso = null;

        switch (tipo) {
            case 1:
                ingresso = new IngressoComum(codigo, evento, setor, valorBase);
                break;
            case 2:
                System.out.print("Instituição de ensino: ");
                String instituicao = sc.nextLine();
                ingresso = new IngressoEstudante(codigo, evento, setor, valorBase, instituicao);
                break;
            case 3:
                System.out.print("Possui acesso ao backstage? (s/n): ");
                boolean backstage = sc.nextLine().trim().equalsIgnoreCase("s");
                int lounge = lerInteiro("Número do lounge: ");
                ingresso = new IngressoVIP(codigo, evento, setor, valorBase, backstage, lounge);
                break;
        }

        bilheteria.adicionarIngresso(ingresso);
        System.out.println("Ingresso cadastrado com sucesso!");
    }

    private static void removerIngresso() {
        int codigo = lerInteiro("Código do ingresso a remover: ");
        if (bilheteria.removerIngresso(codigo)) {
            System.out.println("Ingresso removido com sucesso!");
        } else {
            System.out.println("Ingresso não encontrado.");
        }
    }

    private static void buscarIngresso() {
        int codigo = lerInteiro("Código do ingresso: ");
        Ingresso ingresso = bilheteria.buscarIngresso(codigo);
        if (ingresso != null) {
            ingresso.exibirInformacoes();
            System.out.println("Benefícios: " + ingresso.obterBeneficios());
        } else {
            System.out.println("Ingresso não encontrado.");
        }
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = Integer.parseInt(sc.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    private static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                double valor = Double.parseDouble(sc.nextLine().trim().replace(",", "."));
                if (valor < 0) {
                    System.out.println("O valor não pode ser negativo.");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
            }
        }
    }
}