import Exceptions.LargeDepositException;
import Exceptions.NegativeBalanceException;

public class TestBankAccount3 {
	private static double startingBalance;
  	private static double depositAmount;
  	private static double withdrawAmount;
 	private static double feeAmount;
  
  /** Main method */
  	public static void main(String[] args) {
		
		startingBalance = 75.01;
		depositAmount = 600.92;
		withdrawAmount = 444.96;
		feeAmount = 12.94;

		System.out.println("Create Savings Account with Information:");
		SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("3330", "James", "Jones", "003", startingBalance);
    	
		System.out.println("Print Entire Bank Account Info:");
		System.out.println(SavingsAccount.toString());
		SavingsAccount.printSavingsAccount_S2023_Group6();

		System.out.println("Deposit amount of: $" + depositAmount);
		try{
			SavingsAccount.depositSavings(depositAmount);
		}catch (LargeDepositException ex){
			System.out.println(ex);
		}
		SavingsAccount.printSavingsAccount_S2023_Group6();

		System.out.println("Withdraw amount of: $" + withdrawAmount);
		try {
			SavingsAccount.withdrawSavings(withdrawAmount);
		} catch (NegativeBalanceException ex) {
			System.out.println(ex);
		}
		SavingsAccount.printSavingsAccount_S2023_Group6();

		System.out.println("Withdraw amount of: $" + withdrawAmount);
		try {
			SavingsAccount.withdrawSavings(withdrawAmount);
		} catch (NegativeBalanceException ex) {
			System.out.println(ex);
		}
		SavingsAccount.printSavingsAccount_S2023_Group6();

		System.out.println("Fee amount of: $" + feeAmount);
		SavingsAccount.chargeFees(feeAmount);
		SavingsAccount.printSavingsAccount_S2023_Group6();

		System.out.println("Fee amount of: $" + feeAmount);
		SavingsAccount.chargeFees(feeAmount);
		SavingsAccount.printSavingsAccount_S2023_Group6();
	}
}