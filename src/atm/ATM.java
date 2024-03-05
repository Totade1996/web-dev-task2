package atm;

import java.util.*;


public class ATM {
	   Scanner scanner = new Scanner(System.in);
    private Map<String, User> users;
    private User currentUser;

    public ATM() {
        users = new HashMap<>();
        // Add some sample users for testing
        users.put("user123", new User("user123", "1234", 1000.0));
        // Add more users as needed
    }

    public void start() {
        authenticateUser();
        displayMenu();
        performOperations();
    }

    private void authenticateUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String userID = scanner.next();
        System.out.print("Enter PIN: ");
        String userPIN = scanner.next();

        if (users.containsKey(userID) && users.get(userID).getUserPIN().equals(userPIN)) {
            currentUser = users.get(userID);
            System.out.println("Authentication successful. Welcome, " + currentUser.getUserID() + "!");
        } else {
            System.out.println("Invalid credentials. Please try again.");
            authenticateUser();
        }
    }

    private void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    private void performOperations() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("Current Balance: $" + currentUser.getAccountBalance());
    }

    private void depositMoney() {
        System.out.print("Enter deposit amount: $");
        
		double amount = scanner.nextDouble();
        currentUser.deposit(amount);
    }

    private void withdrawMoney() {
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();
        currentUser.withdraw(amount);
    }
}