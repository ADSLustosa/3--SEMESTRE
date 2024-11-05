public class Book extends Item implements IRenewable {

    private String isbn;
    private String author;

    public Book(String isbn, String title, String author, String publisher, int year) {

        super(title, publisher, year);
        this.isbn = isbn;
        this.author = author;
    }

    @Override
    public void showDetails() {
        System.out.println("Livro '" + title + "' (ISBN: " + isbn + "), autoria de " + author + ", publicado por "
                + publisher + " em " + year + ".");
    }

    @Override
    public void renew() {
        if (isAvailable()) {
            borrow();
            System.out.println("Livro '" + title + "' renovado.");
        } else {
            System.out.println("Livro '" + title + "' não está disponível para renovação.");
        }
    }

    @Override
    public String toString() {
        return "Livro ISBN: " + isbn;
    }

    private boolean isAvailable() {

        return true;
    }

    public void borrow() {

        System.out.println("Material emprestado (Livro ISBN: " + isbn + ").");
    }

}