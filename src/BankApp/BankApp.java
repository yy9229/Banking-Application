package BankApp;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = null;

        while (true) {
            System.out.println("\n=== Banking Application ===");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Exit");
            System.out.print("Select Option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Select Bank: 1. Nationalized 2. Cooperative");
                    int bankChoice = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Bank Name: ");
                    String bankName = sc.nextLine();
                    System.out.print("Enter Branch Name: ");
                    String branchName = sc.nextLine();

                    if (bankChoice == 1)
                        bank = new NationalizedBank(bankName, branchName);
                    else
                        bank = new CooperativeBank(bankName, branchName);

                    System.out.println("Select Account Type: 1. Savings 2. Current 3. Loan");
                    int accType = sc.nextInt(); sc.nextLine();

                    System.out.print("Enter Holder Name: ");
                    String holder = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double initBalance = sc.nextDouble(); sc.nextLine();

                    String accNo = "ACC" + ((int)(Math.random() * 1000) + 100);
                    Account acc = null;

                    if (accType == 1)
                        acc = new SavingsAccount(accNo, holder, initBalance);
                    else if (accType == 2)
                        acc = new CurrentAccount(accNo, holder, initBalance);
                    else
                        acc = new LoanAccount(accNo, holder, initBalance);

                    bank.openAccount(acc);
                    break;

                case 2:
                    if (bank == null) {
                        System.out.println("No bank initialized. Open an account first.");
                        break;
                    }
                    System.out.print("Enter Account Number: ");
                    String depAccNo = sc.nextLine();
                    Account found = bank.findAccount(depAccNo);
                    if (found != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        double amt = sc.nextDouble(); sc.nextLine();
                        found.deposit(amt);
                        System.out.println("Updated Balance: ₹" + found.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.println("Thank you. Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Option.");
            }
        }
    }
}
