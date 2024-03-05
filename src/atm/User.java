package atm;

public class User {
	private String UserID;
	private String UserPIN;
	private double accountBalance;

    public User(String userID, String userPIN, double accountBalance) {
        this.UserID = userID;
        this.UserPIN = userPIN;
        this.accountBalance = accountBalance;
    }

    public String getUserID() {
        return UserID;
    }

    public String getUserPIN() {
        return UserPIN;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposit successful. New balance: $" + accountBalance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + accountBalance);
        } else if (amount > accountBalance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

