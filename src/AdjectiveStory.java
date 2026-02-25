import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class AdjectiveStory {
    private final Scanner scanner;

    public AdjectiveStory (Scanner scanner) {
        this.scanner = scanner;

    }

    public void run() {
        System.out.println("This is an Adjective story, where the adjectives you insert will be added to a premade story.");

        int wordCount;
        while (true) {
            System.out.println("Please tell me how many words you will like to insert (1-3 words)");
            String input = scanner.nextLine();
            try {
                wordCount = Integer.parseInt(input);
                if (wordCount >= 1 && wordCount <= 3) {
                    break;
                } else {
                    System.out.println("---------------------------------------");
                    System.out.println("Please enter a whole number between 1-3");
                    System.out.println("---------------------------------------");
                }
            } catch (NumberFormatException e) {
                System.out.println("-----------------------------");
                System.out.println("please enter a whole number!");
                System.out.println("-----------------------------");
            }
        }

        Story(adjectives(wordCount));
    }

    private List<String> adjectives(int wordCount) {
        List<String> words = new ArrayList<>();
        for (int i = 0; i < wordCount; i++) {
            System.out.println("Insert an Adjective:");
            String word = scanner.nextLine().trim();
            words.add(word);
        }
        return words;
    }

    private void Story (List<String> wordsList) {
        String fullStory = "";
        List<String> rawStory = new ArrayList<>();
        rawStory.add("I am ");
        rawStory.add(". And you are ");
        rawStory.add(". That makes us ");

        int i = 0;
        for (String s : wordsList) {
            fullStory += rawStory.get(i) + s;
            i ++;
        }
        System.out.println("Here is your Adjective story:");
        System.out.println(fullStory);
    }

}


