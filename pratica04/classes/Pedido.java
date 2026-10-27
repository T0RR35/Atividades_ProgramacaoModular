public abstract class Pedido implements Processavel{
    private int id;
    private String nomeCliente;
    private float valor;
    public int desconto;
    private float frete;
    private StatusPedido status;
    private Categoria categoria;

    public Pedido(int id, String nomeCliente, float valor, int desconto, Categoria categoria) throws ValorInvalidoException {
        if( valor <= 0 ){
            throw new ValorInvalidoException("Valor invalido!");
        }
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.valor = valor * (1 - desconto / 100f);
        this.desconto = desconto;
        this.categoria = categoria;
        this.status = StatusPedido.PENDENTE;
    }

    public void processarPedido() throws PedidoInvalidoException {
        if (status == StatusPedido.CANCELADO) {
            throw new PedidoInvalidoException("Pedido cancelado nao pode ser processado.");
        }
        if (status == StatusPedido.ENTREGUE) {
            throw new PedidoInvalidoException("Pedido já entregue nãa pode mudar de status.");
        }
        if (status == StatusPedido.PENDENTE) {
            status = StatusPedido.PROCESSANDO;
        }        
    }

    public double calcularValorFinal(){
        return (this.valor + this.frete);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getFrete() {
        return frete;
    }

    public void setFrete(float frete) {
        this.frete = frete;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) throws PedidoInvalidoException {
        if (this.getStatus().equals(StatusPedido.ENTREGUE)){
            throw new PedidoInvalidoException("Pedido ja foi entregue!");
        }
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", nomeCliente=" + nomeCliente + ", valor=" + valor + ", status=" + status + "]";
    }
}