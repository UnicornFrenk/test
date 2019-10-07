package com.github;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSource {

    private static DataSource datasource;
    private ComboPooledDataSource pooledDatasource;

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private DataSource() {
        ResourceBundle resource = ResourceBundle.getBundle("db");
        String url = resource.getString("url");
        String user = resource.getString("user");
        String pass = resource.getString("password");

        pooledDatasource = new ComboPooledDataSource();
        try {
            pooledDatasource.setDriverClass(DRIVER); //loads the jdbc driver
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        pooledDatasource.setJdbcUrl(url);
        pooledDatasource.setUser(user);
        pooledDatasource.setPassword(pass);

        // the settings below are optional -- c3p0 can work with defaults
        pooledDatasource.setMinPoolSize(10);
        pooledDatasource.setAcquireIncrement(5);
        pooledDatasource.setMaxPoolSize(20);
        pooledDatasource.setMaxStatements(180);

    }

    public static synchronized DataSource getInstance() {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() {
        try {
            return pooledDatasource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
