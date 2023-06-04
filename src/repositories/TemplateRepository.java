package repositories;

import database.DB_Connection;

import java.sql.Connection;
import java.sql.SQLException;

public class TemplateRepository {
    protected Connection conn;

    public TemplateRepository() {
        try {
            this.conn = DB_Connection.getSession();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}