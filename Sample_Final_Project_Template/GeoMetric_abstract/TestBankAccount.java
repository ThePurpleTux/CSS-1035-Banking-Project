public class TestBankAccount {
  /** Main method */
  private static double depositAmount;
  private static double withdrawAmount;
  private static double feeAmount;
  	public static void main(String[] args) {
		
		depositAmount = 100;
		withdrawAmount = .99;
		feeAmount = 50;

		System.out.println("Create Account with Information:");
		System.out.println("Print Entire Account Info:");
		SavingsAccount_S2023_Group6 save = new SavingsAccount_S2023_Group6("1110", "John", "Doe", "001", 99.99);
    	System.out.println(save.toString());
		save.printSavingAccount_S2023_Group6();
		System.out.println("Deposit amount of: " + depositAmount);
		save.depositSaving(depositAmount);
		save.printSavingAccount_S2023_Group6();
		System.out.println("Withdraw amount of: " + withdrawAmount);
		save.withdrawSaving(withdrawAmount);
		save.printSavingAccount_S2023_Group6();
		System.out.println("Fee amount of: " + feeAmount);
		save.chargeFees(feeAmount);
		save.printSavingAccount_S2023_Group6();
	}
}

