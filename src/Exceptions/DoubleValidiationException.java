package Exceptions;

public class DoubleValidiationException extends Exception {
    public DoubleValidiationException(double input){
        super("Invalid input: "  + input + ". Input must be a double");
    }
}
