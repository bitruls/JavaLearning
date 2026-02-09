import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private final Random random = new Random();
    private final Scanner scanner;

    public GuessNumber(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        int secret = random.nextInt(10) +1;
        int guess = -1;
        int attempts = 0;

        System.out.println("Guess a number between 1-10");

        while (guess != secret) {
            System.out.print("your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a whole number.");
                scanner.nextLine();
                continue;
            }
            guess = scanner.nextInt();
            scanner.nextLine();
            attempts++;

            if (guess < secret) {
                System.out.println("to low");
            } else if (guess > secret) {
                System.out.println("to high");
            } else {
                System.out.println("correct, you needed " + attempts + " attempts");
            }
        }
    }
}