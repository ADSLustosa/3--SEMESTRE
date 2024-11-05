class Aluno {
        // Declarando variáveis
        private String nome;
        private String curso;
        private String nivelCurso;
        private boolean bolsista;
        private double mensalidade;
        private double desconto;
    
        // Método Construtor
        public Aluno(String nome, 
                    String curso, 
                    String nivelCurso, 
                    int matricula, 
                    boolean bolsista, 
                    double mensalidade, 
                    double desconto) {
            this.nome = nome;
            this.curso = curso;
            this.nivelCurso = nivelCurso;
            this.bolsista = bolsista;
            this.mensalidade = mensalidade;
            this.desconto = desconto;
        }
    
        // Calcular a mensalidade com desconto
        private double calcularDescontoMensalidade() {
            return mensalidade * (1 - desconto / 100);
        }
    
        // Obtém os dados do aluno
        public String obterDadosAluno() {
            StringBuilder dados = new StringBuilder();
            dados.append("Aluno: ").append(nome).append("\n");
            dados.append("Curso: ").append(nivelCurso).append(" em ").append(curso).append("\n");
    
            if (bolsista) {
                dados.append("Bolsista com desconto de: ").append(desconto).append("%\n");
                dados.append("Mensalidade: R$ ").append(String.format("%.2f", calcularDescontoMensalidade()));
            } else {
                dados.append("Mensalidade: R$ ").append(String.format("%.2f", mensalidade));
            }
    
            return dados.toString();
        }
    }
    
    class Teste {
        public static void main(String[] args) {
            // Variáveis descritivas
            Aluno graduado = new Aluno("Martin Fowler", 
                                    "Análise e Desenvolvimento de Sistemas", 
                                    "Graduação", 
                                    11223344, 
                                    true, 
                                    920.50, 
                                    20.5);
    
            Aluno mestrado = new Aluno("Kent Beck", 
                                    "Computação Aplicada", 
                                    "Mestrado", 
                                    22334455, 
                                    false, 
                                    2150.45, 
                                    0);
    
            // Leitura e impressão
            System.out.println(graduado.obterDadosAluno());
            System.out.println();
            System.out.println(mestrado.obterDadosAluno());
        }
    }

