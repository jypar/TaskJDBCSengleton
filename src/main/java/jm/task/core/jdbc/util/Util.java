package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/mytestdb?autoReconnect=true&useSSL=false";
    private static final String login = "root";
    private static final String password = "zhypar_1234";

    public Connection getConnection() {

        Connection connection = null;
        try { connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return connection;
    }
}
