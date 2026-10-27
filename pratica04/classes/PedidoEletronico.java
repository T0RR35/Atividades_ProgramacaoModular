public class PedidoEletronico extends Pedido implements Entregavel {

    public PedidoEletronico(int id, String nomeCliente, float valor) throws ValorInvalidoException {

        super(id, nomeCliente, valor, valor > 100 ? 10 : 0, Categoria.ELETRONICO);

        float frete = calcularFrete();
        super.setFrete(frete);
    }

    public float calcularFrete(){
        return (20 + this.getValor()/10);
    }
}
