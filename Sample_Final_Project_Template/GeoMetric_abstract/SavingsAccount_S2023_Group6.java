public class SavingsAccount_S2023_Group6 extends BankAccount_S2023_Group6 {
  private String savingAccountNum;
  private double accountBalance;

  public SavingsAccount_S2023_Group6(String savingAccountNum, double accountBalance) {
    this.savingAccountNum = savingAccountNum;
    this.accountBalance = accountBalance;
  }

  /** Deposit amount to the savings account. Returns the balance after deposit*/
  public double despositSaving(double depositAmount) {
    this.accountBalance += despositAmount;
    
    return this.accountBalance;
  }

  /** Withdraw amount from account. Returns the balance after withdrawl */
  public void withdrawSaving(double withdrawAmount) {
    this.accountBalance -= withdrawAmount;
    
    return this.accountBalance;
  }

  /** Charge Fees from account. Returns balance after fee */
  public double chargeFees(double fee) {
    this.accountBalance -= fee;
    
    return this.accountBalance;
  }

  /** Print the SavingAccount info */
  public void printSavingAccount_S2023_Group6(){
    System.out.println("Checking Account Information: [" + "Account Number: " + savingAccountNum + "; Account Balance: " + accountBalance + "]");
  }
}
