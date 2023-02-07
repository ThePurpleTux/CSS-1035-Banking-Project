public abstract class BankAccount_S2023_Group6 {
  private String accountNumber;
  private String firstName;
  private String lastName;
  private Double balance;

  protected BankAccount_S2023_Group6() {
  }
  protected BankAccount_S2023_Group6(String accountNumber, String firstName, String lastName, Double balance) { 
    this.accountNumber = accountNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    this.balance = balance;
  }
 
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
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
  
  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "BankAccount_S2023_Group6 [accountNumber= " + accountNumber + ", firstName= " + firstName + ", lastName= " + lastName + "]";
  }
}
