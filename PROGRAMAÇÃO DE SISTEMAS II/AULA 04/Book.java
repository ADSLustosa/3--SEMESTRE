// Book.java
// Classe concreta que representa um livro da biblioteca.
// - Herda a classe Item.
// - Implementa a interface IRenewable.

public class Book extends Item implements IRenewable {

    private String isbn;
    private String author;
    private float price;

    public Book() {
        this("", "", "", "", -1, 0.0f);
    }

    public Book(String isbn, String title, String author, String publisher, int year, float price) {
        super(title, publisher, year);
        this.isbn = isbn;
        this.author = author;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public void showDetails() {
        System.out.println("Livro '" + title + "' (ISBN: " + isbn
                + "), autoria de " + author + ", publicado por " + publisher
                + " em " + year + ", com preco de capa R$"
                + String.format("%.2f", price));
    }

    @Override
    public void renew() {
        if (isAvailable) {
            borrow();
        } else {
            System.out.println("Livro '" + title + "' renovado.");
        }
    }

    @Override
    public String toString() {
        return "Livro ISBN: " + isbn;
    }

}
