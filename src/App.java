import java.time.LocalDate;

import models.Product;
import models.User;
import strategies.*;

import services.CheckoutServices;
public class App {
    public static void main(String[] args) throws Exception {
            /*
            * Important notes : 
            * I choose to use the Strategy pattern  due its great use in situations when we need to 
            * add behaviour in the run time and in our case the behaviour of the product in real life 
            * will be determined in the run time by the Manager of the store
            * 
            * I use Strategy Patter and I prefer in this case using Composition over Inheritance
            * because I want to add the behaviour of the product in the run time and I don't want to create a class
            * for each product type I want to create a class for each behaviour and then inject it into the product
            * so that will give me the chance to add new options rather than Expireable or Shippable or both of them
            * without the need to create a new class for each product type , just create a new strategy class
            *  and inject it into the product. (For Scalability and Flexibility)
            * 
            * 
            * To Add item to the Stock I can make it purely happen in the Runtime by using the Factory pattern
            * and based on choices the Manager of the store will make, the product will be created with the
            * required strategies.
            * 
            * but for the sake of simplicity I will just create the products in the code and assume that some of them
            * are expired and some of them need to be shipped and some of them are not.  (imagne that Manager choose that)
            */

         // Create some products with different strategies
         Product cheese = new Product("Cheese" , 10.0 , 5 ,
            new Expired(LocalDate.of(2026, 7, 8)), // expired product
            new Shipped(2.0) // needs to be shipped
         );

        Product biscuits = new Product("Biscuits" , 5.0 , 20 ,
            new Expired(LocalDate.of(2028, 10, 1)), 
            new NonShipped() 
        );

        Product tv = new Product("TV" , 5000.0 , 10 ,
            new NonExpired(), 
            new Shipped(20.0) 
        );

        // Create user and add products to the cart
        User user = new models.User("Mostafa Younis", 6000.0);
        user.addToCart(cheese, 2); 
        user.addToCart(biscuits, 3);
        user.addToCart(tv, 1); // this product will be shipped

        // Checkout and handle exceptions
        try {
            CheckoutServices.checkout(user);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        
    }
}
