package bankAccount;

import Exceptions.DoubleValidiationException;
import Exceptions.LargeDepositException;
import Exceptions.NegativeBalanceException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Main runner for the app
public class Main {
    public static void main(String[] args){
        File outfile = new File(System.getProperty("user.home") + File.separator + "Banking" + File.separator + "data.dat");
        ArrayList<BankAccount_S2023_Group6> _accountList = new ArrayList<>();
        BankAccount_S2023_Group6 currentAccount = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Password: ");
        String password = scanner.nextLine();


        if (outfile.exists()){
            try {
                _accountList = LoadFromFile(outfile);
            } catch (FileNotFoundException e){
                System.out.printf("File \"%s\" not found...%n", outfile.getAbsoluteFile());
            }
        }




        System.out.println("CSS_1035_Banking_App");

        /*There's no input validation on any of the user input, an attacker 
         *can add their code or the user might type something to stop the application
        */
        while (true){

            if (currentAccount != null){
                // Display logged in menu
                System.out.println(LoggedInMenu());

                int choice = scanner.nextInt();

                if (choice == 1){
                    StringBuilder accountInfo = new StringBuilder();
                    accountInfo.append("\nAccount Info: ");
                    accountInfo.append("\nName: %s %s".formatted(currentAccount.getFirstName(), currentAccount.getLastName()));
                    accountInfo.append("\nAccount Number: %s".formatted(currentAccount.getBankAccountNumber()));
                    accountInfo.append("\nChecking Accounts: ");

                    for (CheckingAccount_S2023_Group6 account: currentAccount.getCheckingAccounts()) {
                        accountInfo.append("\n\t");
                        accountInfo.append(account);
                    }

                    accountInfo.append("\nSavings Accounts: ");
                    for (SavingsAccount_S2023_Group6 account: currentAccount.getSavingsAccounts()) {
                        accountInfo.append("\n\t");
                        accountInfo.append(account);
                    }

                    System.out.println(accountInfo);
                }

                if (choice == 2){
                    System.out.println("\nRegister new savings account");
                    System.out.println("\n-----------------------------");

                    System.out.println("\nCreating new savings account for account number: " + currentAccount.getBankAccountNumber());
                    String savingsAccountNum = RegisterSavingsAccount(currentAccount);
                    System.out.println("\nSavings account created with account number: " + savingsAccountNum + " for Bank Account " + currentAccount.getBankAccountNumber());
                }

                if (choice == 3){
                    System.out.println("\nRegister new checking account");
                    System.out.println("-----------------------------");

                    System.out.println("\nCreating new checking account for account number: " + currentAccount.getBankAccountNumber());
                    String checkingAccountNum = RegisterCheckingAccount(currentAccount);
                    System.out.println("\nChecking account created with account number: " + checkingAccountNum + " for Bank Account " + currentAccount.getBankAccountNumber());
                }

                if (choice == 4){
                    scanner.nextLine(); // Consume leftover input

                    System.out.println("""
                            \nWould you like to deposit into a savings or checking account? (Enter a number)
                            1. Savings
                            2. Checking
                            
                            """);
                    int input = Integer.parseInt(scanner.nextLine());

                    if (!Extensions.ValidateInput(input, "^[12]$")){
                        System.out.println("Invalid Input, please enter 1 or 2...");
                        continue;
                    }

                    if (input == 1){
                        System.out.println("\nPlease enter the account number of the savings account you would like to deposit into: ");
                        String accountNum = scanner.nextLine();

                        for (SavingsAccount_S2023_Group6 savingsAccount: currentAccount.getSavingsAccounts()) {
                            if (savingsAccount.getSavingsAccountNumber().equals(accountNum)){
                                System.out.println("\nEnter the amount you would like to deposit: ");
                                double amount = Double.parseDouble(scanner.nextLine()); // for now, we are trusting that the user will enter a valid number. Input will need to be validated at some point.

                                System.out.println("Adding " + amount + " dollars to account " + savingsAccount.getSavingsAccountNumber());
                                try {
                                    savingsAccount.depositSavings(amount);
                                } catch (LargeDepositException e) {
                                    throw new RuntimeException(e);
                                } catch (DoubleValidiationException e) {
                                    throw new RuntimeException(e);
                                }

                                System.out.println("Deposit Successful...");
                            }
                        }
                    }

                    if (input == 2){
                        System.out.println("\nPlease enter the account number of the checking account you would like to deposit into: ");
                        String accountNum = scanner.nextLine();

                        for (CheckingAccount_S2023_Group6 checkingAccount: currentAccount.getCheckingAccounts()){
                            if (checkingAccount.getCheckingAccountNumber().equals(accountNum)){
                                System.out.println("\nEnter the amount you would like to deposit");
                                double amount = Double.parseDouble(scanner.nextLine()); // for now, we are trusting that the user will enter a valid number. Input will need to be validated at some point.

                                System.out.println("Adding " + amount + " dollars to account " + checkingAccount.getCheckingAccountNumber());
                                try {
                                    checkingAccount.depositChecking(amount);
                                } catch (LargeDepositException e) {
                                    throw new RuntimeException(e);
                                } catch (DoubleValidiationException e) {
                                    throw new RuntimeException(e);
                                }

                                System.out.println("Deposit Successful...");
                            }
                        }
                    }


                }

                if (choice == 5){
                    scanner.nextLine(); // Consume leftover input

                    System.out.println("""
                            \nWould you like to withdraw from a savings or checking account? (Enter a number)
                            1. Savings
                            2. Checking
                            
                            """);
                    int input = Integer.parseInt(scanner.nextLine());

                    if (!Extensions.ValidateInput(input, "^[12]$")){
                        System.out.println("Invalid Input, please enter 1 or 2...");
                        continue;
                    }

                    if (input == 1){
                        System.out.println("\nPlease enter the account number of the savings account you would like to withdraw from: ");
                        String accountNum = scanner.nextLine();

                        for (SavingsAccount_S2023_Group6 savingsAccount: currentAccount.getSavingsAccounts()) {
                            if (savingsAccount.getSavingsAccountNumber().equals(accountNum)){
                                System.out.println("\nEnter the amount you would like to withdraw: ");
                                double amount = Double.parseDouble(scanner.nextLine()); // for now, we are trusting that the user will enter a valid number. Input will need to be validated at some point.

                                System.out.println("Withdrawing " + amount + " dollars from account " + savingsAccount.getSavingsAccountNumber());
                                try {
                                    savingsAccount.withdrawSavings(amount);
                                } catch (DoubleValidiationException e) {
                                    throw new RuntimeException(e);
                                } catch (NegativeBalanceException e) {
                                    throw new RuntimeException(e);
                                }

                                System.out.println("Deposit Successful...");
                            }
                        }
                    }

                    if (input == 2){
                        System.out.println("\nPlease enter the account number of the checking account you would like to withdraw from: ");
                        String accountNum = scanner.nextLine();

                        for (CheckingAccount_S2023_Group6 checkingAccount: currentAccount.getCheckingAccounts()) {
                            if (checkingAccount.getCheckingAccountNumber().equals(accountNum)){
                                System.out.println("\nEnter the amount you would like to withdraw: ");
                                double amount = Double.parseDouble(scanner.nextLine()); // for now, we are trusting that the user will enter a valid number. Input will need to be validated at some point.

                                System.out.println("Withdrawing " + amount + " dollars from account " + checkingAccount.getCheckingAccountNumber());
                                try {
                                    checkingAccount.withdrawChecking(amount);
                                } catch (DoubleValidiationException e) {
                                    throw new RuntimeException(e);
                                } catch (NegativeBalanceException e) {
                                    throw new RuntimeException(e);
                                }

                                System.out.println("Deposit Successful...");
                            }
                        }
                    }
                }

                if (choice == 0){
                    System.out.println("\nLogging Out...");
                    currentAccount = null;
                }

                continue;
            }

            System.out.println(MainMenu());

            int choice = scanner.nextInt();

            if (choice == 1){
                System.out.println("\n\n\n");
                System.out.println("Register new bank account\n");
                System.out.println("-----------------------------\n");

                scanner.nextLine(); //consume left over input

                System.out.print("Please enter your first name: ");
                String firstName = scanner.nextLine();

                System.out.print("Please enter your last name: ");
                String lastName = scanner.nextLine();

                BankAccount_S2023_Group6 account = RegisterBankAccount(firstName, lastName);
                LoadBankAccount(_accountList, account);
                System.out.println("Account Created. \nAccount Number: " + account.getBankAccountNumber());

                continue;
            }

            if (choice == 2){
                scanner.nextLine(); //consume left over input

                System.out.println("\nEnter your bank account number: ");
                String accountNum = scanner.nextLine();

                BankAccount_S2023_Group6 account = LogIn(accountNum, _accountList);
                if (account != null){
                    // update current account
                    currentAccount = account;
                    System.out.println("\nLogin Success");
                    System.out.println("\nAccount Info: ");
                    System.out.printf("\n%s%n", currentAccount);

                    continue;
                }

                //default it to not log in
                System.out.println("\nAccount not found...");
                continue;

            }

            if (choice == 0){
                System.out.println("\n\nThanks for banking with us!");
                System.out.println("\nSaving Data...");

                try{
                    System.out.println(SaveData(_accountList, password));
                } catch (Exception e){
                    System.out.println(e.getMessage());
                } finally {
                    scanner.close();
                }
                break;
            }

            // Testing option. Prints all loaded accounts
            if (choice == 99){

                System.out.println(_accountList);
                //for (BankAccount_S2023_Group6 account: _accountList) {
                //    System.out.println(account);

                continue;
                //}
            }

            System.out.println("Choice not recognized. Please try again...");
            scanner.nextLine(); // Consume left over input
        }
    }

