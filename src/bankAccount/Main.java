package bankAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Main runner for the app
public class Main {
    public static void main(String[] args){
        ArrayList<BankAccount_S2023_Group6> _accountList = new ArrayList<BankAccount_S2023_Group6>();
        BankAccount_S2023_Group6 currentAccount = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("CSS_1035_Banking_App");

        while (true){

            try{
                Thread.sleep(500);
            }catch (InterruptedException e){

            }

            System.out.println(Menu());

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
                loadBankAccount(_accountList, account);
                System.out.println(String.format("Account Created. \nAccount Number: %s", account.getBankAccountNumber()));

                continue;
            }

            if (choice == 2){
                System.out.println("Register new savings account\n");
                System.out.println("-----------------------------\n");
                System.out.println("Please enter your bank account number: ");

                scanner.nextLine(); //consume leftover input
                String accountNum = scanner.nextLine();
                if (!GetBankAccountNums(_accountList).contains(accountNum)){
                    System.out.println("Account not found.");
                    continue;
                }

                for (BankAccount_S2023_Group6 account : _accountList) {
                    if (account.getBankAccountNumber().equals(accountNum)){
                        currentAccount = account;
                        System.out.println(currentAccount.getBankAccountNumber());
                    }
                }
                System.out.println(String.format("Creating new savings account for account number: %s", currentAccount.getBankAccountNumber()));
                String savingsAccountNum = RegisterSavingsAccount(currentAccount);
                System.out.println(String.format("Savings accocunt created with account number: %s for Bank Account %s",savingsAccountNum, currentAccount.getBankAccountNumber()));

                continue;
            }

            if (choice == 3){
                System.out.println("Register new checking account\n");
                System.out.println("-----------------------------\n");
                System.out.println("Please enter your bank account number: ");

                scanner.nextLine(); //consume leftover input

                String accountNum = scanner.nextLine();
                if (!GetBankAccountNums(_accountList).contains(accountNum)){
                    System.out.println("Account not found.");
                    continue;
                }

                for (BankAccount_S2023_Group6 account : _accountList) {
                    if (account.getBankAccountNumber().equals(accountNum)){
                        currentAccount = account;
                        System.out.println(currentAccount.getBankAccountNumber());
                    }
                }
                System.out.println(String.format("Creating new checking account for account number: %s", currentAccount.getBankAccountNumber()));
                String checkingAccountNum = RegisterCheckingAccount(currentAccount);
                System.out.println(String.format("Checking account created with account number: %s for Bank Account %s",checkingAccountNum, currentAccount.getBankAccountNumber()));

                continue;
            }

            if (choice == 4){
                System.out.println("\n\nThanks for banking with us!");
                System.out.println("\nSaving Data...");

                try{
                    System.out.println(SaveData(_accountList));
                } catch (IOException e){
                    System.out.println(e);
                }finally {
                    scanner.close();
                    break;
                }
            }

            System.out.println("Choice not recognized. Please try again...");
        }

    }

    static String Menu(){
        StringBuilder banner = new StringBuilder();
        banner.append("\n\n\n\n");
        banner.append("Menu\n");
        banner.append("------------------------\n");
        banner.append("1. Register new bank account\n");
        banner.append("2. Register new savings account\n");
        banner.append("3. Register new checking account\n\n");
        banner.append("4. Exit\n\n");
        banner.append("Please enter a number: ");

        return banner.toString();
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

    static ArrayList<BankAccount_S2023_Group6> loadBankAccount(ArrayList<BankAccount_S2023_Group6> accountList, BankAccount_S2023_Group6 account){
        accountList.add(account);
        return accountList;
    }

    static ArrayList<BankAccount_S2023_Group6> loadFromFile(File file, ArrayList<BankAccount_S2023_Group6> accountList) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()){
                String[] parts = matcher.group(1).split(", ");
            }
        }
    }

    static ArrayList<String> GetBankAccountNums(ArrayList<BankAccount_S2023_Group6> accounts){
        ArrayList<String> accountNums = new ArrayList<String>();

        for (BankAccount_S2023_Group6 account: accounts) {
            accountNums.add(account.getBankAccountNumber());
        }

        return accountNums;
    }

    static String SaveData(ArrayList<BankAccount_S2023_Group6> accounts) throws IOException {
        Charset utf8 = StandardCharsets.UTF_8;
        List<String> data = null;
        File outfile = new File(System.getProperty("user.home") + File.separator + "Banking" + File.separator + "data.dat");
        File directory = new File(System.getProperty("user.home") + File.separator + "Banking");

        if (!directory.exists()){
            directory.mkdir();
        }

        PrintWriter writer = new PrintWriter(outfile);
        for (BankAccount_S2023_Group6 account: accounts) {
            writer.println(account.toString());
        }
        writer.close();

        return "Data written to file: " + outfile.getAbsoluteFile();
    }
}
