package com.github;

import java.sql.*;
import java.util.ResourceBundle;

public class SaveUser {
    public static void main(String[] args) {
        Connection connection = null;
        String query = "SELECT * FROM users WHERE id = ?";
        ResourceBundle resource = ResourceBundle.getBundle("db");
        String url = resource.getString("url");
        //String driver = resource.getString("driver");
        String user = resource.getString("user");
        String pass = resource.getString("password");
        try {
            connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement preparedStatement = connection.prepareStatement("query");
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " +  resultSet.getString(2)+ " " +  resultSet.getInt(3)+ " " +  resultSet.getString(4));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}