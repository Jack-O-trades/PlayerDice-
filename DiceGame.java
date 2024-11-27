import java.util.*;

public class DiceGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Dice Game!");
        System.out.print("Enter your name: ");
        String PlayerName = sc.nextLine();

        int balance = 150;  // Initial balance for the player 
        System.out.println(PlayerName + ", you have a balance of " + balance + " tokens.");
        
        // Game loop
        while (balance > 0) {
            System.out.println("\nYour current balance: " + balance);
            System.out.print("Place your bet between 1 to 6 : ");
            int betAmount = sc.nextInt();
            if (betAmount > balance) {
                System.out.println("You don't have enough balance to place this bet.");
                continue;
            }

            System.out.print("Guess the dice roll result (between 1 and 6): ");
            int Guess = sc.nextInt();
            if (Guess < 1 || Guess > 6) {
                System.out.println("Invalid guess!");
                System.out.println("Please enter between 1 to 6");
                continue;
            }

            // Roll the dice (random number between 1 and 6)
            int diceRoll = random.nextInt(6) + 1;
            System.out.println("The dice rolled: " + diceRoll);

            // Determine win or loss
            if (Guess == diceRoll) {
                balance += betAmount;
                System.out.println("Congratulations! You guessed correctly and won " + betAmount + " tokens.");
            } else {
                balance -= betAmount;
                System.out.println("Unfortunate fella ! You guessed wrong. You lost " + betAmount + " tokens.");
            }

            // Check if player has no balance left
            if (balance <= 0) {
                System.out.println("Game over! You have no balance left.");
                break;
            }

            // Ask if the player wants to continue
            System.out.print("Do you want to play again? (yes/no): ");
            sc.nextLine();  // consume newline
            String playAgain = sc.nextLine();
            if (playAgain.equalsIgnoreCase("no")) {
                System.out.println("Thanks for playing! Your final balance is " + balance + " tokens.");
                break;
            }
        }

        sc.close();
    }
}

