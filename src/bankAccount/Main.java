package bankAccount;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// Main runner for the app
public class Main {
    public static void Main(String[] args){
        List<CheckingAccount_S2023_Group6> checkingList = new

        System.out.println("CSS_1035_Banking_App");

    }

    static void DisplayMenu(){

    }

    static void RegisterCheckingAccount(boolean isChecking, String firstName, String lastName, double initDeposit){
        String accountNum = GenAccountNumber();

        if (!isChecking){
            CheckingAccount_S2023_Group6 newChecking = new CheckingAccount_S2023_Group6(accountNum, firstName, lastName, GenAccountNumber(), initDeposit);
        }

    }

    // https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
    static String GenAccountNumber(){
        String SALT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < SALT.length()){
            int index = (int) (rnd.nextFloat() * SALT.length());
            salt.append(SALT.charAt(index));
        }

        String saltStr = salt.toString();
        return saltStr;
    }

    static void LoadChecking(ArrayList<CheckingAccount_S2023_Group6> checkingList, CheckingAccount_S2023_Group6 account){
        checkingList.add(account);
    }

    static void LoadSavings(ArrayList<SavingsAccount_S2023_Group6> savingsList, SavingsAccount_S2023_Group6 account){
        savingsList.add(account);
    }
}
