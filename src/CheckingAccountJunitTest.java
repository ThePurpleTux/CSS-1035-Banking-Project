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
    void deposit1000DollarsEquals1100() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        assertEquals(1100,CheckingAccount.depositChecking(1000));
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
    void withdraw1000DollarsEquals0() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 1000);

        assertEquals(0, CheckingAccount.withdrawChecking(1000));
    }
}