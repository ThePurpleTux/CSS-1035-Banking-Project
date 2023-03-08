package tests;
import Exceptions.LargeDepositException;
import Exceptions.NegativeBalanceException;
import bankAccount.SavingsAccount_S2023_Group6;

public class TestBankAccount2 {
  	private static double startingBalance;
 	private static double depositAmount;
 	private static double withdrawAmount;
	private static double feeAmount;
	
	/** Main method */
  	public static void main(String[] args) {
		
		startingBalance = 155.55;
		depositAmount = 250.22;
		withdrawAmount = 150.01;
		feeAmount = 30;

		System.out.println("Create Savings Account with Information:");
		SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("2220", "Jane", "Doe", "002", startingBalance);
    	
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
		} catch (NegativeBalanceException ex){
			System.out.println(ex);
		}
		SavingsAccount.printSavingsAccount_S2023_Group6();

		System.out.println("Fee amount of: $" + feeAmount);
		SavingsAccount.chargeFees(feeAmount);
		SavingsAccount.printSavingsAccount_S2023_Group6();
	}
}