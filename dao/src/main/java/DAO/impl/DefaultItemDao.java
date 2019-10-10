package DAO.impl;

import DAO.ItemDao;
import Model.Item;
import com.github.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DefaultItemDao implements ItemDao {

    private static volatile ItemDao instance;

    public static ItemDao getInstance() {
        ItemDao localInstance = instance;
        if (localInstance == null) {
            synchronized (ItemDao.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultItemDao();
                }
            }
        }
        return localInstance;
    }

 @Override
    public Item getItemByName(String itemName) {

        try (Connection connection = JDBCConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement("select * from item where item_name = ?")) {
            preparedStatement.setString(1, itemName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long item_id = resultSet.getLong("item_id");
                String item_name = resultSet.getString("item_name");
                String item_description= resultSet.getString("item_description");
                long item_quantity = resultSet.getLong("item_quantity");
                int item_category_id = resultSet.getInt("item_category_id ");
                long price_for_one = resultSet.getLong("price_for_one");
                //Item item = new Item();
                return new Item(item_id,item_name,item_description,item_quantity,item_category_id,price_for_one);
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Item getItemByPrice(int priceForOne) {
        return null;
    }

    @Override
    public void save(Item item) {

    }

}


