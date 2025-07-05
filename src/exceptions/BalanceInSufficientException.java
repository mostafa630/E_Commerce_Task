package exceptions;

public class BalanceInSufficientException extends Exception {
    public BalanceInSufficientException(double totalPrice, double availableBalance) {
        super("Insufficient balance" + " ( TotalPrice = " + totalPrice + ", but your balance : " + availableBalance + " )");
    }
}
