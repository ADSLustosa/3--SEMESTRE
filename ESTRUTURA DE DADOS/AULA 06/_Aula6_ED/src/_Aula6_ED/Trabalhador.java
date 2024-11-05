package _Aula6_ED;

// Classe Trabalhador com atributos, construtor, getters, setters e toString.
// Autor: Ivan Carlos Alcântara de Oliveira
// Data de Criação: 10/10/2024

public class Trabalhador {
    private int id;
    private int idade;
    private char sexo;
    private float salario;
    private String cargo;

    // Construtor
    public Trabalhador(int id, int idade, char sexo, float salario, String cargo) { 
        this.id = id; 
        this.idade = idade;
        this.sexo = sexo;
        this.salario = salario; 
        this.cargo = cargo;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getIdade() {
        return idade;
    }

    public char getSexo() {
        return sexo;
    }

    public float getSalario() {
        return salario;
    }

    public String getCargo() {
        return cargo;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Método toString para exibir os dados do trabalhador em formato legível
    @Override
    public String toString() {
        return "[Trabalhador] Id: " + id +
                ", Sexo: " + sexo +
                ", Idade: " + idade +
                ", Cargo: " + cargo +
                ", Salário: " + String.format("%.2f", salario);
    }
}
