import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountJunitTest {
    @Test
    void checkingAccountDeposit() {
        CheckingAccount_S2023_Group6 CheckingAccount = new CheckingAccount_S2023_Group6("4440", "Jessica", "Johnson", "004", 100);
        assertEquals(110,CheckingAccount.depositChecking(10));
    }
}