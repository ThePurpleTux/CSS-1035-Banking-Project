package Exceptions;

public class NegativeBalanceException extends Exception{
    private double balance;

    public NegativeBalanceException(double balance){
        super("Balance Cannot be Negative" + balance);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
