public class TestGeometricObject {
  /** Main method */
  public static void main(String[] args) {
		SavingsAccount_S2023_Group6 save = new SavingsAccount_S2023_Group6("1110", "John", "Doe", "001", 8388.99);

		save.printSavingAccount_S2023_Group6();
		System.out.println("Deposit: 1000 " + save.depositSaving(1000));
		System.out.println("Withdraw: 5863 " + save.withdrawSaving(5863));
		System.out.println("Charge Fees: 53 " + save.chargeFees(53));
		save.printSavingAccount_S2023_Group6();
		
		
		
		CheckingAccount_S2023_Group6 check = new CheckingAccount_S2023_Group6("1337", 4722);
		System.out.println("\n");
		check.printCheckingAccount_S2023_Group6();
		System.out.println("Deposit: 2999 " + check.depositChecking(2999));
		System.out.println("Withdraw: 4533 " + check.withdrawChecking(4533));
		System.out.println("Charge Fees: 69 " + check.chargeFees(69));
		check.printCheckingAccount_S2023_Group6();

}

