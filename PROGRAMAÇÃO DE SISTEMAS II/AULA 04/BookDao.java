import java.sql.*;
import java.util.*;

public class BookDao {

    private final Connection connection;

    public BookDao() {
        this.connection = ConnectionFactory.getConnection();
        if (this.connection == null) {
            throw new RuntimeException("Conexão com o banco de dados falhou.");
        }
    }

    public boolean insert(Book book) {
        String sql = "INSERT INTO Books (isbn, title, author, publisher, year, price) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, book.getIsbn());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getPublisher());
            stmt.setInt(5, book.getYear());
            stmt.setFloat(6, book.getPrice());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } 
        catch (SQLException e) {
            System.err.println("Erro ao inserir livro: " + e.getMessage());
            return false;
        }
    }

    public List<Book> getAll() {
        String sql = "SELECT * FROM Books";
        List<Book> books = new ArrayList<>();

        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book(
                    rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getInt("year"), rs.getFloat("price"));
                books.add(book);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter livros: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return books;
    }
}