    static String MainMenu(){

        return """
                Menu
                ------------------------
                1. Register new bank account
                2. Log-in to existing bank account
                
                0. Exit
                """;
    }

    static String LoggedInMenu(){

        return """
                Menu
                ------------------------
                1. List Account Into
                2. Register Savings Account
                3. Register Checking Account
                4. Deposit into a checking or savings account
                5. Withdraw from a checking or savings account

                0. Log Out
                """;
    }

    static BankAccount_S2023_Group6 RegisterBankAccount(String firstName, String lastName){
        return new BankAccount_S2023_Group6(Extensions.GenAccountNumber(), firstName, lastName);
    }

    static String RegisterCheckingAccount(BankAccount_S2023_Group6 account){
        CheckingAccount_S2023_Group6 newAccount = new CheckingAccount_S2023_Group6(account.getBankAccountNumber(), account.getFirstName(), account.getLastName(), Extensions.GenAccountNumber(), 0);

        account.addCheckingAccount(newAccount);

        return newAccount.getCheckingAccountNumber();
    }

    static String RegisterSavingsAccount(BankAccount_S2023_Group6 account){
        SavingsAccount_S2023_Group6 newAccount = new SavingsAccount_S2023_Group6(account.getBankAccountNumber(), account.getFirstName(), account.getLastName(), Extensions.GenAccountNumber(), 0);

        account.addSavingsAccount(newAccount);

        return newAccount.getSavingsAccountNumber();
    }

