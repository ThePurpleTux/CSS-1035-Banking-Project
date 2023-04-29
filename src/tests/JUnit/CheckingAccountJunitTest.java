package tests.JUnit;

/**
 * <b> JUnit Testing for Checking Account Class </b> <br>
 * 
 * @author Group 6: James Dermezis, David Rosoff, James Tomasuolo, Oscar Xu
 *
 */

import Exceptions.DoubleValidiationException;
import bankAccount.CheckingAccount_S2023_Group6;
import org.junit.jupiter.api.Test;
import Exceptions.LargeDepositException;
import Exceptions.NegativeBalanceException;
import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountJunitTest {

	@Test
	void SanityCheck(){
		assertFalse(1 == 1);
	}

	/**
	 * Deposit Test
	 */
	@Test
	void deposit1DollarEquals101() {
		CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson",
				"004", 100);
		try {
			assertEquals(101, CheckingAccount.depositChecking(1));
		} catch (LargeDepositException ex) {
			System.out.println(ex);
		} catch (DoubleValidiationException ex){
			System.out.println(ex);
		}
	}

	/**
	 * Deposit Test
	 */
	@Test
	void deposit10DollarsEquals110() {
		CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson",
				"004", 100);
		try {
			assertEquals(110, CheckingAccount.depositChecking(10));
		} catch (LargeDepositException ex) {
			System.out.println(ex);
		} catch (DoubleValidiationException ex){
			System.out.println(ex);
		}

	}

	/**
	 * Deposit Test
	 */
	@Test
	void deposit100DollarsEquals200() {
		CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson",
				"004", 100);
		try {
			assertEquals(200, CheckingAccount.depositChecking(100));
		} catch (LargeDepositException ex) {
			System.out.println(ex);
		} catch (DoubleValidiationException ex){
			System.out.println(ex);
		}
	}

	/**
	 * Deposit Test
	 */
	@Test
	void deposit769DOT24DollarsEquals869DOT24() {
		CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson",
				"004", 100);
		try {
			assertEquals(869.24, CheckingAccount.depositChecking(769.24));
		} catch (LargeDepositException ex) {
			System.out.println(ex);
		} catch (DoubleValidiationException ex){
			System.out.println(ex);
		}
	}

	@Test
	void InputNotDoubleThrowsDoubleInputValidationException(){
		CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson",
				"004", 100);
		try {
			assertEquals(869.24, CheckingAccount.depositChecking(769.24));
		} catch (LargeDepositException ex) {
			System.out.println(ex);
		} catch (DoubleValidiationException ex){
			System.out.println(ex);
		}
	}

	/**
	 * Withdraw Test
	 */
	@Test
	void withdraw1DollarEquals999() {
		CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson",
				"004", 1000);

		try {
			assertEquals(999, CheckingAccount.withdrawChecking(1));
		} catch (NegativeBalanceException ex) {
			System.out.println(ex);
		} catch (DoubleValidiationException ex){
			System.out.println(ex);
		}

	}

	/**
	 * Withdraw Test
	 */
	@Test
	void withdraw10DollarsEquals990() {
		CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson",
				"004", 1000);

		try {
			assertEquals(990, CheckingAccount.withdrawChecking(10));
		} catch (NegativeBalanceException ex) {
			System.out.println(ex);
		} catch (DoubleValidiationException ex){
			System.out.println(ex);
		}
	}

	/**
	 * Withdraw Test
	 */
	@Test
	void withdraw100DollarsEquals900() {
		CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson",
				"004", 1000);

		try {
			assertEquals(900, CheckingAccount.withdrawChecking(100));
		} catch (NegativeBalanceException ex) {
			System.out.println(ex);
		} catch (DoubleValidiationException ex){
			System.out.println(ex);
		}
	}

	/**
	 * Withdraw Test
	 */
	@Test
	void withdraw342DOT54DollarsEquals657DOT46() {
		CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson",
				"004", 1000);

		try {
			assertEquals(657.46, CheckingAccount.withdrawChecking(342.54));
		} catch (NegativeBalanceException ex) {
			System.out.println(ex);
		} catch (DoubleValidiationException ex){
			System.out.println(ex);
		}
	}

	/**
	 * Charge Fees Test
	 */
	@Test
	void chargeFees1Dollar() {
		CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson",
				"004", 1000);

		assertEquals(999, CheckingAccount.chargeFees(1));
	}

	/**
	 * Charge Fees Test
	 */
	@Test
	void chargeFees10Dollars() {
		CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson",
				"004", 1000);

		assertEquals(990, CheckingAccount.chargeFees(10));
	}

	/**
	 * Charge Fees Test
	 */
	@Test
	void chargeFees100Dollars() {
		CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson",
				"004", 1000);

		assertEquals(900, CheckingAccount.chargeFees(100));
	}

	/**
	 * Charge Fees Test
	 */
	@Test
	void chargeFees75DOT99Dollars() {
		CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson",
				"004", 1000);

		assertEquals(924.01, CheckingAccount.chargeFees(75.99));
	}
}