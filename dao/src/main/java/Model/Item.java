package Model;


public class Item {
    private Long id;
    private String itemName;
    private String itemDescription;
    private long itemQuantity;
    private int itemCategoryId;
    private long priceForOne;

    public Item() {
    }

    public Item(String itemName, String itemDescription, long itemQuantity, int itemCategoryId, long priceForOne) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.itemCategoryId = itemCategoryId;
        this.priceForOne = priceForOne;
    }

    public Item(Long id, String itemName, String itemDescription, long itemQuantity, int itemCategoryId, long priceForOne) {
        this.id = id;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.itemCategoryId = itemCategoryId;
        this.priceForOne = priceForOne;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public long getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(long itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(int itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public long getPriceForOne() {
        return priceForOne;
    }

    public void setPriceForOne(long priceForOne) {
        this.priceForOne = priceForOne;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", itemName='" + itemName + '\'' + ", itemDescription='" + itemDescription + '\'' + ", itemQuantity=" + itemQuantity + ", itemCategoryId=" + itemCategoryId + ", priceForOne=" + priceForOne + '}';
    }
}
