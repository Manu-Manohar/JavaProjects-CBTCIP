package Bank;
import java.util.*;

public class UserATM extends ATM {
    private BankAccount currentAccount;

    public UserATM(List<BankAccount> accounts) {
        super();
        this.accounts = accounts;
    }

    @Override
    public void displayMenu() {
        boolean loggedIn = login();
        if (!loggedIn) {
            System.out.println("Login failed. Exiting...");
            exit();
        }
        int choice;
        do {
            System.out.println("\n----------------- User Panel -----------------");
            System.out.println("|  1. Withdraw                                |");
            System.out.println("|  2. Transfer                                |");
            System.out.println("|  3. Check Balance                           |");
            System.out.println("|  4. Deposit                                 |");
            System.out.println("|  5. Transaction History                     |");
            System.out.println("|  6. Logout                                  |");
            System.out.println("-----------------------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(currentAccount, withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter receiver's account number: ");
                    String receiverAccountNumber = scanner.next();
                    System.out.print("Enter amount to transfer: $");
                    double transferAmount = scanner.nextDouble();
                    BankAccount receiver = findAccount(receiverAccountNumber);
                    if (receiver != null) 
                    {
                        transfer(currentAccount, receiver, transferAmount);
                    }
                    else
                    {
                        System.out.println("Receiver's account not found.");
                    }
                    break;
                case 3:
                    displayBalance(currentAccount);
                    break;
                case 4:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    deposit(currentAccount, depositAmount);
                    break;
                case 5:
                    displayTransactionHistory();
                    break;
                case 6:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);
    }

    @Override
    public boolean login() {
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();
        for (BankAccount account : accounts)
        {
            if (account.getAccountNumber().equals(accountNumber) && account.getPin() == pin) 
            {
                System.out.println("Login successful.");
                currentAccount = account;
                return true;
            }
        }
        System.out.println("Invalid account number or PIN.");
        return false;
    }

    public BankAccount findAccount(String accountNumber)
    {
        for (BankAccount account : accounts) 
        {
            if (account.getAccountNumber().equals(accountNumber))
            {
                return account;
            }
        }
        return null;
    }
}
