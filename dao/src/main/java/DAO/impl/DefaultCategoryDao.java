package DAO.impl;

import DAO.CategoryDao;
import Model.Category;
import Model.DTO.ItemByCategory;
import Model.Item;
import com.github.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DefaultCategoryDao implements CategoryDao {


    private static volatile CategoryDao instance;

    public static CategoryDao getInstance() {
        CategoryDao localInstance = instance;
        if (localInstance == null) {
            synchronized (CategoryDao.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultCategoryDao();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Category getCategoryNameById(Long categoryId) {

        try (Connection connection = JDBCConnection.connect()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("select  category_name from category where category_id = ?;")) {
                preparedStatement.setLong(1, categoryId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    long category_id = resultSet.getLong("category_id");
                    return new Category();
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //todo why 2 try?


}
