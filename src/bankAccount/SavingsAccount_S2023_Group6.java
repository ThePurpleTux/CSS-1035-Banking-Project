package bankAccount;
import Exceptions.DoubleValidiationException;
import Exceptions.LargeDepositException;
import Exceptions.NegativeBalanceException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <b> Savings Account Class </b> <br>
 * - Extends Bank Account Class <br>
 * - Contains constructor for Savings Account <br>
 * - Contains methods for depositing and withdrawing funds, as well as charging fees <br>
 * 
 * @author Group 6: James Dermezis, David Rosoff, James Tomasuolo, Oscar Xu
 *
 */
public class SavingsAccount_S2023_Group6 extends BankAccount_S2023_Group6 {
	private String savingAccountNum;
	private double accountBalance;

	/**
	 * Constructor for Savings Account <br>
	 * 
	 * - Protected Constructor - Secure Software Design Decision <br>
	 * - Extends Bank Account superclass <br>
	 * @param bankAccountNumber Bank Account Number
	 * @param firstName First Name
	 * @param lastName Last Name
	 * @param savingsAccountNum Savings Account Number
	 * @param accountBalance Account Balance
	 */
	public SavingsAccount_S2023_Group6(String bankAccountNumber, String firstName, String lastName,
									   String savingsAccountNum, double accountBalance) {
		super(bankAccountNumber, firstName, lastName);
		this.savingAccountNum = savingsAccountNum;
		this.accountBalance = accountBalance;
	}

	/**
	 * Deposit amount to the savings account. Returns the balance after deposit
	 * 
	 * @param depositAmount Deposit Amount
	 * @return accountBalance
	 * @throws LargeDepositException Secure Software Design Decision
	 */
	public double depositSavings(double depositAmount) throws LargeDepositException, DoubleValidiationException {
		// Input Validation
		if (!Validation.ValidateInput(Double.toString(depositAmount), "^[0-9]+$")){
			throw new DoubleValidiationException(depositAmount);
		}

		if (depositAmount <= 1000000) {
			return this.addToBalance(depositAmount);
		} else
			throw new LargeDepositException(depositAmount);
	}

	/**
	 * Withdraw amount from account. Returns the balance after withdraw
	 * 
	 * @param withdrawAmount Withdraw Amount
	 * @return accountBalance
	 * @throws NegativeBalanceException Secure Software Design Decision
	 */
	public double withdrawSavings(double withdrawAmount) throws NegativeBalanceException, DoubleValidiationException {
		// Input Validation
		if (!Validation.ValidateInput(Double.toString(withdrawAmount), "^[0-9]+$")){
			throw new DoubleValidiationException(withdrawAmount);
		}

		if (!WithdrawAmountValid(withdrawAmount))
			throw new NegativeBalanceException(withdrawAmount);

		subtractFromBalance(withdrawAmount);
		return this.accountBalance;
	}

	/**
	 * Charge Fees from account. Returns balance after fee
	 * 
	 * @param fee Fee
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
	 * @param SavingsAccountNumber Savings Account Number
	 */
	public void setSavingsAccountNumber(String SavingsAccountNumber) {
		this.savingAccountNum = SavingsAccountNumber;
	}

	private double addToBalance(double input){
		this.accountBalance += input;
		return this.accountBalance;
	}

	private void subtractFromBalance(double input) throws NegativeBalanceException{
		this.accountBalance -= input;
	}

	private boolean WithdrawAmountValid(double input){
		return ((this.accountBalance - input) >= 0);
	}

	/**
	 * Print the SavingAccount info
	 */
	public void printSavingsAccount_S2023_Group6() {
		System.out.println("Savings Account Information: [" + "Account Number: " + savingAccountNum
				+ "; Account Balance: $" + accountBalance + "]");
	}
}