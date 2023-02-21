package Exceptions;

public class LargeDepositException extends Exception{
    public LargeDepositException(double depositAmount){
        super("Deposits of more than $1000000 are not allowed. Deposit Amount: " + depositAmount);
    }
}
