public class TestBankAccount4 {
  	private static double startingBalance;
  	private static double depositAmount;
  	private static double withdrawAmount;
 	private static double feeAmount;
  
  /** Main method */
  	public static void main(String[] args) {
		
		startingBalance = 769.24;
		depositAmount = 322.54;
		withdrawAmount = 342.54;
		feeAmount = 75.99;

		System.out.println("Create Checking Account with Information:");
		CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", startingBalance);
    	
		System.out.println("Print Entire Bank Account Info:");
		System.out.println(CheckingAccount.toString());
		CheckingAccount.printCheckingAccount_S2023_Group6();

		System.out.println("Deposit amount of: $" + depositAmount);
		CheckingAccount.depositChecking(depositAmount);
		CheckingAccount.printCheckingAccount_S2023_Group6();

		System.out.println("Withdraw amount of: $" + withdrawAmount);
		CheckingAccount.withdrawChecking(withdrawAmount);
		CheckingAccount.printCheckingAccount_S2023_Group6();

		System.out.println("Fee amount of: $" + feeAmount);
		CheckingAccount.chargeFees(feeAmount);
		CheckingAccount.printCheckingAccount_S2023_Group6();
	}
}