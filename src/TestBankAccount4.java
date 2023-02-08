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

		System.out.println("Create Account with Information:");
		SavingsAccount_S2023_Group6 savingsAcct1 = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", startingBalance);
    	
		System.out.println("Print Entire Account Info:");
		System.out.println(savingsAcct1.toString());
		savingsAcct1.printSavingAccount_S2023_Group6();

		System.out.println("Deposit amount of: " + depositAmount);
		savingsAcct1.depositSaving(depositAmount);
		savingsAcct1.printSavingAccount_S2023_Group6();

		System.out.println("Withdraw amount of: " + withdrawAmount);
		savingsAcct1.withdrawSaving(withdrawAmount);
		savingsAcct1.printSavingAccount_S2023_Group6();

		System.out.println("Fee amount of: " + feeAmount);
		savingsAcct1.chargeFees(feeAmount);
		savingsAcct1.printSavingAccount_S2023_Group6();
	}
}

