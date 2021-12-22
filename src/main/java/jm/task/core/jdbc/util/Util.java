package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.DatabaseMetaData;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private final String URL = "jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
    private final String USERNAME = "root";
    private final String PASSWORD = "Kukuepta2@!?";

    private static Connection conn;


    public Util() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

}
