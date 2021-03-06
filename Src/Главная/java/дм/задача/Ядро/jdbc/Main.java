package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService=new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Ivan", "Ivanov", (byte) 22);
        userService.saveUser("Petr", "Petrov", (byte) 34);
        userService.saveUser("Misha", "Sidorov", (byte) 25);
        userService.saveUser("Ivan", "Golovin", (byte) 19);


        
        List<User> list = userService.getAllUsers();
        list.forEach(System.out::println);

        userService.cleanUsersTable();
        userService.dropUsersTable();

        Util.closeConnection();
    }
}
