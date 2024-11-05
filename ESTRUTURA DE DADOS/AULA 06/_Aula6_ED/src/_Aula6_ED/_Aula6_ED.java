package _Aula6_ED;

import java.util.LinkedList;
import java.util.Scanner;

public class _Aula6_ED {

    private static Scanner ler = new Scanner(System.in);

    // bancoDeDados(LinkedList<Trabalhador> func): realiza o cadastro de 10
    // trabalhadores na lista ligada (LinkedList) func.
    public static void bancoDeDados(LinkedList<Trabalhador> func) {
        func.addLast(new Trabalhador(1, 25, 'M', 5000.0f, "Analista Jr."));
        func.addLast(new Trabalhador(2, 22, 'M', 3000.0f, "Auxiliar Administrativo."));
        func.addLast(new Trabalhador(3, 27, 'F', 5000.0f, "Analista Jr."));
        func.addLast(new Trabalhador(4, 35, 'M', 7000.0f, "Programador Sr."));
        func.addLast(new Trabalhador(5, 45, 'F', 7000.0f, "Gerente Jr."));
        func.addLast(new Trabalhador(6, 51, 'M', 7500.0f, "Gerente Pleno"));
        func.addLast(new Trabalhador(7, 60, 'M', 8000.0f, "Vice-Presidente"));
        func.addLast(new Trabalhador(8, 34, 'F', 7000.0f, "Analista Pleno"));
        func.addLast(new Trabalhador(9, 43, 'F', 8000.0f, "Programador Sr."));
        func.addLast(new Trabalhador(10, 63, 'F', 10000.0f, "Presidente"));
    }

    // demiteFuncionarios(LinkedList<Trabalhador> func): remove funcionários
    // demitidos da lista
    // de funcionários da empresa enquanto o usuário desejar.
    public static void demiteFuncionarios(LinkedList<Trabalhador> func) {
        String opcao;
        do {
            System.out.print("Deseja demitir um funcionário (S/N)? ");
            opcao = ler.nextLine();
            if (opcao.equalsIgnoreCase("S")) {
                System.out.print("Forneça o número do funcionário: ");
                int id = ler.nextInt();
                ler.nextLine(); // Limpar o buffer

                Trabalhador funcionarioARemover = null;
                for (Trabalhador t : func) {
                    if (t.getId() == id) {
                        funcionarioARemover = t;
                        break;
                    }
                }

                if (funcionarioARemover != null) {
                    func.remove(funcionarioARemover);
                    System.out.println("Funcionário " + id + " encontrado e removido com sucesso!");
                } else {
                    System.out.println("Funcionário " + id + " nao encontrado!");
                }
            }
        } while (opcao.equalsIgnoreCase("S"));
    }

    // Método auxiliar para exibir os funcionários restantes e a quantidade
    public static void exibirFuncionarios(LinkedList<Trabalhador> func) {
        System.out.println("\n[Lista]");
        for (Trabalhador t : func) {
            System.out.println(t);
        }
        System.out.println("Qtde.: " + func.size());
    }

    public static void main(String[] args) {
        LinkedList<Trabalhador> func = new LinkedList<Trabalhador>();

        bancoDeDados(func);
        exibirFuncionarios(func);

        LinkedList<Trabalhador> contratados = new LinkedList<Trabalhador>();

        contratados.addLast(new Trabalhador(11, 23, 'M', 3900.0f, "Programador Jr."));
        contratados.addLast(new Trabalhador(12, 29, 'F', 4500.0f, "Secretária Bilíngue"));
        contratados.addLast(new Trabalhador(13, 35, 'M', 6000.0f, "Programador Pleno"));
        contratados.addLast(new Trabalhador(14, 53, 'M', 5000.0f, "Programador Jr."));
        contratados.addLast(new Trabalhador(15, 63, 'F', 8000.0f, "Analista Sr."));
        contratados.addLast(new Trabalhador(16, 56, 'M', 9000.0f, "Analista Sr."));

        func.addAll(contratados);
        exibirFuncionarios(func);

        demiteFuncionarios(func);
        exibirFuncionarios(func);
    }
}

// Classe Trabalhador (para completar o código)
class Trabalhador {
    private int id;
    private int idade;
    private char sexo;
    private float salario;
    private String cargo;

    public Trabalhador(int id, int idade, char sexo, float salario, String cargo) {
        this.id = id;
        this.idade = idade;
        this.sexo = sexo;
        this.salario = salario;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "[Trabalhador] Id: " + id + ", sexo: " + sexo + ", idade: " + idade +
                ", cargo: " + cargo + ", salário: " + salario;
    }
}
