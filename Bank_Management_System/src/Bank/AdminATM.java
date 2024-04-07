package Bank;
import java.util.*;
public class AdminATM extends ATM {
    public AdminATM(List<BankAccount> accounts) {
        super();
        this.accounts = accounts;
    }

    @Override
    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n---------------- Admin Panel -----------------");
            System.out.println("|  1. Create Bank Account                     |");
            System.out.println("|  2. Check Balance                           |");
            System.out.println("|  3. Transaction History                     |");
            System.out.println("|  4. Logout                                  |");
            System.out.println("-----------------------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createBankAccount();
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    BankAccount account = findAccount(accountNumber);
                    if (account != null) {
                        displayBalance(account);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    displayTransactionHistory();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }

    @Override
    public boolean login() {
        return true; // No login required for admin panel in this implementation
    }

    public void createBankAccount() {
        Random rand = new Random();
        String accountNumber = "";
        int pin = 1000 + rand.nextInt(9000); // Random 4-digit PIN number
        for (int i = 0; i < 12; i++) {
            accountNumber += rand.nextInt(10); // Random 16-digit account number
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your firstname:");
        String firstName = scanner.nextLine();
        System.out.println("Enter your lastname:");
        String lastName = scanner.nextLine();
        System.out.println("Enter your address:");
        String address = scanner.nextLine();
        System.out.println("Enter your contact:");
        String contact = scanner.nextLine();
        System.out.println("Enter your gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your account type:");
        String accountType = scanner.nextLine();
        
        BankAccount newAccount = new BankAccount(accountNumber, pin, 1000.0,firstName,lastName,address,contact,gender,email,accountType);
        accounts.add(newAccount);
        System.out.println("Bank account created successfully.");

        System.out.println("Account Number: " + accountNumber);
        System.out.println("PIN: " + pin);
        System.out.println(" ");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Address: " + address);
        System.out.println("Contact: " + contact);
        System.out.println("Gender: " + gender);
        System.out.println("Email: " + email);
        System.out.println("Account Type: " + accountType);

        
        // After creating the bank account, check if the user wants to display the user panel
        System.out.println("\nWould you like to:");
        System.out.println("1. Display User Panel");
        System.out.println("2. Return to Admin Panel");
        System.out.print("Enter your choice: ");
        int userChoice = scanner.nextInt();
        if (userChoice == 1) {
            UserATM userATM = new UserATM(accounts);
            userATM.displayMenu();
        }
        scanner.close();
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
