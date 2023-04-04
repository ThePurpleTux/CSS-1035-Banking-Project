package bankAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

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
                    System.out.println("Register new savings account\n");
                    System.out.println("-----------------------------\n");

                    System.out.println("Creating new savings account for account number: " + currentAccount.getBankAccountNumber());
                    String savingsAccountNum = RegisterSavingsAccount(currentAccount);
                    System.out.println("Savings account created with account number: " + savingsAccountNum + " for Bank Account " + currentAccount.getBankAccountNumber());
                }

                if (choice == 3){
                    System.out.println("Register new checking account\n");
                    System.out.println("-----------------------------\n");
                    System.out.println("Please enter your bank account number: ");

                    System.out.println("Creating new checking account for account number: " + currentAccount.getBankAccountNumber());
                    String checkingAccountNum = RegisterCheckingAccount(currentAccount);
                    System.out.println("Checking account created with account number: " + checkingAccountNum + " for Bank Account " + currentAccount.getBankAccountNumber());
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
                    System.out.println(SaveData(_accountList));
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

    static ArrayList<BankAccount_S2023_Group6> LoadFromFile(File file) throws FileNotFoundException {
        ArrayList<BankAccount_S2023_Group6> accountList = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        Pattern pattern = Pattern.compile("\\[(.*?)]");

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()){
                String[] parts = matcher.group(1).split(", ");
                String bankAccountNumber = (parts[0].split("= ")[1]).trim();
                String firstName = (parts[1].split("= ")[1]).trim();
                String lastName = (parts[2].split("= ")[1]).trim();

                BankAccount_S2023_Group6 bankAccount = new BankAccount_S2023_Group6(bankAccountNumber, firstName, lastName);
                accountList.add(bankAccount);
            }
        }
        scanner.close();
        return accountList;
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
    static String SaveData(ArrayList<BankAccount_S2023_Group6> accounts) throws IOException {
        File data = new File(System.getProperty("user.home") + File.separator + "Banking" + File.separator + "data.dat");
        File directory = new File(System.getProperty("user.home") + File.separator + "Banking");

        if (!directory.exists()) directory.mkdir();

        PrintWriter writer = new PrintWriter(data);
        for (BankAccount_S2023_Group6 account: accounts) {
            // Write account to file
            writer.println(account.toString());

            if (account.getSavingsAccounts() != null){
                ArrayList<SavingsAccount_S2023_Group6> savings = account.getSavingsAccounts();

                // write savings accounts to file
                for (SavingsAccount_S2023_Group6 savingsAccount: savings){
                    writer.println(savingsAccount);
                }
            }

        }
        writer.close();

        return "Data written to file: " + data.getAbsoluteFile();
    }

    static BankAccount_S2023_Group6 LogIn(String accountNum, ArrayList<BankAccount_S2023_Group6> accounts){
        for (BankAccount_S2023_Group6 account: accounts) {
            if (account.getBankAccountNumber().equals(accountNum))
                return account;
        }
        return null;
    }
}
