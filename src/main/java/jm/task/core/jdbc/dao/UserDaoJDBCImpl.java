package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    Util util = new Util();
    Connection connection = util.getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF not EXISTS users (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  `lastname` VARCHAR(45) NULL,\n" +
                    "  `age` INT NULL,\n" +
                    "  PRIMARY KEY (`id`));");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {

        try {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS users");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into users(name,lastname,age) values(?,?,?)");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3,(byte)age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем – "+name+" добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("delete from users where id = id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while(resultSet.next()){
                User user = new User(resultSet.getString(2),resultSet.getString(3),resultSet.getByte(4));
                user.setId(resultSet.getLong(1));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {

        try {
            Statement statement = connection.createStatement();
            statement.execute("delete from users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
