package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.saveUser("Ivan","Grozniy",(byte)56);
        userDao.saveUser("Karl","Marks",(byte)43);
        userDao.saveUser("Victor","Tsoy",(byte)30);
        userDao.saveUser("Alex","Petrovich",(byte)25);
        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
