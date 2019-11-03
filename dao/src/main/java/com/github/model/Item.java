package com.github.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    private Integer id;
    private String itemName;
    private String itemDescription;
    private Integer itemQuantity;
    private Integer itemCategoryId;
    private Integer priceForOne;


    public Item(String itemName, String itemDescription, Integer itemQuantity, Integer priceForOne) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.priceForOne = priceForOne;
    }

}
