package Exceptions;

public class InvalidInputException extends Exception{
    public <T> InvalidInputException(T input){
        super("Input is invalid");
    }
}
