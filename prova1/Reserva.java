import java.time.LocalDate;

public class Reserva {
    private int codigo;
    private String nome_cliente;
    private LocalDate data;
    private String horario;
    private int quantidade_convidados;
    private String status;
    private float valor_total;
    private Salao salao;
    
    public Reserva(){}

    public Reserva(int codigo, String nome_cliente, LocalDate data, String horario, int quantidade_convidados) {
        this.codigo = codigo;
        this.nome_cliente = nome_cliente;
        this.data = data;
        this.horario = horario;
        this.quantidade_convidados = quantidade_convidados;
        status = "solicitada"; //sempre começa como solicitada
    }



    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome_cliente() {
        return nome_cliente;
    }
    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public int getQuantidade_convidados() {
        return quantidade_convidados;
    }
    public void setQuantidade_convidados(int quantidade_convidados) {
        this.quantidade_convidados = quantidade_convidados;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public float getValor_total() {
        return valor_total;
    }
    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }
    @Override
    public String toString() {
        return "Reserva [codigo=" + codigo + ", nome_cliente=" + nome_cliente + ", data=" + data + ", horario="
                + horario + ", quantidade_convidados=" + quantidade_convidados + ", status=" + status + ", valor_total="
                + valor_total + ", salão=" + salao.getNumero() + ", organizador=" + salao.getOrganizador().getNome() + "]";
    }

    public Salao getSalao() {
        return salao;
    }

    public void setSalao(Salao salao) {
        this.salao = salao;
    }
}
