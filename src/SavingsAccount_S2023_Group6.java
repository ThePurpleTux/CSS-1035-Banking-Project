public class SavingsAccount_S2023_Group6 extends BankAccount_S2023_Group6 {
  private String savingAccountNum;
  private double accountBalance;

  //Constructor for Savings Account - calls superclass Bank Account
  protected SavingsAccount_S2023_Group6(String bankAccountNumber, String firstName, String lastName, String savingsAccountNum, double accountBalance) {
    super(bankAccountNumber, firstName, lastName);
    this.savingAccountNum = savingsAccountNum;
    this.accountBalance = accountBalance;
  }

  /** Deposit amount to the savings account. Returns the balance after deposit */
  public double depositSavings(double depositAmount) {
    this.accountBalance += depositAmount;

    return this.accountBalance;
  }

  /** Withdraw amount from account. Returns the balance after withdrawl */
  public double withdrawSavings(double withdrawAmount) {
    this.accountBalance -= withdrawAmount;

    return this.accountBalance;
  }

  /** Charge Fees from account. Returns balance after fee */
  public double chargeFees(double fee) {
    this.accountBalance -= fee;

    return this.accountBalance;
  }

  /** Print the SavingAccount info */
  public void printSavingsAccount_S2023_Group6() {
    System.out.println("Savings Account Information: [" + "Account Number: " + savingAccountNum + "; Account Balance: $"
        + accountBalance + "]");
  }
}
