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
		if (!Validation.ValidateInput(Double.toString(depositAmount), "^[0-9]+$")){
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
		if (!Validation.ValidateInput(Double.toString(withdrawlAmount), "^[0-9]+$")){
			throw new DoubleValidiationException(withdrawlAmount);
		}

		if (!WithdrawAmountValid(withdrawlAmount))
			throw new NegativeBalanceException(withdrawlAmount);

		subtractFromBalance(withdrawlAmount);
		return this.accountBalance;
	}

	/**
	 * Charge Fees for account. Returns balance after fee.
	 * 
	 * @param fee Fee
	 * @return accountBalance
	 */
	public double chargeFees(double fee) {
		this.accountBalance -= fee;

		return this.accountBalance;
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
	 * Print the CheckingAccount info
	 */
	public void printCheckingAccount_S2023_Group6() {
		System.out.println("Checking Account Information: [" + "Account Number: " + checkingAccountNum + "; "
				+ "Account Balance: $" + accountBalance + "]");
	}
}
