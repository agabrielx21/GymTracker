package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USERNAME = "sys as sysdba";
    private static final String PASSWORD = "sysdba";
    private static Connection connection;

    private static volatile DB_Connection init;

    private DB_Connection() {
        System.out.println("Conexiunea la baza de date s-a realizat cu succes!");
    }

    public static Connection getSession() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }

}