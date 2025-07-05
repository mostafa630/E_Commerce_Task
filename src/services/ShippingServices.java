package services;

import java.util.List;

import models.CartItem;
import models.Product;

public class ShippingServices {
    public static void ship(List<CartItem> items) {
        System.out.println("                   #   Shipping Item Info #                       ");
        for (CartItem item : items) {
            System.out.println("Product Name: " + item.product.name);
            System.out.println("Unit Weight: " + item.product.getProductWeight() + " kg");
            System.out.println("shipped Price for each 1 KG: " + " 3.5 $");
            System.out.println("Required Quantity: " + item.requiredQuantity);
            System.out.println("Total Weight: " + (item.product.getProductWeight() * item.requiredQuantity) + " kg");
            System.out.println("Shipping Cost: " + (item.product.getProductWeight() * item.requiredQuantity * 3.5) + " $");
            System.out.println("------------------------------------------------------------------------------");
        }
    }
}
