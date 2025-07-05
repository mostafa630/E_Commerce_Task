package models;

public class CartItem {
    public Product product;
    public int requiredQuantity;

    public CartItem(Product product, int requiredQuantity) {
        this.product = product;
        this.requiredQuantity = requiredQuantity;
    }
}
