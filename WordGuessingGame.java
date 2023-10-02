import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {

    private static String[] words = {"java", "programming", "computer", "algorithm", "software"};

    public static void main(String[] args) {
        Random random = new Random();
        String chosenWord = words[random.nextInt(words.length)];
        char[] guessedLetters = new char[chosenWord.length()];

        // Initialize guessedLetters array with dashes
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '-';
        }

        int attempts = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("Try to guess the word.");

        while (true) {
            System.out.println("Current progress: " + String.valueOf(guessedLetters));
            System.out.print("Enter a letter or the whole word: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals(chosenWord)) {
                System.out.println("Congratulations! You guessed the word: " + chosenWord);
                break;
            }

            if (userInput.length() == 1) {
                char guess = userInput.charAt(0);
                boolean correctGuess = false;

                for (int i = 0; i < chosenWord.length(); i++) {
                    if (chosenWord.charAt(i) == guess) {
                        guessedLetters[i] = guess;
                        correctGuess = true;
                    }
                }

                if (!correctGuess) {
                    attempts++;
                    System.out.println("Incorrect guess. Attempts left: " + (5 - attempts));
                }

                if (attempts >= 5) {
                    System.out.println("You've used all your attempts. The word was: " + chosenWord);
                    break;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid letter or the whole word.");
            }
        }

        scanner.close();
    }
}
