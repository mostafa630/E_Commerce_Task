package exceptions;

public class CartEmptyException extends Exception {
    public CartEmptyException() {
        super("The cart is empty. Please add items to the cart before proceeding.");
    }
}
