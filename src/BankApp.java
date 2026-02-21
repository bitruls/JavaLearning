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
                case 1 -> actions(choice);
                case 2 -> actions(choice);
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
        System.out.println("You deposited: $" + amount);
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

    private void actions(int choice) {
        System.out.println("Enter the amount:");
        String input = scanner.nextLine();
        int amount;
        try {
            amount = Integer.parseInt(input);

            if (amount <= 0) {
                System.out.println("Amount must be greater than 0.");
                return;
            }
        } catch (NumberFormatException e){
            System.out.println("please enter a whole number.");
            return;
        }

        if (choice == 1) {
            deposit(amount);
            System.out.print("Your balance: ");
            showBalance();
        }else if (choice == 2) {
            withdraw(amount);
            System.out.print("Your balance: ");
            showBalance();
        } else {
            System.out.println("something went wrong in the action method");
        }
    }
}
