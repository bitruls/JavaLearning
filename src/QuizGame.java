import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;

public class QuizGame {
    private final Scanner scanner;

    public QuizGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("This is a math quiz. For the program to work, answer with whole numbers only.");
        startGame();

    }

    private  Map<String, Integer> getQuestionsWithAnswers() {
        Map<String, Integer> qa = new LinkedHashMap<>();
        qa.put("What is 11*11? ", 121);
        qa.put("What is 5*8? ", 40);
        qa.put("What is 9/9? ", 1);
        return qa;
    }

    private void startGame() {
        Map<String, Integer> qa = getQuestionsWithAnswers();

        int score = 0;

        for (Map.Entry<String, Integer> entry : qa.entrySet()) {
            String question = entry.getKey();
            int correctAnswer = entry.getValue();

            System.out.println("Question: " + question);

            int ans;
            while (true) {
                System.out.println("Your answer: ");
                String input = scanner.nextLine();
                try {
                    ans = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Enter a whole number");
                }
            }
            if (ans == correctAnswer) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("wrong, correct answer was: " + correctAnswer);
            }
        }
        System.out.println("Quiz finished! Score: " + score + "/" + qa.size());

    }
}
