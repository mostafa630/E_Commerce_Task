package exceptions;

import java.time.LocalDate;

public class ProductExpiredEception extends Exception {
    public ProductExpiredEception(String productName) {
        super("Product: " + productName + " ( is expired )");
    }
    
}
