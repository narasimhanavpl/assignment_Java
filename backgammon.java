import java.util.Random;
import java.util.Scanner;

public class Backgammon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Backgammon!");

        // Initialize board
        displayInitialBoard();

        // Get player names
        System.out.print("Enter player 1's name: ");
        String player1 = scanner.nextLine();
        System.out.print("Enter player 2's name: ");
        String player2 = scanner.nextLine();

        String currentPlayer = player1;
        boolean gameRunning = true;

        // Game loop
        while (gameRunning) {
            System.out.printf("%s, it's your turn. Enter 'roll' or 'quit': ", currentPlayer);
            String command = scanner.nextLine().toLowerCase();

            if ("roll".equals(command)) {
                int[] diceRoll = rollDice();
                System.out.printf("%s rolled a %d and a %d.%n", currentPlayer, diceRoll[0], diceRoll[1]);
                currentPlayer = switchPlayer(currentPlayer, player1, player2);
            } else if ("quit".equals(command)) {
                gameRunning = false;
            } else {
                System.out.println("Invalid command. Please enter 'roll' or 'quit'.");
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static void displayInitialBoard() {
        System.out.println("Here's the initial Backgammon board:");

        // Replace this with actual board representation
        System.out.println("________________________");
        System.out.println("|   |   |   |   |   |   |");
        System.out.println("|   |   |   |   |   |   |");
        System.out.println("|   |   |   |   |   |   |");
        System.out.println("|___|___|___|___|___|___|");
    }

    private static int[] rollDice() {
        Random random = new Random();
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        return new int[]{die1, die2};
    }

    private static String switchPlayer(String currentPlayer, String player1, String player2) {
        return currentPlayer.equals(player1) ? player2 : player1;
    }
}
