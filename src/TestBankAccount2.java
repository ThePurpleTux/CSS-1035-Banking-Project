public class TestBankAccount2 {
  	private static double startingBalance;
 	private static double depositAmount;
 	private static double withdrawAmount;
	private static double feeAmount;
	
	/** Main method */
  	public static void main(String[] args) {
		
		startingBalance = 99.99;
		depositAmount = 100;
		withdrawAmount = .99;
		feeAmount = 50;

		System.out.println("Create Account with Information:");
		SavingsAccount_S2023_Group6 savingsAcct1 = new SavingsAccount_S2023_Group6("1110", "John", "Doe", "001", startingBalance);
    	
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

