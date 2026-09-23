public class Item {
    private Produto produto;
    private int quantidade;
    private float valorTotal;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = produto.getPreco() * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.valorTotal = produto.getPreco() * quantidade;
    }

    public float getValorTotal() {
        return valorTotal;
    }
}