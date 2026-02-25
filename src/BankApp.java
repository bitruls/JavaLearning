import java.util.Scanner;

public class BankApp {
    private int balance = 0;
    private final Scanner scanner;

    public BankApp(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run(){
        while (true) {
            printMenu();

            String input = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
                continue;
            }

            switch (choice) {
                case 1 -> depositFlow();
                case 2 -> withdrawFlow();
                case 3 -> showBalance();
                case 0 -> {
                    System.out.println("Leaving BankApp");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void printMenu(){
        System.out.println("Menu\n1)deposit\n2)withdraw\n3)balance\n0)exit");
        System.out.print("Choose: ");
    }

    private void deposit(int amount){
        balance += amount;
    }

    private void withdraw(int amount) {
        if (balance >= amount){
            balance -=amount;
            System.out.println("You withdrew: $" + amount);
        } else {
            System.out.println("not enough funds!");
        }
    }

    private void showBalance() {
        System.out.println("Balance: $"+balance );
    }

    private void depositFlow() {
        System.out.print("Enter the amount: ");
        String input = scanner.nextLine();
        int amount;
        try {
            amount = Integer.parseInt(input);
            if (amount <=0) {
                System.out.println("Amount must be greater than 0");
                return;
            }
        } catch (NumberFormatException e){
            System.out.println("Please enter a whole number.");
            return;
        }
        deposit(amount);
        System.out.println("You deposited: $" + amount);
        showBalance();
    }

    private void withdrawFlow() {
        System.out.print("Enter the amount: ");
        String input = scanner.nextLine();
        int amount;
        try {
            amount = Integer.parseInt(input);
            if (amount <=0) {
                System.out.println("Amount must be greater than 0");
                return;
            }
        } catch (NumberFormatException e){
            System.out.println("Please enter a whole number.");
            return;
        }
        withdraw(amount);
        System.out.println("You withdrew: $" + amount);
        showBalance();
    }
}
