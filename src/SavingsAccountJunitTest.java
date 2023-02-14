import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountJunitTest {
    // Deposit Tests
    @Test
    void deposit1DollarEquals101() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        assertEquals(101,SavingsAccount.depositSavings(1));
    }

    @Test
    void deposit10DollarEquals110() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        assertEquals(110,SavingsAccount.depositSavings(10));
    }

    @Test
    void deposit100DollarEquals200() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        assertEquals(200,SavingsAccount.depositSavings(100));
    }

    @Test
    void deposit769DOT24DollarsEquals869DOT24() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        assertEquals(869.24,SavingsAccount.depositSavings(769.24));
    }

    // Withdraw Tests
    @Test
    void withdraw1DollarEquals999() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);
        assertEquals(999,SavingsAccount.withdrawSavings(1));
    }

    @Test
    void withdraw10DollarEquals990() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);
        assertEquals(990,SavingsAccount.withdrawSavings(10));
    }

    @Test
    void withdraw100DollarEquals900() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);

        assertEquals(900,SavingsAccount.withdrawSavings(100));
    }

    @Test
    void withdraw342DOT54DollarsEquals657DOT46() {
        SavingsAccount_S2023_Group6 SavingsAccount = new SavingsAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);

        assertEquals(657.46, SavingsAccount.withdrawSavings(342.54));
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