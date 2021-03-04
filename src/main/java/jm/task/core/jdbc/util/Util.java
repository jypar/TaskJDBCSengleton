package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/mytestdb?autoReconnect=true&useSSL=false";
    private static final String login = "root";
    private static final String password = "zhypar_1234";
    private static Connection connection = null;
    private static  final  Util instance = new Util();
    private static StandardServiceRegistry standardServiceRegistry;
    private  static SessionFactory sessionFactory;

    private Util(){
        try { connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        Map<String,String> settings = new HashMap<>();
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.URL, url);
        settings.put(Environment.USER, login);
        settings.put(Environment.PASS, password);
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        registryBuilder.applySettings(settings);
        standardServiceRegistry = registryBuilder.build();
        MetadataSources sources = new MetadataSources(standardServiceRegistry).addAnnotatedClass(User.class);
        Metadata metadata = sources.getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public static Util getInstance(){
        return instance;
    }
    public static Connection getConnection() {
        return connection;
    }
    public static SessionFactory getSessionFactory() {
        return  sessionFactory;
    }
}
