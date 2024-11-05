// Item.java
// Classe abstrata que representa um item da biblioteca.

public abstract class Item {

    protected String title;
    protected String publisher;
    protected int year;
    protected boolean isAvailable;

    public Item(String title, String publisher, int year) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Material emprestado (" + this + ").");
        } else {
            System.out.println("Material nao disponivel para emprestimo (" + this + ").");
        }
    }

    public void returnMaterial() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Material devolvido (" + this + ").");
        } else {
            System.out.println("Material nao esta sob emprestimo (" + this + ").");
        }
    }

    public abstract void showDetails();

}
