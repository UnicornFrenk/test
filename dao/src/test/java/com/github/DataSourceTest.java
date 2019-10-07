package com.github;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataSourceTest {

    @Test
    public void getConnection() {
        DataSource.getInstance().getConnection();
    }
}