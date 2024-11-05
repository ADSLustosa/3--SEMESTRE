import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        double totalPreco = 0;
        double maiorPreco = 0;
        Book livroMaisCaro = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("books.txt")))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\\|");

                try {
                    String isbn = dados[0];
                    String titulo = dados[1];
                    String autor = dados[2];
                    String editora = dados[3];
                    int ano = Integer.parseInt(dados[4]);
                    double preco = Double.parseDouble(dados[5].replace(",", "."));

                    Book book = new Book(isbn, titulo, autor, editora, ano);
                    books.add(book);

                    totalPreco += preco;

                    if (preco > maiorPreco) {
                        maiorPreco = preco;
                        livroMaisCaro = book;
                    }
                } catch (NumberFormatException e) {
                    if (e.getMessage().contains("For input string")) {
                        System.err.println("*** Erro ao converter a nota do livro: " + linha);
                    } else {
                        System.err.println("*** Erro ao converter o ano do livro: " + linha);
                    }
                }
            }
        } catch (IOException ex) {
            System.err.println("Erro na abertura do arquivo. " + ex);
        }

        for (Book book : books) {
            book.showDetails();
        }

        if (!books.isEmpty()) {
            double mediaPreco = totalPreco / books.size();
            System.out.printf("Média de preço: R$%.2f%n", mediaPreco);
        }

        if (livroMaisCaro != null) {
            System.out.printf("'%s' é o livro mais caro (R$%.2f).%n", livroMaisCaro.getTitle(), maiorPreco);
        }
    }
}