// Classe relativa a estrutura de dados Pilha 
// sequencial capaz de armazenar dados inteiros
// Autor1: Ivan Carlos Alcântara de Oliveira.
// Data da Criação: 07/09/2024. 15h.
// Autor2: Rebeca Abreu de Almeida
// Data da Atualização: 01/10/2024 12:45
public class Pilha {
	private static final int TAM_DEFAULT = 100;
	private int topo; // ponteiro do topo da pilha
	private int e[]; // array de inteiros correspondente a Pilha
	// Construtor 1
	// Cria uma Pilha com o tamanho passado como parâmetro

	public Pilha(int tamanho) {
		this.e = new int[tamanho];
		this.topo = -1;
	}

	// Construtor 2
	// Cria uma Pilha com o tamanho padrão "TAM_DEFAULT"
	public Pilha() {
		this(TAM_DEFAULT);
	}

	// Verifica se a Pilha
	// está vazia
	public boolean isEmpty() {
		return this.topo == -1;
	}

	// Verifica se a Pilha está
	// cheia
	public boolean isFull() {
		return this.topo == this.e.length - 1;
	}

	// Limpa a Pilha, deixando-a vazia
	public void clear() throws Exception {
		while (!isEmpty()) {
			pop();
		}
	}

	// insere um elemento "e"
	// no topo da Pilha
	public void push(int e) throws Exception {
		if (!this.isFull())
			this.e[++this.topo] = e;
		else
			throw new Exception("Stack Overflow");
	}

	// remove e retorna o elemento que está no
	// topo da Pilha
	public int pop() throws Exception {
		if (!this.isEmpty())
			return this.e[this.topo--];
		else {
			throw new Exception("Stack Underflow");
		}
	}

	// Retorna o elemento que está
	// no topo da Pilha
	public int peek() throws Exception {
		if (!this.isEmpty())
			return this.e[this.topo];
		else {
			throw new Exception("Stack Underflow");
		}
	}

	// obtém o total de elementos
	// armazenados na Pilha
	public int size() {
		return topo + 1;
	}

	// retorna a distância da primeira ocorrência do inteiro "e" informado
	// como parâmetro em relação ao topo da Pilha ou retorna -1 se o
	// inteiro "e" não existir na Pilha.
	public int search(int e) {
		for (int i = topo; i >= 0; i--) {
			if (this.e[i] == e) {
				return topo - i;
			}
		}
		return -1;
	}

	// realiza a inversão do conteúdo da Pilha
	// o elemento do topo deve ficar na base e
	// o da base deve se tornar o do topo
	public void inverts() throws Exception {
		int[] temp = new int[this.size()];
		int i = 0;

		// Desempilha todos os elementos em um array temporário
		while (!this.isEmpty()) {
			temp[i++] = this.pop();
		}

		// Reempilha os elementos em ordem inversa
		for (int j = 0; j < temp.length; j++) {
			this.push(temp[j]);
		}
	}

	// remove e retorna os elementos ímpares (type = 1) ou
	// pares (type = 2) da Pilha, mantendo os seus outros elementos
	// na ordem original. Caso não seja fornecido o
	// type = 1 ou 2, retorna uma exceção com a mensagem
	// "The parameter to the popEvenOdd method must be 1 for odd and 2 for even"
	public void popEvenOdd(int type) throws Exception {
		if (type != 1 && type != 2) {
			throw new Exception("The parameter to the popEvenOdd method must be 1 for odd and 2 for even");
		}

		Pilha temp = new Pilha(this.size());

		// Remove os elementos e filtra pares ou ímpares
		while (!this.isEmpty()) {
			int elem = this.pop();
			if (type == 1 && elem % 2 == 0) {
				temp.push(elem);
			} else if (type == 2 && elem % 2 != 0) {
				temp.push(elem);
			}
		}

		// Reempilha os elementos que sobraram
		while (!temp.isEmpty()) {
			this.push(temp.pop());
		}
	}

	// remove os elementos da Pilha que
	// são múltiplos de um certo número (nro)
	// passado como parâmetro, deixando os
	// outros na ordem original.
	public void popMultiple(int nro) throws Exception {
		Pilha temp = new Pilha(this.size());

		// Remove os elementos e filtra os múltiplos de 'nro'
		while (!this.isEmpty()) {
			int elem = this.pop();
			if (elem % nro != 0) {
				temp.push(elem);
			}
		}

		// Reempilha os elementos que sobraram
		while (!temp.isEmpty()) {
			this.push(temp.pop());
		}
	}

	// Sobrescrita/sobreposição (override) do método toString(), que veio da
	// superclasse Object.
	// O retorno do método toString() é a representação de um objeto em formato
	// string, e toString()
	// geralmente é executado (de forma implícita) quando passamos um objeto ao
	// System.out.print*().
	//
	// Experimente incluir o seguinte código na main() e veja a saída:
	// Pilha p = new Pilha();
	// System.out.println(p);
	//
	// Depois, remova/comente o método toString() abaixo e rode o código acima
	// novamente.
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("  [Stack] top: ")
				.append(this.topo)
				.append(", capacity: ")
				.append(e.length)
				.append(", size: ")
				.append(size());
		if (this.topo != -1) {
			sb.append(", Top value: ")
					.append(this.e[this.topo]);
		} else
			sb.append("""
					, \r
					Top value: EMPTY STACK""");

		sb.append("\n  Stack Contents: [ ");

		for (int i = this.topo; i >= 0; --i)
			if (i != 0)
				sb.append(e[i]).append(", ");
			else
				sb.append(e[i]);
		sb.append(" ]");
		return sb.toString();
	}

}
