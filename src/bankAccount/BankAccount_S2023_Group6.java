package bankAccount;
/**
 * <b> Bank Account Class</b> <br>
 * - Contains constructor, getters, and setters for Bank Account <br>
 * - Superclass <br>
 * 
 * @author Group 6: James Dermezis, David Rosoff, James Tomasuolo, Oscar Xu
 *
 */
public abstract class BankAccount_S2023_Group6 {
	private String bankAccountNumber;
	private String firstName;
	private String lastName;

	/**
	 * Constructor for Bank Account <br>
	 * 
	 * - Protected Constructor - Secure Software Design Decision <br>
	 * @param bankAccountNumber Bank Account Number
	 * @param firstName First Name
	 * @param lastName Last Name
	 */
	protected BankAccount_S2023_Group6(String bankAccountNumber, String firstName, String lastName) {
		this.bankAccountNumber = bankAccountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Getters and Setters
	/**
	 * Get Bank Account Number
	 * 
	 * @return bankAccountNumber
	 */
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	/**
	 * Set Bank Account Number
	 * 
	 * @param bankAccountNumber Bank Account Number
	 */
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	/**
	 * Get First Name
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set First Name
	 * 
	 * @param firstName First Name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get Last Name
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set Last Name
	 * 
	 * @param lastName Last Name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Print the Bank Account Information
	 */
	@Override
	public String toString() {
		return "BankAccount_S2023_Group6 [BankAccountNumber= " + bankAccountNumber + ", firstName= " + firstName
				+ ", lastName= " + lastName + "]";
	}
}
