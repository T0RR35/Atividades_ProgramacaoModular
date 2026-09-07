package pratica01;

import java.text.Normalizer;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Aluno {
    private String nome;
    private LocalDate dataNascimento;
    private String codigoMatricula;
    private int idade;
    private String casa;
    private int coragem;
    private int inteligencia;
    private int ambicao;
    private int lealdade;
    private int estrategia;
    private int criatividade;

    public Aluno(String nome, LocalDate dataNascimento, String casa, int coragem, int inteligencia,
            int ambicao, int lealdade, int estrategia, int criatividade) {
        this.nome = capitalizarNome(nome);
        this.dataNascimento = dataNascimento;
        this.casa = casa;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.estrategia = estrategia;
        this.criatividade = criatividade;
        calcularIdade();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = capitalizarNome(nome);
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        calcularIdade();
    }

    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(String codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
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

    private static String capitalizarNome(String textoOriginal) {
        if (textoOriginal == null || textoOriginal.isBlank()) {
            return "";
        }
        String[] palavras = textoOriginal.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String palavra : palavras) {
            sb.append(Character.toUpperCase(palavra.charAt(0)))
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return sb.toString().trim();
    }

    private static String normalizarTexto(String texto) {
        if (texto == null)
            return "";
        String semAcento = Normalizer.normalize(texto.trim(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        return semAcento.toLowerCase();
    }

    public void calcularIdade() {
        if (dataNascimento != null) {
            this.idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        }
    }

    public boolean verificarMaioridadeMagica() {
        return this.idade >= 17;
    }

    public String formatarCasa() {
        return this.casa == null ? "" : this.casa.toUpperCase();
    }

    public String gerarNomeUsuario() {
        String[] partes = nome.trim().split("\\s+");
        if (partes.length == 0 || partes[0].isEmpty())
            return "";
        String primeiraLetra = partes[0].substring(0, 1).toLowerCase();
        if (partes.length == 1) {
            return primeiraLetra;
        }
        StringBuilder sobrenome = new StringBuilder();
        for (int i = 1; i < partes.length; i++) {
            sobrenome.append(partes[i].toLowerCase());
        }
        return primeiraLetra + sobrenome;
    }

    public String gerarCodigoMatricula(int posicaoCadastro) {
        String[] partes = nome.trim().split("\\s+");
        StringBuilder iniciais = new StringBuilder();
        for (String parte : partes) {
            if (!parte.isEmpty()) {
                iniciais.append(Character.toUpperCase(parte.charAt(0)));
            }
        }
        int anoAtual = LocalDate.now().getYear();
        String posicaoFormatada = String.format("%02d", posicaoCadastro);
        this.codigoMatricula = iniciais + "-" + anoAtual + "-" + posicaoFormatada;
        return this.codigoMatricula;
    }

    public boolean verificarCasa(String casaInformada) {
        return normalizarTexto(this.casa).equals(normalizarTexto(casaInformada));
    }

    public boolean verificarPresencaPalavra(String palavra) {
        String[] partes = nome.trim().split("\\s+");
        if (partes.length < 2)
            return false;
        StringBuilder sobrenome = new StringBuilder();
        for (int i = 1; i < partes.length; i++) {
            sobrenome.append(partes[i]).append(" ");
        }
        return normalizarTexto(sobrenome.toString()).contains(normalizarTexto(palavra));
    }

    public void calcularCasa() {
        int grif = (2 * coragem) + lealdade;
        int sons = (2 * ambicao) + estrategia;
        int corv = (2 * inteligencia) + criatividade;
        int lufa = ((2 * lealdade) + coragem) / 3;

        String[] nomesCasas = { "Grifinória", "Sonserina", "Corvinal", "Lufa-Lufa" };
        int[] valores = { grif, sons, corv, lufa };

        int indexMaior = 0, maior = valores[0];
        for (int i = 1; i < valores.length; i++) {
            if (valores[i] > maior) {
                maior = valores[i];
                indexMaior = i;
            }
        }
        this.casa = nomesCasas[indexMaior];
    }

    public String exibirInformacoes() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Matricula: " + codigoMatricula
                + " | Nome: " + nome
                + " | Nascimento: " + (dataNascimento != null ? dataNascimento.format(formatter) : "N/A")
                + " | Idade: " + idade
                + " | Maior de idade (magica): " + (verificarMaioridadeMagica() ? "Sim" : "Nao")
                + " | Casa: " + formatarCasa()
                + " | Usuario: " + gerarNomeUsuario()
                + " | Coragem: " + coragem
                + " | Inteligencia: " + inteligencia
                + " | Ambicao: " + ambicao
                + " | Lealdade: " + lealdade
                + " | Estrategia: " + estrategia
                + " | Criatividade: " + criatividade;
    }
}

public class Questao2 {

    private static final int MAX_ALUNOS = 10;
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Aluno> alunos = new ArrayList<>();

    private static void exibirMenu() {
        System.out.println("\n===== SISTEMA DE CADASTRO - CHAPEU SELETOR =====");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Listar todos os alunos");
        System.out.println("3 - Exibir alunos de uma casa escolhida (com total)");
        System.out.println("4 - Exibir alunos agrupados por casa");
        System.out.println("5 - Exibir alunos maiores de idade");
        System.out.println("6 - Exibir alunos menores de idade");
        System.out.println("7 - Buscar alunos por sobrenome");
        System.out.println("8 - Encerrar");
    }

    private static void cadastrarAluno() {
        if (alunos.size() >= MAX_ALUNOS) {
            System.out.println("Limite maximo de alunos ja foi atingido!");
            return;
        }

        System.out.println("\nCadastro de Aluno (" + (alunos.size() + 1) + ")");

        System.out.print("Nome completo: ");
        String nome = sc.nextLine();

        LocalDate dataNascimento = lerDataNascimento();

        int coragem = lerNota("Coragem (0 a 10): ");
        int inteligencia = lerNota("Inteligencia (0 a 10): ");
        int ambicao = lerNota("Ambicao (0 a 10): ");
        int lealdade = lerNota("Lealdade (0 a 10): ");
        int estrategia = lerNota("Estrategia (0 a 10): ");
        int criatividade = lerNota("Criatividade (0 a 10): ");

        Aluno aluno = new Aluno(nome, dataNascimento, "", coragem, inteligencia, ambicao,
                lealdade, estrategia, criatividade);

        aluno.calcularCasa();
        aluno.gerarCodigoMatricula(alunos.size() + 1);

        alunos.add(aluno);

        System.out.println("\nAluno cadastrado com sucesso!");
        System.out.println(aluno.exibirInformacoes());

        if (alunos.size() < MAX_ALUNOS) {
            System.out.print("\nDeseja cadastrar outro aluno? (s/n): ");
            String resposta = sc.nextLine().trim().toLowerCase();
            if (resposta.equals("s")) {
                cadastrarAluno();
            }
        } else {
            System.out.println("Limite maximo de alunos atingido.");
        }
    }

    private static LocalDate lerDataNascimento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = null;
        while (data == null) {
            System.out.print("Data de nascimento (dd/mm/aaaa): ");
            String texto = sc.nextLine().trim();
            try {
                LocalDate dataDigitada = LocalDate.parse(texto, formatter);
                if (dataDigitada.isAfter(LocalDate.now())) {
                    System.out.println("Data invalida: nao pode ser uma data futura.");
                    continue;
                }
                if (dataDigitada.isBefore(LocalDate.now().minusYears(120))) {
                    System.out.println("Data invalida: idade nao pode ser maior que 120 anos.");
                    continue;
                }
                data = dataDigitada;
            } catch (DateTimeParseException e) {
                System.out.println("Formato invalido! Use dd/mm/aaaa (ex: 31/07/2009).");
            }
        }
        return data;
    }

    private static int lerNota(String mensagem) {
        int nota = -1;
        while (nota < 0 || nota > 10) {
            System.out.print(mensagem);
            try {
                nota = Integer.parseInt(sc.nextLine().trim());
                if (nota < 0 || nota > 10) {
                    System.out.println("Valor deve estar entre 0 e 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero valido.");
                nota = -1;
            }
        }
        return nota;
    }

    private static int lerInteiro() {
        while (true) {
            System.out.print("Escolha uma opcao: ");
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero valido.");
            }
        }
    }

    private static void listarTodos() {
        if (alunos.isEmpty()) {
            System.out.println("\nNenhum aluno cadastrado ainda.");
            return;
        }
        System.out.println("\n--- Lista de todos os alunos (" + alunos.size() + ") ---");
        for (Aluno aluno : alunos) {
            System.out.println(aluno.exibirInformacoes());
        }
    }

    private static void exibirPorCasaEscolhida() {
        if (alunos.isEmpty()) {
            System.out.println("\nNenhum aluno cadastrado ainda.");
            return;
        }
        System.out.print("\nDigite o nome da casa (Grifinoria, Sonserina, Corvinal, Lufa-Lufa): ");
        String casaEscolhida = sc.nextLine();

        int total = 0;
        System.out.println("\n--- Alunos da casa " + casaEscolhida.toUpperCase() + " ---");
        for (Aluno aluno : alunos) {
            if (aluno.verificarCasa(casaEscolhida)) {
                System.out.println(aluno.exibirInformacoes());
                total++;
            }
        }
        System.out.println("\nTotal de alunos na casa: " + total);
    }

    private static void exibirAgrupadoPorCasa() {
        if (alunos.isEmpty()) {
            System.out.println("\nNenhum aluno cadastrado ainda.");
            return;
        }
        String[] casas = { "Grifinória", "Sonserina", "Corvinal", "Lufa-Lufa" };
        for (String casa : casas) {
            System.out.println("\n--- " + casa.toUpperCase() + " ---");
            int total = 0;
            for (Aluno aluno : alunos) {
                if (aluno.verificarCasa(casa)) {
                    System.out.println(aluno.exibirInformacoes());
                    total++;
                }
            }
            if (total == 0) {
                System.out.println("(nenhum aluno nesta casa)");
            }
        }
    }

    private static void exibirMaioresDeIdade() {
        System.out.println("\n--- Alunos maiores de idade (magica, 17+) ---");
        boolean encontrou = false;
        for (Aluno aluno : alunos) {
            if (aluno.verificarMaioridadeMagica()) {
                System.out.println(aluno.exibirInformacoes());
                encontrou = true;
            }
        }
        if (!encontrou)
            System.out.println("Nenhum aluno maior de idade encontrado.");
    }

    private static void exibirMenoresDeIdade() {
        System.out.println("\n--- Alunos menores de idade (magica, abaixo de 17) ---");
        boolean encontrou = false;
        for (Aluno aluno : alunos) {
            if (!aluno.verificarMaioridadeMagica()) {
                System.out.println(aluno.exibirInformacoes());
                encontrou = true;
            }
        }
        if (!encontrou)
            System.out.println("Nenhum aluno menor de idade encontrado.");
    }

    private static void buscarPorSobrenome() {
        if (alunos.isEmpty()) {
            System.out.println("\nNenhum aluno cadastrado ainda.");
            return;
        }
        System.out.print("\nDigite o sobrenome (ou parte dele) para buscar: ");
        String sobrenome = sc.nextLine();

        boolean encontrou = false;
        System.out.println("\n--- Resultado da busca por \"" + sobrenome + "\" ---");
        for (Aluno aluno : alunos) {
            if (aluno.verificarPresencaPalavra(sobrenome)) {
                System.out.println(aluno.exibirInformacoes());
                encontrou = true;
            }
        }
        if (!encontrou)
            System.out.println("Nenhum aluno encontrado com esse sobrenome.");
    }

        public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro();
            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> listarTodos();
                case 3 -> exibirPorCasaEscolhida();
                case 4 -> exibirAgrupadoPorCasa();
                case 5 -> exibirMaioresDeIdade();
                case 6 -> exibirMenoresDeIdade();
                case 7 -> buscarPorSobrenome();
                case 8 -> System.out.println("Encerrando o sistema");
                default -> System.out.println("Opcao invalida!");
            }
        } while (opcao != 8);

        sc.close();
    }
}