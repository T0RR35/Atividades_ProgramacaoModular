public class Produto {
    private String nome;
    private String codigo;
    private float preco;
    private int quantidade; //faria mais sentido estar na classe estoque, mas ordens sao ordens

    public Produto(String nome, String codigo, float preco, int qnt) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = qnt;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public float getPreco() {
        return preco;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void adicionarEstoque(int qnt){
        quantidade += qnt;
    }

    public boolean retirarEstoque(int qnt){
        if (qnt > quantidade) {
            return false;
        }
        quantidade -= qnt;
        return true;
    }
}