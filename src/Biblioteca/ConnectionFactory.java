package Biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/biblioteca", "postgres", "123456");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
