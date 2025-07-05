package strategies;

public class NonExpired implements IExperiable {

    @Override
    public boolean IsExpire() {
        return false;
    }
}
