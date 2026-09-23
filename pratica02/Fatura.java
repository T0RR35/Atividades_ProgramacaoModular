import java.util.ArrayList;

public class Fatura {
    private ArrayList<Item> itens;
    private float valorTotal;

    public Fatura() {
        itens = new ArrayList<Item>();
        valorTotal = 0;
    }

    public void incluirItem(Item item) {
        itens.add(item);
        valorTotal += item.getValorTotal();
    }

    public void removerItem(int indice) {
        valorTotal -= itens.get(indice).getValorTotal();
        itens.remove(indice);
    }

    public void alterarItem(int indice, int quantidade) {
        Item item = itens.get(indice);
        valorTotal -= item.getValorTotal();
        item.setQuantidade(quantidade);
        valorTotal += item.getValorTotal();
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public float getValorTotal() {
        return valorTotal;
    }
}