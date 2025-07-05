package models;
import strategies.*;
public class Product {
    public String name;
    public double price;
    public int availableQuantity;

    public IExperiable experiable;
    public IShippable shippable;

    // here I will inject the strategies 
    // the product class don't know what is the strategy, it just use the interfaces
    public Product(String name , double price , int availableQuantity , IExperiable experiable , IShippable shippable) {
        this.name = name;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.experiable = experiable;
        this.shippable = shippable;
    }

    public boolean isExpired() {
        return experiable.IsExpire();
    }

    public boolean needToBeShipped() {
        return shippable.needTobeShipped();
    }

    public double getProductWeight() {
        return shippable.getProductWeight();
    }


}
