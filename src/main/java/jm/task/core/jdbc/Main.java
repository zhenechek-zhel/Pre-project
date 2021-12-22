package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    private static UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

    public static void main(String[] args) {
        Util util = new Util();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Evgen", "Zhel", (byte) 54);
        userDaoJDBC.saveUser("Liza", "Barr", (byte) 54);
        userDaoJDBC.saveUser("Misha", "Dor", (byte) 54);
        userDaoJDBC.saveUser("Kris", "Gor", (byte) 54);
        userDaoJDBC.getAllUsers();
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();
    }
}
