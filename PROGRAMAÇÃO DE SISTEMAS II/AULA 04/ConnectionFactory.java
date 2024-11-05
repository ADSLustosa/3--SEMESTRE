import java.sql.*;
public class ConnectionFactory {

    private static final String URL ="jdbc:derby://localhost:1527/LibraryDB";
    private static final String USER = "app";
    private static final String PASSWORD = "app";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erro ao estabelecer conexão com o banco de dados: " + e.getMessage());
            return null;
        }
    }
}