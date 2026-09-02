package pratica01;
import java.util.Scanner;

class Aluno{
    private String nome;
    private int idade;
    private String casa;
    private int coragem;
    private int inteligencia;
    private int ambicao;
    private int lealdade;
    private int estrategia;
    private int criatividade;
    
    public Aluno(String nome, int idade, String casa, int coragem, int inteligencia, int ambicao, int lealdade,
            int estrategia, int criatividade) {
        this.nome = nome;
        this.idade = idade;
        this.casa = casa;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.estrategia = estrategia;
        this.criatividade = criatividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public int getCoragem() {
        return coragem;
    }

    public void setCoragem(int coragem) {
        this.coragem = coragem;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getAmbicao() {
        return ambicao;
    }

    public void setAmbicao(int ambicao) {
        this.ambicao = ambicao;
    }

    public int getLealdade() {
        return lealdade;
    }

    public void setLealdade(int lealdade) {
        this.lealdade = lealdade;
    }

    public int getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(int estrategia) {
        this.estrategia = estrategia;
    }

    public int getCriatividade() {
        return criatividade;
    }

    public void setCriatividade(int criatividade) {
        this.criatividade = criatividade;
    }

    public void calcularCasa(){
        int grif = (2*coragem) + lealdade;
        int sons = (2*ambicao) + estrategia;
        int corv = (2*inteligencia) + criatividade;
        int lufa = ((2*lealdade) + coragem)/3;

        String[] nomesCasas = {"Grifinoria", "Sonserina", "Corvinal", "Lufa Lufa"};
        int[] valores = {grif, sons, corv, lufa};

        int indexMaior = 0, maior = 0;
        for(int i = 0; i < valores.length; i++){
            if(valores[i] > maior){
                maior = valores[i];
                indexMaior = i;
            }
        }

        this.casa = nomesCasas[indexMaior];
    }

    public String exibirInformacoes() {
        return "Aluno [nome=" + nome + ", idade=" + idade + ", casa=" + casa + ", coragem=" + coragem
                + ", inteligencia=" + inteligencia + ", ambicao=" + ambicao + ", lealdade=" + lealdade + ", estrategia="
                + estrategia + ", criatividade=" + criatividade + "]";
    }       
}


public class Questao2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Aluno[] alunos = new Aluno[10];

        for(int i = 0; i < alunos.length; i++) {
            System.out.println("\nCadastro de Aluno");
            
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Idade: ");
            int idade = sc.nextInt();

            System.out.print("Coragem (0 a 10): ");
            int coragem = sc.nextInt();

            System.out.print("Inteligencia (0 a 10): ");
            int inteligencia = sc.nextInt();

            System.out.print("Ambicao (0 a 10): ");
            int ambicao = sc.nextInt();

            System.out.print("Lealdade (0 a 10): ");
            int lealdade = sc.nextInt();

            System.out.print("Estrategia (0 a 10): ");
            int estrategia = sc.nextInt();

            System.out.print("Criatividade (0 a 10): ");
            int criatividade = sc.nextInt();
            sc.nextLine(); 

            alunos[i] = new Aluno(nome, idade, "", coragem, inteligencia, ambicao, lealdade, estrategia, criatividade);
            
            alunos[i].calcularCasa();

            System.out.println("\nAluno selecionado:");
            System.out.println(alunos[i].exibirInformacoes());
        }

        sc.close();
    }
}
