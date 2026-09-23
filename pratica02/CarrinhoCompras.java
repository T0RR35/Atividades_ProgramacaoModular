import java.util.ArrayList;
import java.util.Scanner;

public class CarrinhoCompras {

    static ArrayList<Produto> produtosCadastrados = new ArrayList<Produto>();
    static Estoque estoque = new Estoque();
    static Fatura fatura = new Fatura();

    public static void comprar(Scanner sc) {
        for (Produto produto : produtosCadastrados) {
            System.out.println(
                    produto.getNome() + " - R$" + produto.getPreco() + " - " + produto.getCodigo());
        }

        Produto produtoEscolhido = null;

        while (produtoEscolhido == null) {
            System.out.println("Digite o codigo do produto (ou 0 para voltar): ");
            String codigoDado = sc.nextLine();

            if (codigoDado.equals("0")) {
                return;
            }

            produtoEscolhido = estoque.buscarProduto(codigoDado);

            if (produtoEscolhido == null) {
                System.err.println("Codigo invalido!");
            }
        }

        System.out.println("Quantos vc quer comprar?: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        if (!produtoEscolhido.retirarEstoque(quantidade)) {
            System.err.println("Estoque insuficiente!");
            return;
        }

        Item item = new Item(produtoEscolhido, quantidade);
        fatura.incluirItem(item);
        System.out.println("Compra realizada!");
    }

    public static void verFatura(Scanner sc) {
        ArrayList<Item> itens = fatura.getItens();

        if (itens.isEmpty()) {
            System.out.println("Fatura vazia.");
            return;
        }

        for (int i = 0; i < itens.size(); i++) {
            Item item = itens.get(i);
            System.out.println(i + " - " + item.getProduto().getNome() + " x" + item.getQuantidade()
                    + " - R$" + item.getValorTotal());
        }
        System.out.println("Valor total: R$" + fatura.getValorTotal());
    }

    public static void excluirItem(Scanner sc) {
        verFatura(sc);

        if (fatura.getItens().isEmpty()) {
            return;
        }

        System.out.println("Digite o indice do item a excluir (ou -1 para voltar): ");
        int indice = sc.nextInt();
        sc.nextLine();

        if (indice == -1) {
            return;
        }

        fatura.removerItem(indice);
    }

    public static void alterarItem(Scanner sc) {
        verFatura(sc);

        if (fatura.getItens().isEmpty()) {
            return;
        }

        System.out.println("Digite o indice do item a alterar (ou -1 para voltar): ");
        int indice = sc.nextInt();

        if (indice == -1) {
            return;
        }

        System.out.println("Nova quantidade: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        fatura.alterarItem(indice, quantidade);
    }

    public static void finalizar(Scanner sc) {
        System.out.println("Compra finalizada! Valor final: R$" + fatura.getValorTotal());
        System.exit(0);
    }

    public static void consultarProduto(Scanner sc) {
        System.out.println("Digite o codigo do produto (ou 0 para voltar): ");
        String codigo = sc.nextLine();

        if (codigo.equals("0")) {
            return;
        }

        Produto produto = estoque.buscarProduto(codigo);

        if (produto == null) {
            System.err.println("Produto nao encontrado!");
            return;
        }

        System.out.println("Nome: " + produto.getNome());
        System.out.println("Codigo: " + produto.getCodigo());
        System.out.println("Preco: R$" + produto.getPreco());
        System.out.println("Quantidade em estoque: " + produto.getQuantidade());
    }

    public static void adicionarProdutoEstoque(Scanner sc) {
        System.out.println("Nome do produto: ");
        String nome = sc.nextLine();
        System.out.println("Codigo do produto: ");
        String codigo = sc.nextLine();
        System.out.println("Preco do produto: ");
        float preco = sc.nextFloat();
        System.out.println("Quantidade inicial: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        Produto produto = new Produto(nome, codigo, preco, quantidade);

        if (estoque.addProduto(produto)) {
            produtosCadastrados.add(produto);
            System.out.println("Produto adicionado!");
        } else {
            System.err.println("Ja existe um produto com esse codigo!");
        }
    }

    public static void removerProdutoEstoque(Scanner sc) {
        System.out.println("Digite o codigo do produto (ou 0 para voltar): ");
        String codigo = sc.nextLine();

        if (codigo.equals("0")) {
            return;
        }

        Produto produto = estoque.buscarProduto(codigo);

        if (produto == null) {
            System.err.println("Produto nao encontrado!");
            return;
        }

        estoque.removeProd(produto);
        produtosCadastrados.remove(produto);
        System.out.println("Produto removido!");
    }

    public static void reporEstoque(Scanner sc) {
        System.out.println("Digite o codigo do produto (ou 0 para voltar): ");
        String codigo = sc.nextLine();

        if (codigo.equals("0")) {
            return;
        }

        Produto produto = estoque.buscarProduto(codigo);

        if (produto == null) {
            System.err.println("Produto nao encontrado!");
            return;
        }

        System.out.println("Quantidade a adicionar: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        produto.adicionarEstoque(quantidade);
        System.out.println("Estoque atualizado!");
    }

    public static void estoqueBaixo() {
        for (Produto produto : produtosCadastrados) {
            if (produto.getQuantidade() < 5) {
                System.out.println(produto.getNome() + " - " + produto.getQuantidade());
            }
        }
    }

    public static void main(String[] args) {
        Produto arroz = new Produto("Arroz", "COD01", 9.90f, 10);
        Produto feijao = new Produto("Feijao", "COD02", 7.70f, 10);
        Produto milho = new Produto("Milho", "COD03", 2.4f, 10);

        produtosCadastrados.add(arroz);
        produtosCadastrados.add(feijao);
        produtosCadastrados.add(milho);

        estoque.addProduto(arroz);
        estoque.addProduto(feijao);
        estoque.addProduto(milho);

        Scanner sc = new Scanner(System.in);

        boolean escolheu = false;
        do {
            System.out.println("1- Comprar\n2-Ver Fatura\n3-Excluir item\n4-Alterar item\n5-Finalizar\n"
                    + "6-Consultar Produto\n7-Adicionar Produto ao Estoque\n8-Remover Produto\n"
                    + "9-Repor Estoque\n10-Produtos com Estoque Baixo");
            int escolha = sc.nextInt();
            sc.nextLine();
            escolheu = true; // qualquer coisa vira false depois

            switch (escolha) {
                case 1:
                    comprar(sc);
                    break;
                case 2:
                    verFatura(sc);
                    break;
                case 3:
                    excluirItem(sc);
                    break;
                case 4:
                    alterarItem(sc);
                    break;
                case 5:
                    finalizar(sc);
                    break;
                case 6:
                    consultarProduto(sc);
                    break;
                case 7:
                    adicionarProdutoEstoque(sc);
                    break;
                case 8:
                    removerProdutoEstoque(sc);
                    break;
                case 9:
                    reporEstoque(sc);
                    break;
                case 10:
                    estoqueBaixo();
                    break;
                default:
                    System.err.println("Escolha um numero valido!");
                    escolheu = false;
                    break;
            }
        } while (escolheu);

        sc.close();
    }
}