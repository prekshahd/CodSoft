import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int MaxAttempts = 15; 
        int totalscore = 0;   
        boolean playagain= true;

        System.out.println("Welcome to the Number Guessing Game");

        while (playagain) 
        {
            int numbertoguess = rd.nextInt(100) + 1; 
            int AttemptsLeft = MaxAttempts; 
            boolean guessedcorrectly = false;

            System.out.println("\nI'm thinking of a number between 1 and 100.");
            System.out.println("You have " + MaxAttempts + " attempts to guess it");

            while (AttemptsLeft > 0) 
            {
                int currentAttempt = MaxAttempts - AttemptsLeft + 1;
                System.out.print("\nAttempt " + currentAttempt + ":");
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                if (guess == numbertoguess) 
                {
                    System.out.println("Correct! You guessed the number in attempt " + currentAttempt + "!");
                    ++totalscore;
                    guessedcorrectly = true;
                    break;
                }

                if (guess < numbertoguess) 
                {
                    System.out.println("Too low");
                } 
                else 
                {
                    System.out.println("Too high");
                }

                --AttemptsLeft;
                System.out.println("Attempts left: " + AttemptsLeft);
            }

            if (!guessedcorrectly) 
            {
                System.out.println("Out of attempts! The correct number was: " + numbertoguess);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String answer = sc.next();
            playagain = answer.equalsIgnoreCase("yes");
        }

        System.out.println("\n Game over! Your final score: " + totalscore);
        System.out.println("Thanks for playing");
        sc.close();
    }
}
