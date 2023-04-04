package tests.StaticTests;
import Exceptions.DoubleValidiationException;
import Exceptions.LargeDepositException;
import Exceptions.NegativeBalanceException;
import bankAccount.SavingsAccount_S2023_Group6;

public class TestBankAccount1 {
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

		System.out.println("Create Savings Account with Information:");
		SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("1110", "John", "Doe", "001", startingBalance);
    	
		System.out.println("Print Entire Bank Account Info:");
		System.out.println(SavingsAccount.toString());
		System.out.println(SavingsAccount);

		System.out.println("Deposit amount of: $" + depositAmount);
		try{
			SavingsAccount.depositSavings(depositAmount);
		} catch (LargeDepositException ex){
			System.out.println(ex);
		} catch (DoubleValidiationException ex){
			System.out.println(ex);
		}
		System.out.println(SavingsAccount);

		System.out.println("Withdraw amount of: $" + withdrawAmount);
		try {
			SavingsAccount.withdrawSavings(withdrawAmount);
		} catch (NegativeBalanceException ex){
			System.out.println(ex);
		} catch (DoubleValidiationException ex){
			System.out.println(ex);
		}
		System.out.println(SavingsAccount);

		System.out.println("Fee amount of: $" + feeAmount);
		SavingsAccount.chargeFees(feeAmount);
		System.out.println(SavingsAccount);
	  }
}