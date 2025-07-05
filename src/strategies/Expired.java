package strategies;
import java.time.LocalDate;


public class Expired implements IExperiable {

    LocalDate expirationDate;
   

    public Expired(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean IsExpire() {
        return LocalDate.now().isAfter(expirationDate);
    }
    
}
