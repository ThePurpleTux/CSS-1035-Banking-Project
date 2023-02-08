public class TestBankAccount2 {
  	private static double startingBalance;
 	private static double depositAmount;
 	private static double withdrawAmount;
	private static double feeAmount;
	
	/** Main method */
  	public static void main(String[] args) {
		
		startingBalance = 155.55;
		depositAmount = 250;
		withdrawAmount = 15;
		feeAmount = 30;

		System.out.println("Create Savings Account with Information:");
		SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("2220", "Jane", "Doe", "002", startingBalance);
    	
		System.out.println("Print Entire Bank Account Info:");
		System.out.println(SavingsAccount.toString());
		SavingsAccount.printSavingsAccount_S2023_Group6();

		System.out.println("Deposit amount of: " + depositAmount);
		SavingsAccount.depositSavings(depositAmount);
		SavingsAccount.printSavingsAccount_S2023_Group6();

		System.out.println("Withdraw amount of: " + withdrawAmount);
		SavingsAccount.withdrawSavings(withdrawAmount);
		SavingsAccount.printSavingsAccount_S2023_Group6();

		System.out.println("Fee amount of: " + feeAmount);
		SavingsAccount.chargeFees(feeAmount);
		SavingsAccount.printSavingsAccount_S2023_Group6();
	}
}

