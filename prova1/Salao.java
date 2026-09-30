import java.time.LocalDate;
import java.util.ArrayList;

public class Salao {
    private int numero;
    private int capacidade_maxima;
    private String localizacao;
    private String tipo;
    private Organizador organizador;
    private ArrayList<Reserva> reservas; 

    public void associarOrganizador(Organizador organizador){
        this.organizador = organizador;
    }

    public void atribuirReserva(Reserva reserva){
        for(Reserva r : this.reservas){
            if(r.getData() == reserva.getData() && r.getHorario() == reserva.getHorario()){
                System.err.println("O salao ja tem uma reserva neste horario!");
                return;
            }
        }
        this.reservas.add(reserva);
    }

    public void getReservasConfirmadas(){
        for(Reserva r : this.reservas){
            System.err.println(r.toString());
        }
        System.out.println("Quantidade total de reservas: " + this.reservas.size());
    }

    public boolean estaDisponivel(LocalDate data, String horario){
        for(Reserva r : reservas){
            if(r.getData().equals(data) && r.getHorario().equals(horario)){
                return false;
            }
        }
        return true;
    }

    public Salao(){
        reservas = new ArrayList<Reserva>();
        organizador = null;
    }

    public Salao(int numero, int capacidade_maxima, String localizacao, String tipo) {
        this.numero = numero;
        this.capacidade_maxima = capacidade_maxima;
        this.localizacao = localizacao;
        this.tipo = tipo;
        reservas = new ArrayList<Reserva>();
        organizador = null;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade_maxima() {
        return capacidade_maxima;
    }

    public void setCapacidade_maxima(int capacidade_maxima) {
        this.capacidade_maxima = capacidade_maxima;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    
}
