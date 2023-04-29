package Exceptions;

/**
 * <b> Double Validation Exception </b> <br>
 * - Exception is thrown when the required user input is not a double <br>
 * - Extends Exception superclass <br>
 * - Secure Software Design Decision <br>
 * 
 * @author Group 6: James Dermezis, David Rosoff, James Tomasuolo, Oscar Xu
 *
 */

public class DoubleValidiationException extends Exception {
    public DoubleValidiationException(double input) {
        super("Invalid input: " + input + ". Input must be a double");
    }
}
