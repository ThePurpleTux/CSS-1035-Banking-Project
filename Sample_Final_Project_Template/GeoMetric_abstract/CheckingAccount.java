public class CheckingAccount extends BankAccount {
  private String checkingAcctNum;
  private double accountBalance;
 
  protected CheckingAccount(String checkingAcctNum, double accountBalance) { 
    this.checkingAcctNum = checkingAcctNum;
    this.accountBalance = accountBalance;
  }
/*  +methods to deposit into Checking_S2021_TEAMNAME or Savings_F2022_TEAMNAME account with inheritance (*Try to create Account_F2022_TEAMNAME.java and sub-classes Checking_F2022_TEAMNAME.java and Savings_S2021_TEAMNAME.java)
    +methods to withdraw money
    +methods to charge fees
    +unique teamname of classes
    +template provided in course module
    +UML diagram for application
*/

  /* Print the CheckingAccount info */
  public void printCheckingAccount() {
    System.out.println("Checking Account Information: [" + "Account Number: " + checkingAcctNum + "; " + "Account Balance: " + accountBalance + "]");
  }
}
