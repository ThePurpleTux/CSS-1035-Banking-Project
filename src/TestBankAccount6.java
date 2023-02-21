import Exceptions.LargeDepositException;
import Exceptions.NegativeBalanceException;

public class TestBankAccount6 {
	private static double startingBalance;  
	private static double depositAmount;
	private static double withdrawAmount;
	private static double feeAmount;
  
  /** Main method */
  	public static void main(String[] args) {
		
		startingBalance = 6521.02;
		depositAmount = 1502.79;
		withdrawAmount = 672.96;
		feeAmount = 245;

		System.out.println("Create Checking Account with Information:");
		CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("6660", "Gregory", "Davis", "006", startingBalance);
    	
		System.out.println("Print Entire Bank Account Info:");
		System.out.println(CheckingAccount.toString());
		CheckingAccount.printCheckingAccount_S2023_Group6();

		System.out.println("Deposit amount of: $" + depositAmount);
		try{
			CheckingAccount.depositChecking(depositAmount);
		} catch (LargeDepositException ex) {
			System.out.println(ex);
		}
		CheckingAccount.printCheckingAccount_S2023_Group6();

		System.out.println("Withdraw amount of: $" + withdrawAmount);
		try{
			CheckingAccount.withdrawChecking(withdrawAmount);
		} catch (NegativeBalanceException ex) {
			System.out.println(ex);
		}
		CheckingAccount.printCheckingAccount_S2023_Group6();

		System.out.println("Withdraw amount of: $" + withdrawAmount);
		try{
			CheckingAccount.withdrawChecking(withdrawAmount);
		} catch (NegativeBalanceException ex){
			System.out.println(ex);
		}
		CheckingAccount.printCheckingAccount_S2023_Group6();

		System.out.println("Fee amount of: $" + feeAmount);
		CheckingAccount.chargeFees(feeAmount);
		CheckingAccount.printCheckingAccount_S2023_Group6();

		System.out.println("Fee amount of: $" + feeAmount);
		CheckingAccount.chargeFees(feeAmount);
		CheckingAccount.printCheckingAccount_S2023_Group6();
	}
}