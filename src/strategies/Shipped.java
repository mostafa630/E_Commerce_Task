package strategies;

public class Shipped implements IShippable  {

    private double weight;

    public Shipped(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean needTobeShipped() {
        return true;
    }

    @Override
    public double getProductWeight() {
        return weight;
    }
    
}
