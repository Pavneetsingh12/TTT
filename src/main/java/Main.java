
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    char[][] board = new char[3][3];
    // Initializing the board
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        board[row][col] = ' ';
      }
    }
    char player = 'X';
    boolean gameOver = false;
    Scanner scanner = new Scanner(System.in);

    // Game loop
    while (!gameOver) {
      printBoard(board);
      System.out.println("Player " + player + " enter: ");
      int row = scanner.nextInt();
      int col = scanner.nextInt();
      // Do only if the position is empty
      if (board[row][col] == ' ') {
        // Place the player's symbol
        board[row][col] = player;
        gameOver = haveWon(board, player);
        if (gameOver) {
          System.out.println("Player " + player + " has won!");
        } else {
          // Switch players
          if (player == 'X') {
            player = 'O';
          } else {
            player = 'X';
          }
        }
      } else {
        System.out.println("POSITION IS OCCUPIED");
      }
    }
    printBoard(board);
  }

  public static boolean haveWon(char[][] board, char player) {
    // Check rows
    for (int row = 0; row < board.length; row++) {
      if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
        return true;
      }
    }
    // Check columns
    for (int col = 0; col < board[0].length; col++) {
      if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
        return true;
      }
    }
    // Check diagonals
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player ) {
      return true;
    }
    if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
      return true;
    }
    return false;
  }

  public static void printBoard(char[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        System.out.print(board[row][col] + "|");
      }
      System.out.println();
    }
  }
}
