import java.util.Scanner;

public class ATM {
    static final int PREDEFINED_PIN = 9548;
    static int balance = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean accessGranted = false;

        // 3 attempts Verification using for loop
        for (int attempts = 1; attempts <= 3; attempts++) {
            System.out.print("Enter your PIN: ");
            int enteredPin = input.nextInt();

            if (enteredPin == PREDEFINED_PIN) {
                accessGranted = true;
                break;
            } else {
                System.out.println("Incorrect PIN. Attempt " + attempts + " of 3.");
            }
        }

        if (!accessGranted) {
            System.out.println("Account locked due to 3 failed attempts.");
            return;
        }

        // Menu 
        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = input.nextInt();
                    deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = input.nextInt();
                    withdraw(withdrawAmount);
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    continue;
            }

            if (choice == 4) break;
        }

        input.close();
    }

    // Deposit method
    public static void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public static void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    // Check balance method
    public static void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}