public class PedidoAlimento extends Pedido {

    public PedidoAlimento(int id, String nomeCliente, float valor) throws ValorInvalidoException {

        super(id, nomeCliente, valor, 0, Categoria.ALIMENTO);
        super.setFrete(5f);
    }
}
