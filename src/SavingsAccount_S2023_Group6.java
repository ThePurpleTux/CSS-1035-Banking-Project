
/**
 * 
 * @author Group 6: James Dermezis, David Rosoff, James Tomasuolo, Oscar Xu
 *
 */
import Exceptions.LargeDepositException;
import Exceptions.NegativeBalanceException;

public class SavingsAccount_S2023_Group6 extends BankAccount_S2023_Group6 {
	private String savingAccountNum;
	private double accountBalance;

	/**
	 * Constructor for Savings Account
	 * 
	 * @apiNote Calls superclass Bank Account
	 * @param bankAccountNumber
	 * @param firstName
	 * @param lastName
	 * @param savingsAccountNum
	 * @param accountBalance
	 */
	protected SavingsAccount_S2023_Group6(String bankAccountNumber, String firstName, String lastName,
			String savingsAccountNum, double accountBalance) {
		super(bankAccountNumber, firstName, lastName);
		this.savingAccountNum = savingsAccountNum;
		this.accountBalance = accountBalance;
	}

	/**
	 * Deposit amount to the savings account. Returns the balance after deposit
	 * 
	 * @param depositAmount
	 * @return
	 * @throws LargeDepositException
	 */
	public double depositSavings(double depositAmount) throws LargeDepositException {
		if (depositAmount <= 1000000) {
			this.accountBalance += depositAmount;
			return this.accountBalance;
		} else
			throw new LargeDepositException(depositAmount);
	}

	/**
	 * Withdraw amount from account. Returns the balance after withdrawl
	 * 
	 * @param withdrawAmount
	 * @return
	 * @throws NegativeBalanceException
	 */
	public double withdrawSavings(double withdrawAmount) throws NegativeBalanceException {
		if ((this.accountBalance -= withdrawAmount) >= 0) {
			this.accountBalance -= withdrawAmount;
			return this.accountBalance;
		} else
			throw new NegativeBalanceException(this.accountBalance -= withdrawAmount);
	}

	/**
	 * Charge Fees from account. Returns balance after fee
	 * 
	 * @param fee
	 * @return
	 */
	public double chargeFees(double fee) {
		this.accountBalance -= fee;

		return this.accountBalance;
	}

	/**
	 * Getters and Setters
	 * 
	 */

	/**
	 * Get Savings Account Number
	 * 
	 * @return savingAccountNum
	 */
	public String getSavingsAccountNumber() {
		return savingAccountNum;
	}

	/**
	 * Set Savings Account Number
	 * 
	 * @param SavingsAccountNumber
	 */
	public void setSavingsAccountNumber(String SavingsAccountNumber) {
		this.savingAccountNum = SavingsAccountNumber;
	}

	/**
	 * Print the SavingAccount info
	 */
	public void printSavingsAccount_S2023_Group6() {
		System.out.println("Savings Account Information: [" + "Account Number: " + savingAccountNum
				+ "; Account Balance: $" + accountBalance + "]");
	}
}