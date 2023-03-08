package Exceptions;

/**
 * <b> Negative Balance Exception </b> <br>
 * <br>
 * - As per Bank Policy: Exception is thrown when the account balance of a
 * Checking or Savings Account is negative <br>
 * - Extends Exception superclass <br>
 * 
 * @apiNote Secure Software Design Decision
 * @author Group 6: James Dermezis, David Rosoff, James Tomasuolo, Oscar Xu
 *
 */

public class NegativeBalanceException extends Exception {
	private double balance;

	public NegativeBalanceException(double balance) {
		super("Balance Cannot be Negative" + balance);
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}
}
