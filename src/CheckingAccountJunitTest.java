import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountJunitTest {

    // Deposit Tests
    @Test
    void deposit1DollarEquals101() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        assertEquals(101,CheckingAccount.depositChecking(1));
    }

    @Test
    void deposit10DollarsEquals110() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        assertEquals(110,CheckingAccount.depositChecking(10));
    }

    @Test
    void deposit100DollarsEquals200() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        assertEquals(200,CheckingAccount.depositChecking(100));
    }

    @Test
    void deposit769DOT24DollarsEquals869DOT24() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        assertEquals(869.24,CheckingAccount.depositChecking(769.24));
    }

    // Withdraw Tests
    @Test
    void withdraw1DollarEquals999() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);

        assertEquals(999, CheckingAccount.withdrawChecking(1));
    }

    @Test
    void withdraw10DollarsEquals990() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);

        assertEquals(990, CheckingAccount.withdrawChecking(10));
    }

    @Test
    void withdraw100DollarsEquals900() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);

        assertEquals(900, CheckingAccount.withdrawChecking(100));
    }

    @Test
    void withdraw342DOT54DollarsEquals657DOT46() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);

        assertEquals(657.46, CheckingAccount.withdrawChecking(342.54));
    }

    //chargeFees Tests
    @Test
    void chargeFees1Dollar() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);

        assertEquals(999, CheckingAccount.chargeFees(1));
    }

    @Test
    void chargeFees10Dollars() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);

        assertEquals(990, CheckingAccount.chargeFees(10));
    }

    @Test
    void chargeFees100Dollars() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);

        assertEquals(900, CheckingAccount.chargeFees(100));
    }

    @Test
    void chargeFees75DOT99Dollars() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);

        assertEquals(924.01, CheckingAccount.chargeFees(75.99));
    }
}