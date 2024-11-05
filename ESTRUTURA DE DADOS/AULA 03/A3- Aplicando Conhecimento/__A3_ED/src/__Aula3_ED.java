import java.util.Scanner;

// Classe __Aula3_ED: encarregada de executar algumas funcionalidades com objetos do tipo Candidato a um concurso musical armazenados em um vetor.
//	Autor Professor: Ivan Carlos Alcântara de Oliveira.
//	Data da Criação: 31/08/2024. 15h.
//	Autor Aluno: <REBECA ABREU DE ALMEIDA- RA: 10233223>
//Data da Atualização: <24/09/2024>
public class __Aula3_ED {
	// Objeto de leitura
    private Scanner ler = new Scanner(System.in); 
	// constante com o total de candidatos
	public static final int MAX_CANDIDATOS = 15;
	// main: ponto de entrada do programa
	public static void main(String[] args) {
		// Cria objeto da Classe com a 
		// execução das funcionalidades solicitadas
		new __Aula3_ED();  
	}
	// Construtor da classe encarregada de realizar a execução
	// das funcionalidades solicitadas
	public __Aula3_ED() {
		// Vetor de Candidatos
		Candidato candidatos[];
    	// Cria vetor de objetos do tipo Candidato para 
	    // uso nos métodos de ordenação e pesquisa
		candidatos = new Candidato[MAX_CANDIDATOS];
		
    	// Cria lista de candidatos
		criarCadastroCandidatos(candidatos);
	    // Mostra todos os candidatos cadastrados na ordem do cadastro
		mostrarTodosOsCandidatos(candidatos);

	    // Procura um candidato pelo nome em um vetor não ordenado
		System.out.println("Forneça o nome do candidato: ");
		String nomeCandidato = ler.nextLine();
		Candidato cand = pesquisaSequencial(nomeCandidato, candidatos);
		if (cand != null) {
			System.out.println("Dados Candidato: " + cand.toString());
		}
		else {
		System.out.println("Candidato Inexistente!");
		
	}
	
	    // Ordena o vetor de candidatos pelo número do candidato
		selectionSort(candidatos);
	    // Mostra os candidatos ordenados por número do candidato
		mostrarTodosOsCandidatos(candidatos);
		
	    // Procura um candidato no vetor ordenado pelo número do candidato 
		System.out.println("Forneça um número de candidato:");
		String nroCandidato = ler.nextLine();
		cand = pesquisaBinaria(Integer.parseInt(nroCandidato), candidatos);
		if (cand != null) {
			System.out.println("Dados Candidato: " + cand.toString());
		} 
		else {
		System.out.println("Candidato Inexistente!");
		}
		
	    // Ordena o vetor de candidatos pelo nome do candidato
		bubbleSort(candidatos);
	    // Mostra os candidatos ordenados por nome
		mostrarTodosOsCandidatos(candidatos);

	    // Ordena o vetor de candidatos pela idade do candidato
		insertionSort(candidatos);
	    // Mostra os candidatos ordenados por idade
		mostrarTodosOsCandidatos(candidatos);

	}
	
    // Método encarregado de criar objetos da classe Candidato
    // e armazenar em um vetor.
    // Este método foi criado para evitar a necessidade de 
    // fazer a leitura de dados de Candidato na fase de testes dos outros ´
    // métodos a serem modificados.  
	// Você deve inserir mais 5 candidatos na base
    public void criarCadastroCandidatos(Candidato[] candidatos) {	
		candidatos[0] = new Candidato(1111, "111.111.111-11", "Leonardo", 18, 'M', "rock");
		candidatos[1] = new Candidato(8888, "888.888.888-88", "Luiza", 21, 'F', "romantica");
		candidatos[2] = new Candidato(7777, "777.777.777-77", "Pedro", 22, 'M', "rock");
		candidatos[3] = new Candidato(6666, "666.666.666-66", "Ana Lopes", 54, 'F', "sertanejo");
		candidatos[4] = new Candidato(3333, "333.333.333-33", "Mariana", 25, 'F', "sertanejo");
		candidatos[5] = new Candidato(4444, "444.444.444-44", "Amilton", 35, 'M', "rock");
		candidatos[6] = new Candidato(2222, "222.222.222-22", "Juliano", 19, 'M', "forró");  	
		candidatos[7] = new Candidato(5555, "555.555.555-55", "Luciano", 52, 'M', "forró");
		candidatos[8] = new Candidato(1010, "101.101.101-10", "Christiane", 35, 'F', "rock");    	
		candidatos[9] = new Candidato(9999, "999.999.999-99", "Luis Alberto C.", 18, 'M', "rap");
		candidatos[10] = new Candidato(1313, "121.212.121-21", "João", 28, 'M', "rock");
		candidatos[11] = new Candidato(1414, "131.313.131-31", "Paulo", 18, 'M', "rap");
		candidatos[12] = new Candidato(1515, "141.414.141-41", "Larissa", 26, 'F', "forró");
		candidatos[13] = new Candidato(1616, "151.515.151-51", "Maria", 29, 'F', "romantica");
		candidatos[14] = new Candidato(1717, "161.161.161-61", "Giovana.", 24, 'f', "rap");
    	// Criar a partir daqui mais 5 objetos da classe candidato
		
    }
    
