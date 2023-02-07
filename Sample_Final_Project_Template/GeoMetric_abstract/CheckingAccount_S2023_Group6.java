public class CheckingAccount_S2023_Group6 extends BankAccount_S2023_Group6 {
  private String checkingAccountNum;
  private double accountBalance;

  protected CheckingAccount_S2023_Group6(String bankAccountNumber, String firstName, String lastName, String checkingAccountNum, double accountBalance) {
    super(checkingAccountNum, checkingAccountNum, checkingAccountNum);
    this.checkingAccountNum = checkingAccountNum;
    this.accountBalance = accountBalance;
  }

  // Deposit amount to account. Returns balance after deposit
  public double depositChecking(double depositAmount) {
    this.accountBalance += depositAmount;

    return this.accountBalance;
  }

  // Withdraw amount from account. Returns balance after withdrawl
  public double withdrawChecking(double withdrawlAmount) {
    this.accountBalance -= withdrawlAmount;

    return this.accountBalance;
  }

  // Charge Fees for account. Returns balance after fee.
  public double chargeFees(double fee) {
    this.accountBalance -= fee;

    return this.accountBalance;
  }

  /* Print the CheckingAccount info */
  public void printCheckingAccount_S2023_Group6() {
    System.out.println("Checking Account Information: [" + "Account Number: " + checkingAccountNum + "; "
        + "Account Balance: " + accountBalance + "]");
  }
}
