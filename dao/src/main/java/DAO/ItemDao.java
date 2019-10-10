package DAO;

import Model.Item;

import java.util.List;

public interface ItemDao {
    Item getItemByName(String itemName);

    Item getItemByPrice(int priceForOne);

    void save(Item item);
}
