  import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Main menu");
            System.out.println("1) Guess the Number");
            System.out.println("2) Quiz Game");
            System.out.println("3) Adjective story");
            System.out.println("4) BankApp");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> new GuessNumber(scanner).run();
                case "2" -> new QuizGame(scanner).run();
                case "3" -> new AdjectiveStory(scanner).run();
                case "4" -> new BankApp(scanner).run();
                case "0" -> {
                    System.out.println("Bye Bye dude");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try 0-4.");
            }
        }
    }
}
