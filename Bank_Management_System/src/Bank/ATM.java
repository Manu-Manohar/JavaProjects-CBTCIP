package Bank;
import java.util.*;
public abstract class ATM
{
	protected List<BankAccount> accounts;
    protected Scanner scanner;
    protected List<String> transactionHistory;

    public ATM() {
        this.accounts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.transactionHistory = new ArrayList<>();
    }

    public abstract void displayMenu();

    public abstract boolean login();

    public void displayBalance(BankAccount account) {
        System.out.println("Your balance is: $" + account.getBalance());
    }

    public void deposit(BankAccount account, double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("$" + amount + " deposited successfully.");
        transactionHistory.add("Account Number: " + account.getAccountNumber() + ", Deposited $" + amount);
    }

    public void withdraw(BankAccount account, double amount) {
        if (amount > account.getBalance()) {
            System.out.println("Insufficient funds.");
        } else {
            account.setBalance(account.getBalance() - amount);
            System.out.println("$" + amount + " withdrawn successfully.");
            transactionHistory.add("Account Number: " + account.getAccountNumber() + ", Withdrawn $" + amount);
        }
    }

    public void transfer(BankAccount sender, BankAccount receiver, double amount) {
        if (amount > sender.getBalance()) {
            System.out.println("Insufficient funds.");
        } else {
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);
            System.out.println("$" + amount + " transferred successfully.");
            transactionHistory.add("Account Number: " + sender.getAccountNumber() + ", Transferred $" + amount + " to Account Number: " + receiver.getAccountNumber());
        }
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void exit() {
        System.out.println("Exiting the ATM. Thank you for using our services.");
        scanner.close();
        System.exit(0);
    }

}
