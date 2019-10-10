package Model.DTO;

import Model.Category;

public class ItemByCategory {

    String item_name;
    String item_description;
    long item_quantity;
    long price_for_one;
    String category_name;


    public ItemByCategory(String item_name, String item_description, long item_quantity, long price_for_one, String category_name) {
        this.item_name = item_name;
        this.item_description = item_description;
        this.item_quantity = item_quantity;
        this.price_for_one = price_for_one;
        this.category_name = category_name;
    }
}
