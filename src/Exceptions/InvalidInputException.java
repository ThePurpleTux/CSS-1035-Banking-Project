package Exceptions;

/**
 * <b> Invalid Input Exception </b> <br>
 * - Exception is thrown when the user input is invalid <br>
 * - Extends Exception superclass <br>
 * - Secure Software Design Decision <br>
 * 
 * @author Group 6: James Dermezis, David Rosoff, James Tomasuolo, Oscar Xu
 *
 */

public class InvalidInputException extends Exception{
    public <T> InvalidInputException(T input){
        super("Input is invalid");
    }
}
