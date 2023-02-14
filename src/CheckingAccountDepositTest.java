import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountJunitTest {
    @Test
    void checkingAccountDeposit1Dollar() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        assertEquals(101,CheckingAccount.depositChecking(1));
    }

    @Test
    void checkingAccountDeposit10Dollars() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        assertEquals(110,CheckingAccount.depositChecking(10));
    }

    @Test
    void checkingAccountDeposit100Dollars() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        assertEquals(200,CheckingAccount.depositChecking(100));
    }

    @Test
    void checkingAccountDeposit1000Dollars() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        assertEquals(1100,CheckingAccount.depositChecking(1000));
    }
}