package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService user = new UserServiceImpl();
        user.createUsersTable();
        user.saveUser("Ivan","Grozniy",(byte)56);
        user.saveUser("Karl","Marks",(byte)43);
        user.saveUser("Victor","Tsoy",(byte)30);
        user.saveUser("Alex","Petrovich",(byte)25);
        System.out.println(user.getAllUsers());
        user.cleanUsersTable();
        user.dropUsersTable();
    }
}