	// Método que apresenta todos os dados dos candidatos cadastrados.
	// Se houver candidatos exibe a mensagem:
	//    "Candidatos cadastrados:", seguido dos seus dados um por linha.
	// Caso não haja Candidatos cadastrados mostra a mensagem: "Não há candidatos cadastrados!"
	public void mostrarTodosOsCandidatos(Candidato[] cand) {
		String cad = "";
        for (Candidato cand1 : cand) {
            if (cand1 != null) {
                // Verifica se o candidato não é nulo
                cad += cand1.toString() + "\n";
            }
        }
		if (!cad.isEmpty()) {
			System.out.println("Candidatos cadastrados:\n" + cad);
		} else {
			System.out.println("Não há Candidatos cadastrados!");
		}
	}

    // Método encarregado de pesquisar um candidato 
    // armazenado em um vetor (ordenado ou não)
    // tendo como chave o nome do candidato.	
	public Candidato pesquisaSequencial(String nomeCandidato, Candidato[] cand) {
		for (Candidato candidato : cand) {
			if (candidato != null && candidato.getNome().equalsIgnoreCase(nomeCandidato)) {
				return candidato;
			}
		}
		return null;
	}
    
    // Método encarregado de pesquisar um candidato 
    // armazenado em um vetor ordenado
    // tendo como chave o número do candidato.
    public Candidato pesquisaBinaria(int chave, Candidato[] cand) {
		int inicio = 0;
		int fim = cand.length - 1;

		while (inicio <= fim) {
			int meio = (inicio + fim) / 2;
			if (cand[meio].getNumero_candidato() == chave) {
				return cand[meio];
			}
			else if (cand[meio].getNumero_candidato() < chave){
				inicio = meio + 1;
			}
			else {
				fim = meio -1;
			}
		}
		return null;
    }

    // Método encarregado de ordenar os Candidatos 
    // armazenados em um vetor pelo número do candidato.
public void selectionSort(Candidato[] cand) {
    for (int i = 0; i < cand.length - 1; i++) {
        if (cand[i] == null) continue;  // Pula elementos nulos

        int minIndex = i;
        for (int j = i + 1; j < cand.length; j++) {
            if (cand[j] == null) continue;  // Pula elementos nulos
            
            // Verifica se o candidato atual tem um número menor
            if (cand[j].getNumero_candidato() < cand[minIndex].getNumero_candidato()) {
                minIndex = j;
            }
        }

        // Troca o candidato atual com o menor encontrado, se necessário
        if (minIndex != i) {
            Candidato temp = cand[i];
            cand[i] = cand[minIndex];
            cand[minIndex] = temp;
        }
    }
}


    // Método encarregado de ordenar os Candidatos 
    // armazenados em um vetor pela idade do candidato.
	public void insertionSort(Candidato[] cand) {
		int n = cand.length;
		for (int i = 1; i < n; i++) {
			// Verifica se o candidato atual não é nulo
			if (cand[i] != null) {
				Candidato atual = cand[i];
				int j = i - 1;
	
				// Move os elementos do vetor que são maiores que o atual
				// para uma posição à frente do local atual, verificando se não são nulos
				while (j >= 0 && cand[j] != null && cand[j].getIdade() > atual.getIdade()) {
					cand[j + 1] = cand[j];
					j--;
				}
				cand[j + 1] = atual;
			}
		}
	}
	
	
    
    // Método encarregado de ordenar os Candidatos 
    // armazenados em um vetor pelo nome do candidato.
	public void bubbleSort(Candidato[] cand) {
		int n = cand.length;
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				// Verifica se ambos os candidatos não são nulos antes de comparar
				if (cand[j] != null && cand[j + 1] != null) {
					// Compara os nomes dos candidatos
					if (cand[j].getNome().compareTo(cand[j + 1].getNome()) > 0) {
						// Troca os candidatos
						Candidato temp = cand[j];
						cand[j] = cand[j + 1];
						cand[j + 1] = temp;
						swapped = true;
					}
				}
			}
			// Se não houve troca, significa que a lista já está ordenada
			if (!swapped) {
				break;
			}
		}
	}
}
