/**
 * 
 * @author Group 6: James Dermezis, David Rosoff, James Tomasuolo, Oscar Xu
 *
 */
public abstract class BankAccount_S2023_Group6 {
	private String bankAccountNumber;
	private String firstName;
	private String lastName;

//Constructor for Bank Account
	protected BankAccount_S2023_Group6(String bankAccountNumber, String firstName, String lastName) {
		this.bankAccountNumber = bankAccountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

//Getters and Setters
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "BankAccount_S2023_Group6 [BankAccountNumber= " + bankAccountNumber + ", firstName= " + firstName
				+ ", lastName= " + lastName + "]";
	}
}
