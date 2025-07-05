package strategies;

public class NonShipped implements IShippable {

    @Override
    public boolean needTobeShipped() {
        return false;
    }

    @Override
    public double getProductWeight() {
        return 0.0; // that is not mean that the product has no weight, it means that it is not shipped
    }
    
}
