package task2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Bank{
    private double balance; 
    private String username; 
    private String password; 
    private List<String> transactionHistory; 
    static int loginTries;

    public Bank(double initialBalance, String username, String password) {
        balance = initialBalance;
        this.username = username;
        this.password = password;
        transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful! "); 
        transactionHistory.add("Deposit:\t " + amount);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Withdrawal failed. Insufficient balance. ");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! ");
            transactionHistory.add("Withdrawal:\t " + amount);
        }
    }

    public void checkBalance() {
        System.out.println("Current balance:" + balance);
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
     public void menu() {
    	 System.out.println("1. Deposit Amount.");
         System.out.println("2. Withdraw Amount.");
         System.out.println("3. Check Balance.");
         System.out.println("4. View Transaction History.");
         System.out.println("5. Exit.");
         System.out.print("Enter choice: ");
     }

    public void exit() {
        System.out.println("Goodbye! Thankyou for using this service! :) ");
        System.exit(0);
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public static void main(String[] args) {
        Bank bankApp = new Bank(0.0, "me", "Pass777"); 
        Scanner input = new Scanner(System.in);
        
        System.out.println("\t-------BANKING APPLICATION------");

        while (true) {
            System.out.print("Enter username: ");
            String username = input.next();
            System.out.print("Enter password: ");
            String password = input.next();

            if (bankApp.authenticate(username, password)) {
                System.out.println("\nLogin successful!");
                loginTries =0;

                while (true) {
                	System.out.println();
                	bankApp.menu();
                    int choice = input.nextInt();
                	System.out.println();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = input.nextDouble();
                            bankApp.deposit(depositAmount);
                            break;
                        case 2:
                            System.out.print("Enter amount to  withdraw: ");
                            double withdrawalAmount = input.nextDouble();
                            bankApp.withdraw(withdrawalAmount);
                            break;
                        case 3:
                            bankApp.checkBalance();
                            break;
                        case 4:
                            bankApp.viewTransactionHistory();
                            break;
                        case 5:
                            bankApp.exit();
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }  else {
                loginTries++;
                if (loginTries >= 3) {
                    System.out.println("Too many attempts. Cannot login. \nExiting Program...");
                    System.exit(0); 
                } else {
                    System.out.println("Invalid username or password. Please try again.\n");
                }
            }
        }
    }
}
     