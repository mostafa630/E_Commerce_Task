package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String name;
    double balance = 0.0;
    List<CartItem> userCart = new ArrayList<>(); // I encapsulated the product and its quantity in a CartItem class

    public User(String name , double balance) {
        this.balance = balance;
        this.name = name;
    }

    //we will handle the if the product is out of stock or the balance is not enough in the checkout service
    public void addToCart(Product product, int requiredQuantity) {
        CartItem cartItem = new CartItem(product, requiredQuantity);
        userCart.add(cartItem);
    }

    public List<CartItem> getUserCart(){
        return userCart;
    }

    public double getUserBalance() {
        return balance;
    }

}
