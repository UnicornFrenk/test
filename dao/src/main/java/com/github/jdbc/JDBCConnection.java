package com.github.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCConnection {
    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResourceBundle resource = ResourceBundle.getBundle("db");
        String url = resource.getString("url");
        String user = resource.getString("user");
        String pass = resource.getString("password");

        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
