package bankAccount;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validation {

    public static boolean ValidateInput(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}

