
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int rounds = 0;

        while (true) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean won = false;

            while (attempts < 10) {
                System.out.print("Guess a number between 1 and 100: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You found the number in " + attempts + " attempts.");
                    won = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!won) {
                System.out.println("Sorry, you didn't find the number. It was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if (playAgain.equalsIgnoreCase("no")) {
                break;
            }

            rounds++;
            if (won) {
                score++;
            }
        }

        System.out.println("Thanks for playing! Your final score is " + score + " out of " + rounds + " rounds.");
    }
};