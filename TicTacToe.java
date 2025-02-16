import java.util.*;

public class TicTacToe {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }

    private void play() {
        initializeBoard();
        printBoard();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Player " + currentPlayer + "'s turn.");
            System.out.print("Enter row (1-3): ");
            int row = sc.nextInt() - 1;
            System.out.print("Enter column (1-3): ");
            int col = sc.nextInt() - 1;

            if (isValidMove(row, col)) {
                makeMove(row, col);
                printBoard();

                if (isWinner()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (isBoardFull()) {
                    System.out.println("It's a tie!");
                    break;
                }

                switchPlayer();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        sc.close();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void printBoard() {
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    private boolean isWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}