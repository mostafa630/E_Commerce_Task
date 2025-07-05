package exceptions;

public class OutOfStockException extends Exception {
    public OutOfStockException(String productName , int requiredQuantity , int availableQuantity) {
        super("product : "+ productName +" is out of stock" +"( Required quantiy : " + requiredQuantity + ", and the Available quantity : " + availableQuantity +" )");
        
    }
}
