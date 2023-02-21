import Exceptions.LargeDepositException;
import Exceptions.NegativeBalanceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountJunitTest {
    // Deposit Tests
    @Test
    void deposit1DollarEquals101() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        try {
            assertEquals(101,SavingsAccount.depositSavings(1));
        } catch (LargeDepositException ex){
            System.out.println(ex);
        }
    }

    @Test
    void deposit10DollarEquals110() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        try {
            assertEquals(110,SavingsAccount.depositSavings(10));
        } catch (LargeDepositException ex){
            System.out.println(ex);
        }
    }


    @Test
    void deposit100DollarEquals200() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        try {
            assertEquals(200,SavingsAccount.depositSavings(100));
        } catch (LargeDepositException ex){
            System.out.println(ex);
        }
    }

    @Test
    void deposit769DOT24DollarsEquals869DOT24() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        try {
            assertEquals(869.24,SavingsAccount.depositSavings(769.24));
        } catch (LargeDepositException ex){
            System.out.println(ex);
        }
    }

    // Withdraw Tests
    @Test
    void withdraw1DollarEquals999() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);
        try {
            assertEquals(999,SavingsAccount.withdrawSavings(1));
        } catch (NegativeBalanceException ex){
            System.out.println(ex);
        }
    }

    @Test
    void withdraw10DollarEquals990() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);
        try {
            assertEquals(990,SavingsAccount.withdrawSavings(10));
        } catch (NegativeBalanceException ex){
            System.out.println(ex);
        }
    }

    @Test
    void withdraw100DollarEquals900() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);
        try {
            assertEquals(900,SavingsAccount.withdrawSavings(100));
        }catch (NegativeBalanceException ex){
            System.out.println(ex);
        }
    }

    @Test
    void withdraw342DOT54DollarsEquals657DOT46() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);
        try {
            assertEquals(657.46, SavingsAccount.withdrawSavings(342.54));
        } catch (NegativeBalanceException ex){
            System.out.println(ex);
        }
    }

    // Charge Fees Tests
    @Test
    void chargeFees1Dollar() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);

        assertEquals(999, SavingsAccount.chargeFees(1));
    }

    @Test
    void chargeFees10Dollar() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);

        assertEquals(990, SavingsAccount.chargeFees(10));
    }

    @Test
    void chargeFees100Dollar() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);

        assertEquals(900, SavingsAccount.chargeFees(100));
    }

    @Test
    void chargeFees75DOT99Dollars() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);

        assertEquals(924.01, SavingsAccount.chargeFees(75.99));
    }
}