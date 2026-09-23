import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private HashMap<String, Produto> estoque;
    private int tamanho;

    public Estoque(){
        estoque = new HashMap<String, Produto>();
        tamanho = 0;
    }

    public boolean addProduto(Produto prod){
        if (estoque.containsKey(prod.getCodigo())) {
            return false;
        }
        estoque.put(prod.getCodigo(), prod);
        tamanho++;
        return true;
    }

    public boolean verificaProd(Produto prod){
        return estoque.containsKey(prod.getCodigo());
    }

    public void removeProd(Produto prod){
        estoque.remove(prod.getCodigo());
        tamanho--;
    }

    public Produto buscarProduto(String codigo){
        return estoque.get(codigo);
    }

    public void listProdutos(){
        for(Map.Entry<String, Produto> entry : estoque.entrySet())
        System.out.println(entry.getValue().getNome());
    }

    public int getTamanho(){
        return tamanho;
    }
}