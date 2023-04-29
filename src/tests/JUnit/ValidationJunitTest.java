package tests.JUnit;

import bankAccount.Extensions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <b> JUnit Testing for Input Validation </b> <br>
 * 
 * @author Group 6: James Dermezis, David Rosoff, James Tomasuolo, Oscar Xu
 *
 */
public class ValidationJunitTest {
    @Test
    void SanityCheck(){
        assertFalse(1 == 1);
    }

    @Test
    void TestValidation1(){
        assertFalse(Extensions.ValidateInput("Test", "^[0-9]+$"));
        assertTrue(Extensions.ValidateInput("100", "^[0-9]+$"));
    }

    @Test
    void TestValidation2(){
        assertFalse(Extensions.ValidateInput("100", "^[a-zA-Z]+$"));
        assertTrue(Extensions.ValidateInput("Test", "^[a-zA-Z]+$"));
    }
}
