
/**
 * 
 * @author Group 6: James Dermezis, David Rosoff, James Tomasuolo, Oscar Xu
 *
 */
import Exceptions.LargeDepositException;
import Exceptions.NegativeBalanceException;

public class CheckingAccount_S2023_Group6 extends BankAccount_S2023_Group6 {
	private String checkingAccountNum;
	private double accountBalance;

	/**
	 * Constructor for Checking Account - calls super class Bank Account
	 * 
	 * @param bankAccountNumber
	 * @param firstName
	 * @param lastName
	 * @param checkingAccountNum
	 * @param accountBalance
	 */
	protected CheckingAccount_S2023_Group6(String bankAccountNumber, String firstName, String lastName,
			String checkingAccountNum, double accountBalance) {
		super(bankAccountNumber, firstName, lastName);
		this.checkingAccountNum = checkingAccountNum;
		this.accountBalance = accountBalance;
	}

	/**
	 * Deposit amount to account. Returns balance after deposit
	 * 
	 * @param depositAmount
	 * @return accountBalance
	 * @throws LargeDepositException
	 */
	public double depositChecking(double depositAmount) throws LargeDepositException {
		if (depositAmount <= 1000000) {
			this.accountBalance += depositAmount;
			return this.accountBalance;
		} else
			throw new LargeDepositException(depositAmount);
	}

	/**
	 * Withdraw amount from account. Returns balance after withdrawl
	 * 
	 * @param withdrawlAmount
	 * @return accountBalance
	 * @throws NegativeBalanceException
	 */
	public double withdrawChecking(double withdrawlAmount) throws NegativeBalanceException {
		if ((this.accountBalance -= withdrawlAmount) >= 0) {
			this.accountBalance -= withdrawlAmount;
			return this.accountBalance;
		} else
			throw new NegativeBalanceException(this.accountBalance -= withdrawlAmount);
	}

	/**
	 * Charge Fees for account. Returns balance after fee.
	 * 
	 * @param fee
	 * @return accountBalance
	 */
	public double chargeFees(double fee) {
		this.accountBalance -= fee;

		return this.accountBalance;
	}

	/**
	 * Getters and setters
	 */
	/**
	 * Get Checking Account Number
	 * 
	 * @return checkingAccountNum
	 */
	public String getCheckingAccountNumber() {
		return checkingAccountNum;
	}

	/**
	 * Set Checking Account Number
	 * 
	 * @param checkingAccountNumber
	 */
	public void setCheckingAccountNumber(String checkingAccountNumber) {
		this.checkingAccountNum = checkingAccountNumber;
	}

	/**
	 * Print the CheckingAccount info
	 */
	public void printCheckingAccount_S2023_Group6() {
		System.out.println("Checking Account Information: [" + "Account Number: " + checkingAccountNum + "; "
				+ "Account Balance: $" + accountBalance + "]");
	}
}
