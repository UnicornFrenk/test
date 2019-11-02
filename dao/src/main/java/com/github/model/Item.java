package com.github.model;


public class Item {
    private Integer id;
    private String itemName;
    private String itemDescription;
    private Integer itemQuantity;
    private Integer itemCategoryId;
    private Integer priceForOne;

    public Item() {
    }

    public Item(String itemName, String itemDescription, Integer itemQuantity, Integer itemCategoryId, Integer priceForOne) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.itemCategoryId = itemCategoryId;
        this.priceForOne = priceForOne;
    }

    public Item(Integer id, String itemName, String itemDescription, Integer itemQuantity, Integer itemCategoryId, Integer priceForOne) {
        this.id = id;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.itemCategoryId = itemCategoryId;
        this.priceForOne = priceForOne;
    }
    public Item(String itemName, String itemDescription, Integer itemQuantity, Integer priceForOne) {
        this.id = id;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.itemCategoryId = itemCategoryId;
        this.priceForOne = priceForOne;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Integer getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(Integer itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public Integer getPriceForOne() {
        return priceForOne;
    }

    public void setPriceForOne(Integer priceForOne) {
        this.priceForOne = priceForOne;
    }

    @Override
    public String toString() {
        return "ItemEntity{" + "id=" + id + ", itemName='" + itemName + '\'' + ", itemDescription='" + itemDescription + '\'' + ", itemQuantity=" + itemQuantity + ", itemCategoryId=" + itemCategoryId + ", priceForOne=" + priceForOne + '}';
    }
}
