package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/mytestdb?autoReconnect=true&useSSL=false";
    private static final String login = "root";
    private static final String password = "zhypar_1234";
    private static Connection connection = null;
    private static  final  Util instance = new Util();

    private Util(){
        try { connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Util getInstance(){
        return instance;
    }
    public static Connection getConnection() {
        return connection;
    }
}
