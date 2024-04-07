package Bank;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();
        UserATM userATM = new UserATM(accounts);
        AdminATM adminATM = new AdminATM(accounts);
        
        System.out.println("Welcome to the ATM.");
        int choice;
        do {
            System.out.println("\n------------------ Main Menu -----------------");
            System.out.println("|  1. User Panel                              |");
            System.out.println("|  2. Admin Panel                             |");
            System.out.println("|  3. Exit                                    |");
            System.out.println("-----------------------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    userATM.displayMenu();
                    break;
                case 2:
                    adminATM.displayMenu();
                    break;
                case 3:
                    System.out.println("Exiting the ATM. Thank you for using our services.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);
        
        scanner.close();
    }
}