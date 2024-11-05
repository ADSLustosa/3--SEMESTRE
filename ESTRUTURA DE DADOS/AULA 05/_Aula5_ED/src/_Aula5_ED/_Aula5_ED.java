package _Aula5_ED;

//Classe __Aula5_ED: encarregada de executar alguns testes/funcionalidades
//com a estrutura de dados Fila circular.
//Autor 1: Ivan Carlos Alcântara de Oliveira.
//Data da Criação: 20/09/2024. 15h.
//Autor 2: João Pedro Lima Lustosa Amorim
//Data da Atualização: 27/10/2024
public class _Aula5_ED {
	// bancoDeDados(FilaCircular<Imovel> f): realizad o cadastro de 10 imóveis em
	// uma fila circular f
	// passada como parâmetro.
	public static void bancoDeDados(FilaCircular<Imovel> f) throws Exception {
		f.enqueue(new Imovel(1, 1998, 'C', 2000000.0f, 450.0f));
		f.enqueue(new Imovel(2, 2005, 'S', 10000000.0f, 700.0f));
		f.enqueue(new Imovel(3, 2008, 'A', 500000.0f, 80.0f));
		f.enqueue(new Imovel(4, 2012, 'F', 33000000.0f, 2000.0f));
		f.enqueue(new Imovel(5, 2000, 'S', 20000000.0f, 800.0f));
		f.enqueue(new Imovel(6, 2024, 'A', 400000.0f, 45.0f));
		f.enqueue(new Imovel(7, 2021, 'F', 8000000.0f, 1000.0f));
		f.enqueue(new Imovel(8, 2001, 'A', 450000.0f, 50.0f));
		f.enqueue(new Imovel(9, 1999, 'C', 500000.0f, 80.0f));
		f.enqueue(new Imovel(10, 2016, 'C', 1000000.0f, 100.0f));
	}

	// removeImovel(FilaCircular<Imovel> f, char tipo): remove da fila circular f
	// todos os imóveis de um certo "tipo", passado como parâmetro.
	// Os elementos não removidos da fila f devem continuar na sua ordem original.
	public static void removeImovel(FilaCircular<Imovel> f, char tipo) throws Exception {
		FilaCircular<Imovel> filaAux = new FilaCircular<>(f.size());
		int qtdeInicial = f.size();

		for (int i = 0; i < qtdeInicial; i++) {
			Imovel imovel = f.dequeue();
			if (imovel.getTipo() != tipo) {
				filaAux.enqueue(imovel);
			}
		}

		while (!filaAux.isEmpty()) {
			f.enqueue(filaAux.dequeue());
		}
	}

	// exibeImovelAnoArea(FilaCircular<Imovel> f, int anoDeConstrucao, float area):
	// exibe todos
	// os imóveis cujo ano de construção é maior ou igual do que o "anoDeConstrucao"
	// passado como parâmetro
	// e, além disso, tenha uma área maior do que o valor informado no parâmetro
	// "area".
	public static void exibeImovelAnoArea(FilaCircular<Imovel> f, int anoDeConstrucao, float area) throws Exception {
		int qtdeInicial = f.size();

		for (int i = 0; i < qtdeInicial; i++) {
			Imovel imovel = f.dequeue();
			if (imovel.getAnoDeConstrucao() >= anoDeConstrucao && imovel.getArea() > area) {
				System.out.println(imovel);
			}
			f.enqueue(imovel);
		}
	}

	// exibeImovelAnoPreco(FilaCircular<Imovel> f, int anoDeConstrucao, float
	// preco): exibe todos
	// os imóveis cujo ano de construção é menor do que o "anoDeConstrucao" passado
	// como parâmetro
	// e, além disso, tenha um preço menor do que o valor informado no parâmetro
	// "preco"
	public static void exibeImovelAnoPreco(FilaCircular<Imovel> f, int anoDeConstrucao, float preco) throws Exception {
		int qtdeInicial = f.size();

		for (int i = 0; i < qtdeInicial; i++) {
			Imovel imovel = f.dequeue();
			if (imovel.getAnoDeConstrucao() < anoDeConstrucao && imovel.getPreco() < preco) {
				System.out.println(imovel);
			}
			f.enqueue(imovel);
		}
	}

	// Método main que testa todas as funcionalidades desta atividade.
	public static void main(String[] args) {
		try {
			FilaCircular<Imovel> f = new FilaCircular<Imovel>();
			bancoDeDados(f);
			System.out.println(f);
			System.out.println("\nAno >= 2000 e Area > 300m2");
			exibeImovelAnoArea(f, 2000, 300.0f);
			System.out.println("\nAno < 2023 e Preço < R$ 10.000.000,00");
			exibeImovelAnoPreco(f, 2023, 10000000.0f);
			System.out.println("\nFila após a remoção dos imóveis tipo 'C' (casa):");
			removeImovel(f, 'C');
			System.out.println(f);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
