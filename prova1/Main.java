import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Salao[] saloes = new Salao[3];
        for(int i = 0; i < saloes.length; i++){
            saloes[i] = new Salao(i, 200, "Rua "+i, "Festa");
        }

        Organizador[] organizadores = new Organizador[3];
        organizadores[0] = new Organizador("Joao", "123456789", "123456789", "Festa");
        organizadores[1] = new Organizador("Maria", "192837465", "32465942", "Festa");
        organizadores[2] = new Organizador("Glender", "987654321", "243765932", "Festa");


        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        

        Scanner scInt = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);

        System.out.println("Bem vindo! Digite seu nome: ");
        String nome = scString.nextLine();

        int escolha = 0;
        boolean loop = true;

        while(loop){
            System.out.println(
                "0- Sair\n1- Cadastrar reserva\n2- Associar um organizador a um salão\n3- Atribuir reserva a um salão\n4-Exibir todas as reservas confirmadas em um salão específico\n5- Informar a quantidade total de reservas finalizadas para cada salão\n6- Buscar reservas por status\n7- Exibir os detalhes completos de uma reserva específica");
            escolha = scInt.nextInt();

            switch (escolha) {
                case 0:
                    loop = false;
                    break;


                case 1:
                    System.out.println("Digite uma data (AAAA-MM-DD): ");
                    LocalDate data = LocalDate.parse(scString.nextLine());
                    System.out.println("Digite um horario (minusculo): ");
                    String horario = scString.nextLine();
                    System.out.println("Digite a quantidade de convidados: ");
                    int convidados = scInt.nextInt();

                    int id = (int)Math.random();
                    reservas.add(new Reserva(id, nome, data, horario, convidados));
                    System.out.println("Reserva realizada! seu id eh " + id);
                    break;


                case 2: 
                    System.out.println("Digite o CPF do organizador: ");
                    String cpf = scString.nextLine();

                    System.out.println("Digite o numero do salao: ");
                    int num = scInt.nextInt();

                    Salao s = new Salao(); 
                    for(int i = 0; i < saloes.length; i++){
                        if(saloes[i].getNumero() == num){
                            s = saloes[i];
                            break;
                        }
                    }
                    //eu teria que validar se o numero eh valido mas nao daria tempo de fazer durante a prova!

                    for(int i = 0; i < organizadores.length; i++){
                        if(organizadores[i].getCpf().equals(cpf)){
                            organizadores[i].getSalao_responsavel().associarOrganizador(null); // deixa null o ultimo salao que ele tava
                            s.associarOrganizador(organizadores[i]);
                            break;
                        }
                    }
                    break;


                case 3:
                    System.out.println("Digite o codigo da reserva: ");
                    int code = scInt.nextInt();

                    Reserva r = new Reserva();
                    for (Reserva reserva : reservas){
                        if(reserva.getCodigo() == code){
                            r = reserva;
                            break;
                        }
                    }
                    //eu teria que validar se o codigo eh valido mas nao daria tempo de fazer durante a prova!

                    System.out.println("Digite o numero do salao: ");
                    int numeroSalao = scInt.nextInt();

                    for(int i = 0; i < saloes.length; i++){
                        if(saloes[i].getNumero() == numeroSalao){
                            if(saloes[i].estaDisponivel(r.getData(), r.getHorario())){
                                saloes[i].atribuirReserva(r);
                                r.setStatus("confirmada");
                                r.setSalao(saloes[i]);
                            }else{
                                System.err.println("Salao nao disponivel no horario!");
                            }
                        }
                    }
                    break;


                case 4:
                    System.out.println("Digite o numero do salao: ");
                    int numero = scInt.nextInt();

                    for(int i = 0; i < saloes.length; i++){
                        if(saloes[i].getNumero() == numero){
                            saloes[i].getReservasConfirmadas();
                            break;
                        }
                    }
                    break;


                case 5:
                    break;


                case 6:
                    System.out.println("Digite o status (minusculo): ");
                    String status = scString.nextLine();

                    for(Reserva res : reservas){
                        if(res.getStatus() == status){
                            res.toString();
                        }
                    }
                    break;


                case 7:
                    System.out.println("Digite o codigo da reserva: ");
                    int codigo = scInt.nextInt();

                    for(Reserva re : reservas){
                        if(re.getCodigo() == codigo){
                            re.toString();
                            break;
                        }
                    }
                    break;


                default:
                    System.err.println("Numero invalido! Digite novamente: ");
                    scInt.nextInt();
            }
        }
        scInt.close();
        scString.close();
    }
}
