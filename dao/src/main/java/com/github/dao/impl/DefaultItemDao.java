package com.github.dao.impl;

import com.github.dao.ItemDao;
import com.github.model.Item;
import com.github.jdbc.JDBCConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultItemDao implements ItemDao {

    private static final Logger log = LoggerFactory.getLogger(DefaultItemDao.class);

    private static class SingletonHolder {
        static final ItemDao HOLDER_INSTANCE = new DefaultItemDao();
    }

    public static ItemDao getInstance() {
        return DefaultItemDao.SingletonHolder.HOLDER_INSTANCE;
    }

    //private static volatile ItemDao instance;

//    public static ItemDao getInstance() {
//        ItemDao localInstance = instance;
//        if (localInstance == null) {
//            synchronized (ItemDao.class) {
//                localInstance = instance;
//                if (localInstance == null) {
//                    instance = localInstance = new DefaultItemDao();
//                }
//            }
//        }
//        return localInstance;
//    }


    private static final String createItem = "insert into item (item_name, item_description, item_quantity,item_category_id,price_for_one) values (?,?,?,?,?)";


    @Override
    public Item createItem(Item item) {
        try (Connection connection = JDBCConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(createItem, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, item.getItemName());
            preparedStatement.setString(2, item.getItemDescription());
            preparedStatement.setLong(3, item.getItemQuantity());
            preparedStatement.setInt(4, item.getItemCategoryId());
            preparedStatement.setLong(5, item.getPriceForOne());
            boolean isSuccess = preparedStatement.executeUpdate() > 0;
            if (isSuccess) {
                long id;
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    generatedKeys.next();
                    id = generatedKeys.getLong(1);
                }
                item.setId(id);
                return item;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String readItemByItemName = "select * from item where item_name = ?";

    @Override
    public Item readItem(String itemName) {
        try (Connection connection = JDBCConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(readItemByItemName)) {
            preparedStatement.setString(1, itemName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    long id = resultSet.getLong("item_id");
                    String description = resultSet.getString("item_description");
                    Long quantity = resultSet.getLong("item_quantity");
                    int categoryId = resultSet.getInt("item_category_id");
                    Long price = resultSet.getLong("price_for_one");
                    return new Item(id, itemName, description, quantity, categoryId, price);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String updateItem = "update item set item_category_id = ? where item_name = ?";


    @Override
    public int updateItem(String itemName, int category) {
        try (Connection connection = JDBCConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(updateItem)) {
            preparedStatement.setInt(1, category);
            preparedStatement.setString(2, itemName);
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            log.warn("item {} can't be updated {}", itemName, category);
            throw new RuntimeException(e);
        }
    }


    private static final String deleteItem = "delete from item where item_name = ?";

    @Override
    public int deleteItem(String item_name) {
        try (Connection connection = JDBCConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(deleteItem)) {
            preparedStatement.setString(1, item_name);
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }


    private Item itemEntity(ResultSet rs) throws SQLException {
        Item itemEntity = new Item();
        itemEntity.setId(rs.getLong("item_id"));
        itemEntity.setItemName(rs.getString("item_name"));
        itemEntity.setItemDescription(rs.getString("item_description"));
        itemEntity.setItemQuantity(rs.getLong("item_quantity"));
        itemEntity.setItemCategoryId(rs.getInt("item_category_id"));
        itemEntity.setPriceForOne(rs.getLong("price_for_one"));
        return itemEntity;
    }

    private static final String getAllItems = "SELECT * FROM item";

    @Override
    public List<Item> getAll() {
        try (Connection connection = JDBCConnection.connect()) {
            PreparedStatement statement = connection.prepareStatement(getAllItems);
            List<Item> itemList;
            try (ResultSet resultSet = statement.executeQuery()) {
                itemList = new ArrayList<>();
                while (resultSet.next()) {
                    itemList.add(itemEntity(resultSet));
                }
            }
            return itemList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}


