package Exceptions;

/**
 * <b> Large Deposit Exception </b> <br>
 * <br>
 * - As per Bank policy: Exception is thrown when a deposit into a Checking or
 * Savings Account exceeds $1,000,000 <br>
 * - Extends Exception superclass <br>
 * 
 * @apiNote Secure Software Design Decision
 * @author Group 6: James Dermezis, David Rosoff, James Tomasuolo, Oscar Xu
 *
 */

public class LargeDepositException extends Exception {
	public LargeDepositException(double depositAmount) {
		super("Deposits of more than $1000000 are not allowed. Deposit Amount: " + depositAmount);
	}
}
