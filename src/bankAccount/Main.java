package bankAccount;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

            StringBuilder banner = new StringBuilder();
            banner.append("\n\n\n\n");
            banner.append("Menu\n");
            banner.append("------------------------\n");
            banner.append("1. Register new bank account\n");
            banner.append("2. Register new savings account\n");
            banner.append("3. Register new checking account\n\n");
            banner.append("4. Exit\n\n");
            banner.append("Please enter a number: ");

            System.out.println(banner.toString());

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
                break;
            }

            System.out.println("Choice not recognized. Please try again...");
        }

    }

    static BankAccount_S2023_Group6 RegisterBankAccount(String firstName, String lastName){
        return new BankAccount_S2023_Group6(GenAccountNumber(), firstName, lastName);
    }

    static String RegisterCheckingAccount(BankAccount_S2023_Group6 account){
        CheckingAccount_S2023_Group6 newAccount = new CheckingAccount_S2023_Group6(account.getBankAccountNumber(), account.getFirstName(), account.getLastName(), GenAccountNumber(), 0);

        account.addCheckingAccount(newAccount);

        return newAccount.getCheckingAccountNumber();
    }

    static String RegisterSavingsAccount(BankAccount_S2023_Group6 account){
        SavingsAccount_S2023_Group6 newAccount = new SavingsAccount_S2023_Group6(account.getBankAccountNumber(), account.getFirstName(), account.getLastName(), GenAccountNumber(), 0);

        account.addSavingsAccount(newAccount);

        return newAccount.getSavingsAccountNumber();
    }

    static ArrayList<BankAccount_S2023_Group6> loadBankAccount(ArrayList<BankAccount_S2023_Group6> accountList, BankAccount_S2023_Group6 account){
        accountList.add(account);
        return accountList;
    }

    static ArrayList<String> GetBankAccountNums(ArrayList<BankAccount_S2023_Group6> accounts){
        ArrayList<String> accountNums = new ArrayList<String>();

        for (BankAccount_S2023_Group6 account: accounts) {
            accountNums.add(account.getBankAccountNumber());
        }

        return accountNums;
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
}
