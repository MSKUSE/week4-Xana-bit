import java.util.Scanner;
/**
 * A simple Tic-Tac-Toe game implementation in Java.
 */
public class TicTacToe {

	public static void main(String[] args) {
		// Initialize the game board and scanner
		Scanner reader = new Scanner(System.in);
		char[][] board = {
				{' ', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', ' '}
		};
		printBoard(board);
		int validMoves = 0;
		boolean gameEnded = false;
		int player = 0;

		while (!gameEnded) {
			System.out.println("Player " + (player + 1) + " enter a row number: ");
			int row = reader.nextInt() - 1;
			System.out.println("Player " + (player + 1) + " enter a column number: ");
			int col = reader.nextInt() - 1;

			if (isValid(row, col) && board[row][col] == ' ') {
				board[row][col] = player == 0 ? 'X' : 'O';
				printBoard(board);
				player = ++player % 2;
				validMoves++;
			} else {
				System.out.println("Please provide valid inputs!!!");
			}
			gameEnded = validMoves == 9 || checkBoard(board, row, col);
		}
		reader.close();
	}

	/**
	 * Checks if the current player has won the game.
	 *
	 * @param board The game board.
	 * @param row The row of the last move.
	 * @param col The column of the last move.
	 * @return True if the current player has won, false otherwise.
	 */
	public static boolean checkBoard(char[][] board, int row, int col) {
		// TODO: Implement the logic to check if the current player has won
		char symbol = board[row][col];
		boolean win = true;

		for (int i = 0; i < 3; i++) {
			if (board[row][i] != symbol) {
				win = false;
				break;
			}
		}
		if (win) {
			return true;
		}

		win = true;
		for (int i = 0; i < 3; i++) {
			if (board[i][col] != symbol) {
				win = false;
				break;
			}
		}
		if (win) {
			return true;
		}

		if (row == col) {
			win = true;
			for (int i = 0; i < 3; i++) {
				if (board[i][i] != symbol) {
					win = false;
					break;
				}
			}
			if (win) {
				return true;
			}
		}

		if (row + col == 2) {
			win = true;
			for (int i = 0; i < 3; i++) {
				if (board[i][2 - i] != symbol) {
					win = false;
					break;
				}
			}
			if (win) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Prints the current state of the game board.
	 *
	 * @param board The game board.
	 */
	public static void printBoard(char[][] board) {
		// Print the game board
		System.out.println("  1   2   3");
		System.out.println("  ---------");

		for (int row = 0; row < 3; row++) {
			System.out.print(row + 1 + " ");
			for (int col = 0; col < 3; col++) {
				System.out.print("| " + board[row][col] + " ");
			}
			System.out.println("|");
			System.out.println("  ---------");
		}
	}

	/**
	 * Validates if the given row and column are within the valid range.
	 *
	 * @param row The row number.
	 * @param col The column number.
	 * @return True if the row and column are valid, false otherwise.
	 */
	public static boolean isValid(int row, int col) {
		return row >= 0 && row < 3 && col >= 0 && col < 3;
	}
}