    static void LoadBankAccount(ArrayList<BankAccount_S2023_Group6> accountList, BankAccount_S2023_Group6 account){
        accountList.add(account);
    }

    // Load bank accounts from file
    static ArrayList<BankAccount_S2023_Group6> LoadFromFile(File file, String password) throws FileNotFoundException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        ArrayList<BankAccount_S2023_Group6> accounts = new ArrayList<>();
        BankAccount_S2023_Group6 currentBankAccount = null;
        SavingsAccount_S2023_Group6 currentSavingsAccount = null;
        CheckingAccount_S2023_Group6 currentCheckingAccount = null;

        Scanner scanner = new Scanner(file);


        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            Extensions.Decrypt(line, Extensions.setKey(password));
        }

        //loop through the data file
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();

            // Check if the line contains bank account info
            if(line.startsWith("BankAccount")){
                String[] accountInfo = line.split("[=,\\[\\]]+");

                //extract info
                String accountNum = accountInfo[2];
                String firstName = accountInfo[4];
                String lastName = accountInfo[6];

                currentBankAccount = new BankAccount_S2023_Group6(accountNum.trim(), firstName.trim(), lastName.trim());
                accounts.add(currentBankAccount);
            }

            if (line.startsWith("Savings")){
                String[] accountInfo = line.split("[\\[\\]:; $]+");

                String accountNum = accountInfo[5];
                double accountBalance = Double.parseDouble(accountInfo[8]);

                //create savings account object
                currentSavingsAccount = new SavingsAccount_S2023_Group6(currentBankAccount.getBankAccountNumber(), currentBankAccount.getFirstName(), currentBankAccount.getLastName(), accountNum.trim(), accountBalance);
                currentBankAccount.addSavingsAccount(currentSavingsAccount);
            }

            if (line.startsWith("Checking")) {
                String[] accountInfo = line.split("[\\[\\]:; $]+");

                String accountNum = accountInfo[5];
                double accountBalance = Double.parseDouble(accountInfo[8]);

                //create checking account object
                currentCheckingAccount = new CheckingAccount_S2023_Group6(currentBankAccount.getBankAccountNumber(), currentBankAccount.getFirstName(), currentBankAccount.getLastName(), accountNum.trim(), accountBalance);
                currentBankAccount.addCheckingAccount(currentCheckingAccount);
            }
        }

        scanner.close();
        return accounts;
    }

    /*Our bank account application uses a bank account number to organize everything  
     * like user information and the many bank accounts under their name.  
     * The risk, in this case, is the bank account number isn't protected and  
     * all the attacker needs is the user's bank account number to access the user's information and accounts.
    */

    static ArrayList<String> GetBankAccountNums(ArrayList<BankAccount_S2023_Group6> accounts){
        ArrayList<String> accountNums = new ArrayList<>();

        for (BankAccount_S2023_Group6 account: accounts) {
            accountNums.add(account.getBankAccountNumber());
        }

        return accountNums;
    }

    /*The data file is stored in cleartext, it's very easy for an attacker to
    * read off this file, the file needs to be encrypted 
    */ 
    static String SaveData(ArrayList<BankAccount_S2023_Group6> accounts,String password) throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        File data = new File(System.getProperty("user.home") + File.separator + "Banking" + File.separator + "data.enc");
        File directory = new File(System.getProperty("user.home") + File.separator + "Banking");

        if (!directory.exists()) directory.mkdir();

        PrintWriter writer = new PrintWriter(data);
        for (BankAccount_S2023_Group6 account: accounts) {
            // Write account to file
            writer.println(Extensions.Encrypt(account.toString(), Extensions.setKey(password)));

            //write savings accounts
            SaveSavings(writer, account, password);

            //write checking accounts
            SaveChecking(writer, account, password);

        }
        writer.close();

        return "Data written to file: " + data.getAbsoluteFile();
    }

    static void SaveSavings(PrintWriter writer, BankAccount_S2023_Group6 account, String password) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
        if (account.getSavingsAccounts() != null){
            // write savings accounts to file
            for (SavingsAccount_S2023_Group6 savingsAccount: account.getSavingsAccounts()){
                writer.println(Extensions.Encrypt(savingsAccount.toString(), Extensions.setKey(password)));
            }
        }
    }

    static void SaveChecking(PrintWriter writer, BankAccount_S2023_Group6 account, String password) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
        if (account.getCheckingAccounts() != null){
            //write checking accounts to file
            for (CheckingAccount_S2023_Group6 checkingAccount: account.getCheckingAccounts()){
                writer.println(Extensions.Encrypt(checkingAccount.toString(), Extensions.setKey(password)));
            }
        }
    }

    static BankAccount_S2023_Group6 LogIn(String accountNum, ArrayList<BankAccount_S2023_Group6> accounts){
        for (BankAccount_S2023_Group6 account: accounts) {
            if (account.getBankAccountNumber().equals(accountNum))
                return account;
        }
        return null;
    }
}
