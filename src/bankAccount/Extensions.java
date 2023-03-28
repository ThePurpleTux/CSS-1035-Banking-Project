package bankAccount;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * <b>Validation Class</b><br>
 * - Responsible for validating input throughout the application
 * - Contains methods for validating each data type used in the application
 */
public class Extensions {

    /**
     * Validate a Given input - Takes an input and a regex query (both in string form) and attempts to find a match for the query within the input
     * @param input The input you want to validate
     * @param regex The regex to use for validation
     * @return true/false - Returns true if match was found and false in all other cases
     */
    public static <T> boolean ValidateInput(T input, String regex) {
        String inputString = String.valueOf(input);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);
        return matcher.find();
    }
}

