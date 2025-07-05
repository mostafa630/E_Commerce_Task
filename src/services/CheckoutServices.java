package services;
import java.util.ArrayList;
import java.util.List;

import exceptions.*;
import models.*;

import models.User;

 // we will follow this steps : 
        // 1- check if the cart is empty
        // 2- calculate the total price of the cart + shipping price
            //- if the product is expired, we will not add it to the total price
            //- if the product is out of stock, we will not add it to the total price
            //- add the shipping price if the product need to be shipped
        // 3- check if the user has enough balance or not
        // 4- if the user has enough moeny we will get him final balance and print all info needed
public class CheckoutServices {
    public static void checkout (User user) throws Exception {
        List<CartItem> cartItems = user.getUserCart();

        double balanceBeforeShopping = user.getUserBalance();
        double netCartPrice = 0.0;
        double shippingPrice = 0.0;
        double totalPrice = 0.0;
        List<CartItem> ItemsToBeShipped = new ArrayList<>();
        //- check if the cart is empty
        if(cartItems.isEmpty()) {
            throw new CartEmptyException();
        }

        //- calculate the total price of the cart + shipping price
        for(CartItem item : cartItems){
            if(item.product.isExpired()) {
                throw new ProductExpiredEception(item.product.name);
            }
            if(isItemOutOfStock(item.product.availableQuantity, item.requiredQuantity)) {
                throw new OutOfStockException(item.product.name, item.requiredQuantity, item.product.availableQuantity);
            }

            double itemTotalPrice = item.product.price * item.requiredQuantity;
            netCartPrice += itemTotalPrice;
            if(item.product.needToBeShipped()) {
                ItemsToBeShipped.add(item);
                shippingPrice += item.product.getProductWeight() * 3.5; // assuming shipping price is 3.5 per kg
            }
        }

        totalPrice = netCartPrice + shippingPrice;
        //- check if the user has enough balance or not
        if(!isUserHasEnoughBalance(user.getUserBalance(), totalPrice)) {
            throw new BalanceInSufficientException(totalPrice, user.getUserBalance());
        }


        printNetPriceInfo(cartItems);  // this will print the net price info for each item in the cart without shipping price
        ShippingServices.ship(ItemsToBeShipped); // this will print all info for shipping and  ship the items that need to be shipped
        printFinalInvoice(user, netCartPrice, shippingPrice, totalPrice, balanceBeforeShopping); // this will print the final invoice for the user

    }

    private static boolean isItemOutOfStock(int availableQuantity , int requiredQuantity) {
        return availableQuantity < requiredQuantity;
    }

    private static boolean isUserHasEnoughBalance(double userBalance , double totalPrice) {
        return userBalance >= totalPrice;
    }

    private static void printNetPriceInfo(List<CartItem> cartItems) {
      System.out.println("                      #  Net Price Info  #                    ");
        for (CartItem item : cartItems) {
            System.out.println("Product Name: " + item.product.name);
            System.out.println("Unit Price: " + item.product.price + " $");
            System.out.println("Required Quantity: " + item.requiredQuantity);
            System.out.println("Total Price for this Item: " + (item.product.price * item.requiredQuantity) + " $");
            System.out.println("------------------------------------------------------------------------------");
        }
    }

    private static void printFinalInvoice(User user, double netCartPrice , double shippingPrice, double totalPrice, double balanceBeforeShopping) {
        System.out.println("                   #  User Name : " + user.name + "  #            " );
        System.out.println("- Net Cart Price : " + netCartPrice);
        System.out.println("- shipping price: " + shippingPrice);
        System.out.println("- Total Price : " + totalPrice);
        System.out.println("\nBalance Before Shopping : " + balanceBeforeShopping);
        System.out.println("Balance After Shopping : " + (balanceBeforeShopping - totalPrice));
    }
}
