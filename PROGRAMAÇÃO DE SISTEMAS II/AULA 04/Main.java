// Main.java
// TODO: Implementar de acordo com os requisitos.

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BookDao bookDao = new BookDao();

        System.out.println("Lista de livros armazenados:");
        List<Book> books = bookDao.getAll();
        for (Book book : books) {
            book.showDetails();
        }

        System.out.println("\nCadastrar novo livro:");
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Título: ");
        String title = scanner.nextLine();
        System.out.print("Autor: ");
        String author = scanner.nextLine();
        System.out.print("Editora: ");
        String publisher = scanner.nextLine();
        System.out.print("Ano: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Preço: ");
        float price = Float.parseFloat(scanner.nextLine());

        Book newBook = new Book(isbn, title, author, publisher, year, price);
        boolean success = bookDao.insert(newBook);

        if (success) {
            System.out.println("\nLivro cadastrado com sucesso!");
        } else {
            System.out.println("\nErro ao cadastrar o livro.");
        }

        System.out.println("\nLista de livros atualizada:");
        books = bookDao.getAll();
        for (Book book : books) {
            book.showDetails();
        }

        scanner.close();
    }

}
