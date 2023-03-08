import Exceptions.LargeDepositException;
import Exceptions.NegativeBalanceException;

/**
 * <br>
 * <b> Savings Account Class </b> <br>
 * - Extends Bank Account Class <br>
 * - Contains constructor for Savings Account <br>
 * -
 * 
 * @author Group 6: James Dermezis, David Rosoff, James Tomasuolo, Oscar Xu
 *
 */
public class SavingsAccount_S2023_Group6 extends BankAccount_S2023_Group6 {
	private String savingAccountNum;
	private double accountBalance;

	/**
	 * Constructor for Savings Account
	 * 
	 * @apiNote extends Bank Account superclass
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
	 * @return accountBalance
	 * @throws LargeDepositException Secure Software Design Decision
	 */
	public double depositSavings(double depositAmount) throws LargeDepositException {
		if (depositAmount <= 1000000) {
			this.accountBalance += depositAmount;
			return this.accountBalance;
		} else
			throw new LargeDepositException(depositAmount);
	}

	/**
	 * Withdraw amount from account. Returns the balance after withdraw
	 * 
	 * @param withdrawAmount
	 * @return accountBalance
	 * @throws NegativeBalanceException Secure Software Design Decision
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
	 * @return accountBalance
	 */
	public double chargeFees(double fee) {
		this.accountBalance -= fee;

		return this.accountBalance;
	}
	// Getters and Setters

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