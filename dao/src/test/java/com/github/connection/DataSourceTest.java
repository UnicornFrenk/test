package com.github.connection;

import com.github.jdbc.DataSource;
import org.junit.jupiter.api.Test;

public class DataSourceTest {

    @Test
    public void getConnection() {
        DataSource.getInstance().getConnection();
    }
}