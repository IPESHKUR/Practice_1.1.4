package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static Connection connection;
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mydb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    private Util(){}

    public static Connection getConnection() {

        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connecting is good");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connecting is not good");
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection close");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
