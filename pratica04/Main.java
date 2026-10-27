import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Pedido> pedidos = new ArrayList<>();
    private static int proximoId = 1;

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== SISTEMA DE PEDIDOS =====");
            System.out.println("1 - Cadastrar pedido");
            System.out.println("2 - Alterar status de um pedido");
            System.out.println("3 - Processar pedidos");
            System.out.println("4 - Remover cancelados");
            System.out.println("5 - Exibir lista de pedidos");
            System.out.println("6 - Exibir pedidos entregáveis");
            System.out.println("0 - Encerrar");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrarPedido();
                case 2 -> alterarStatus();
                case 3 -> processarPedidos();
                case 4 -> removerCancelados();
                case 5 -> exibirPedidos();
                case 6 -> exibirEntregaveis();
                default -> System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void cadastrarPedido() {
        System.out.println("Categoria: 1 - Eletrônico | 2 - Roupa | 3 - Alimento\nCategoria: ");
        int cat = sc.nextInt();

        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine().trim();

        float valor = lerFloat("Valor do pedido: ");

        try {
            Pedido pedido;
            switch (cat) {
                case 1 -> pedido = new PedidoEletronico(proximoId, nome, valor);
                case 2 -> pedido = new PedidoRoupa(proximoId, nome, valor);
                case 3 -> pedido = new PedidoAlimento(proximoId, nome, valor);
                default -> {
                    System.out.println("Categoria invalida!");
                    return;
                }

            }
            pedidos.add(pedido);
            proximoId++;
            System.out.println("Pedido cadastrado com sucesso! ID: " + pedido.getId());
        } catch (ValorInvalidoException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    private static void alterarStatus() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        int id = sc.nextInt();
        Pedido pedido = buscarPorId(id);
        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.println("Status atual: " + pedido.getStatus());
        StatusPedido[] opcoes = StatusPedido.values();
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println((i + 1) + " - " + opcoes[i]);
        }

        int escolha = sc.nextInt();
        if (escolha < 1 || escolha > opcoes.length) {
            System.out.println("Opção inválida!");
            return;
        }

        try {
            pedido.setStatus(opcoes[escolha - 1]);
            System.out.println("Status alterado para " + pedido.getStatus());
        } catch (PedidoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void processarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        Iterator<Pedido> it = pedidos.iterator();
        while (it.hasNext()) {
            Pedido p = it.next();
            try {
                p.processarPedido();
                System.out.printf("Pedido %d processado. Valor final: R$ %.2f%n",
                        p.getId(), p.calcularValorFinal());
            } catch (PedidoInvalidoException e) {
                System.out.println("Pedido " + p.getId() + " não processado: " + e.getMessage());
            }
        }
    }

    private static void removerCancelados() {
        int removidos = 0;

        Iterator<Pedido> it = pedidos.iterator();
        while (it.hasNext()) {
            Pedido p = it.next();
            if (p.getStatus() == StatusPedido.CANCELADO) {
                it.remove();
                removidos++;
            }
        }
        System.out.println(removidos + " pedido(s) cancelado(s) removido(s).");
    }

    private static void exibirPedidos() {
        System.out.println("\n--- Lista de pedidos ---");
        boolean achou = false;

        for (Pedido p : pedidos) {
            if (p.getStatus() != StatusPedido.CANCELADO) {
                System.out.println(p);
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhum pedido para exibir.");
        }
    }

    private static void exibirEntregaveis() {
        boolean achou = false;

        for (Pedido p : pedidos) {
            if (p instanceof Entregavel) {
                System.out.println(p + " | Frete: R$ " + p.getFrete());
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhum pedido entregável.");
        }
    }

    private static Pedido buscarPorId(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    private static float lerFloat(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Float.parseFloat(sc.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
            }
        }
    }
}