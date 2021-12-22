package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoJDBCImpl uI = new UserDaoJDBCImpl();
    public void createUsersTable() {
        uI.createUsersTable();
    }

    public void dropUsersTable() {
        uI.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        uI.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        uI.removeUserById(id);
    }

    public List<User> getAllUsers() {
       return uI.getAllUsers();
    }

    public void cleanUsersTable() {
        uI.cleanUsersTable();
    }
}
