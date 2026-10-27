public class PedidoRoupa extends Pedido implements Entregavel{

    public PedidoRoupa(int id, String nomeCliente, float valor) throws ValorInvalidoException {

        super(id, nomeCliente, valor, valor > 200 ? 20 : 0, Categoria.ELETRONICO);

        float frete = calcularFrete();
        super.setFrete(frete);
    }

    public float calcularFrete(){
        return (10 + this.getValor()/20);
    }

}
