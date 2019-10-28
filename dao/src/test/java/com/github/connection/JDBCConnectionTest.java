package com.github.connection;

import com.github.jdbc.JDBCConnection;
import org.junit.jupiter.api.Test;

public class JDBCConnectionTest {

    @Test
    public void connect() {
        JDBCConnection.connect();
    }
}