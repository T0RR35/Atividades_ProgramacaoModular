package pratica01;

import java.util.Scanner;

class Pessoa{
    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;

    public Pessoa(String nome, String sobrenome, int idade, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public void calculaIMC(){
        this.imc = this.peso/(this.altura * this.altura);
    }

    public void informaObesidade(){
        if(this.imc < 18.5)
            System.out.println("Abaixo do peso");
        else if(this.imc < 24.9)
            System.out.println("Peso normal");
        else if(this.imc < 29.9)
            System.out.println("Sobrepeso");
        else if(this.imc < 34.9)
            System.out.println("Obesidade grau 1");
        else if(this.imc < 39.9)
            System.out.println("Obesidade grau 2");
        else 
            System.out.println("Obesidade grau 3");
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getImc() {
        return imc;
    }
    public void setImc(double imc) {
        this.imc = imc;
    }
}

public class Questao1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o nome da pessoa: ");
        String nome = sc.nextLine();
        System.out.println("Informe o sobrenome da pessoa: ");
        String sobrenome = sc.nextLine();
        System.out.println("Informe a idade da pessoa: ");
        int idade = sc.nextInt();
        System.out.println("Informe a altura da pessoa: ");
        double altura = sc.nextDouble();
        System.out.println("Informe o peso da pessoa: ");
        double peso = sc.nextDouble();
        sc.close();

        Pessoa pessoa = new Pessoa(nome, sobrenome, idade, altura, peso);
        pessoa.calculaIMC();
        System.out.println(pessoa.getImc());
        pessoa.informaObesidade();
    }
}