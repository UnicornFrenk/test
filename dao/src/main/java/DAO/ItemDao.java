package DAO;

import Model.Item;

import java.util.List;

public interface ItemDao {
    Item getItemByName(String itemName);

    Item getItemByPrice(long priceForOne);

    void save(Item item);
}
