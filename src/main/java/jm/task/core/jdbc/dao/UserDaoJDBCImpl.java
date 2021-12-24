package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static Util util = new Util();
    private static Connection connection = util.getConn();


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {

            connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS Users (id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(60) NOT NULL, " +
                    "lastName VARCHAR(60) NOT NULL, " +
                    "age SMALLINT NOT NULL )");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            connection.createStatement().executeUpdate("DROP TABLE IF  EXISTS  Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            String sql = "INSERT INTO Users (name, lastName, age) Values (?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, lastName);
            pst.setString(3, String.valueOf(age));
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("User с именем - " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        try {
            connection.prepareStatement("DELETE FROM Users WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
            ResultSet resultset = connection.createStatement().executeQuery("SELECT * FROM Users");

            while (resultset.next()) {
                User user = new User();
                user.setId(resultset.getLong(1));
                user.setName(resultset.getString(2));
                user.setLastName(resultset.getString(3));
                user.setAge(resultset.getByte(4));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list.toString());
        return list;
    }

    public void cleanUsersTable() {
        try {
            connection.createStatement().executeUpdate("TRUNCATE TABLE Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
