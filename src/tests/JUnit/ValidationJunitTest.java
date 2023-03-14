package tests.JUnit;

import bankAccount.Validation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationJunitTest {
    @Test
    void SanityCheck(){
        assertFalse(1 == 1);
    }

    @Test
    void TestValidation1(){
        assertFalse(Validation.ValidateInput("Test", "^[0-9]+$"));
        assertTrue(Validation.ValidateInput("100", "^[0-9]+$"));
    }

    @Test
    void TestValidation2(){
        assertFalse(Validation.ValidateInput("100", "^[a-zA-Z]+$"));
        assertTrue(Validation.ValidateInput("Test", "^[a-zA-Z]+$"));
    }
}
