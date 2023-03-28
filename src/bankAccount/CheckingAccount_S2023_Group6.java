package bankAccount;
import Exceptions.DoubleValidiationException;
import Exceptions.LargeDepositException;
import Exceptions.NegativeBalanceException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * <b> Checking Account Class </b> <br>
 * - Extends Bank Account Class <br>
 * - Contains constructor for Checking Account <br>
 * - Contains methods for depositing and withdrawing funds, as well as charging fees <br>
 * 
 * @author Group 6: James Dermezis, David Rosoff, James Tomasuolo, Oscar Xu
 *
 */
public class CheckingAccount_S2023_Group6 extends BankAccount_S2023_Group6 {
	private String checkingAccountNum;
	private double accountBalance;

	/**
	 * Constructor for Checking Account - extends Bank Account superclass <br>
	 * 
	 * - Protected Constructor - Secure Software Design Decision <br>
	 * - Extends Bank Account superclass <br>
	 * @param bankAccountNumber Bank Account Number
	 * @param firstName First Name
	 * @param lastName Last Name
	 * @param checkingAccountNum Checking Account Number
	 * @param accountBalance Checking Account Balance
	 */
	public CheckingAccount_S2023_Group6(String bankAccountNumber, String firstName, String lastName,
										String checkingAccountNum, double accountBalance) {
		super(bankAccountNumber, firstName, lastName);
		this.checkingAccountNum = checkingAccountNum;
		this.accountBalance = accountBalance;
	}

	/**
	 * Deposit amount to account. Returns balance after deposit
	 * 
	 * @param depositAmount Deposit Amount
	 * @return accountBalance
	 * @throws LargeDepositException Secure Software Design Decision
	 * @throws DoubleValidiationException Secure Software Design Choice
	 */
	public double depositChecking(double depositAmount) throws LargeDepositException, DoubleValidiationException {
		// Input Validation
		if (!Extensions.ValidateInput(depositAmount, "^[0-9]+$")){
			throw new DoubleValidiationException(depositAmount);
		}

		if (depositAmount <= 1000000) {
			return this.addToBalance(depositAmount);
		} else
			throw new LargeDepositException(depositAmount);
	}

	/**
	 * Withdraw amount from account. Returns balance after withdrawl
	 * 
	 * @param withdrawlAmount Withdrawal Amount
	 * @return accountBalance
	 * @throws NegativeBalanceException Secure Software Design Decision
	 */
	public double withdrawChecking(double withdrawlAmount) throws NegativeBalanceException, DoubleValidiationException {
		// Input Validation
		if (!Extensions.ValidateInput(withdrawlAmount, "^[0-9]+$")){
			throw new DoubleValidiationException(withdrawlAmount);
		}

		if (!WithdrawAmountValid(withdrawlAmount))
			throw new NegativeBalanceException(withdrawlAmount);

		return subtractFromBalance(withdrawlAmount);
	}

	/**
	 * Charge Fees for account. Returns balance after fee.
	 * 
	 * @param fee Fee
	 * @return accountBalance
	 */
	public double chargeFees(double fee) {
		return this.subtractFromBalance(fee);
	}

	// Getters & Setters

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
	 * @param checkingAccountNumber Checking Account Number
	 */
	public void setCheckingAccountNumber(String checkingAccountNumber) {
		this.checkingAccountNum = checkingAccountNumber;
	}

	/**
	 * Add A Given Amount To The Account Balance
	 * @param amount The amount to add
	 * @return The account balance after adding amount
	 */
	private double addToBalance(double amount){
		this.accountBalance += amount;
		return this.accountBalance;
	}

	/**
	 * Subtract A Given Amount From The Account Balance
	 * @param amount The amount to subtract
	 * @return The account balance after subtracting amount
	 */
	private double subtractFromBalance(double amount){
		this.accountBalance -= amount;
		return this.accountBalance;
	}

	/**
	 * Checks if account balance is high enough to withdraw the requested amount
	 * @param withdrawAmount the amount to withdraw
	 * @return true/false - true if after subtracting the withdraw amount the account balance will still be greater than zero. False in all other cases
	 */
	private boolean WithdrawAmountValid(double withdrawAmount){
		return ((this.accountBalance - withdrawAmount) >= 0);
	}

	/**
	 * Print the CheckingAccount info
	 */
	public void printCheckingAccount_S2023_Group6() {
		System.out.println("Checking Account Information: [" + "Account Number: " + checkingAccountNum + "; "
				+ "Account Balance: $" + accountBalance + "]");
	}
}
