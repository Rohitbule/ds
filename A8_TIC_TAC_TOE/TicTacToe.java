import java.util.Scanner;

public class TicTacToe {

    // Display the game board
    public static void displayBoard(String[] board) {
        System.out.println("""
             %s | %s | %s
            ---|---|---
             %s | %s | %s
            ---|---|---
             %s | %s | %s
            """.formatted(
                board[0], board[1], board[2],
                board[3], board[4], board[5],
                board[6], board[7], board[8]
            ));
    }

    // Check for a win
    public static boolean checkWinner(String[] board, String player) {
        int[][] winCombinations = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] combo : winCombinations) {
            if (board[combo[0]].equals(player) &&
                board[combo[1]].equals(player) &&
                board[combo[2]].equals(player)) {
                return true;
            }
        }
        return false;
    }

    // Check for a draw
    public static boolean checkDraw(String[] board) {
        for (String cell : board) {
            if (cell.equals(" ")) {
                return false;
            }
        }
        return true;
    }

    // Main game loop
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        String[] board = {" ", " ", " ", " ", " ", " ", " ", " ", " "}; // Empty board
        String currentPlayer = "X"; // Player X goes first

        System.out.println("Welcome to Tic Tac Toe!");
        displayBoard(board);

        while (true) {
            try {
                // Player move
                System.out.print("Player " + currentPlayer + ", choose your position (1-9): ");
                int position = scanner.nextInt() - 1;

                if (position < 0 || position > 8 || !board[position].equals(" ")) {
                    System.out.println("Invalid move. Try again.");
                    continue;
                }

                // Update board
                board[position] = currentPlayer;
                displayBoard(board);

                // Check for winner or draw
                if (checkWinner(board, currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (checkDraw(board)) {
                    System.out.println("It's a draw!");
                    break;
                }

                // Switch player
                currentPlayer = currentPlayer.equals("X") ? "O" : "X";

            } catch (Exception e) {
                System.out.println("Please enter a valid number between 1 and 9.");
                scanner.next(); // Clear invalid input
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        playGame();
    }
}
