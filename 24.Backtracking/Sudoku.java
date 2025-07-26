public class Sudoku {

    public static boolean Solver(int[][] sudoku, int row, int col) {
        // Base Case: If we reach past the last cell
        if (row == 9) {
            return true;
        }

        // Calculate next row and column
        int nextRow = row, nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // If the cell is already filled, move to the next one
        if (sudoku[row][col] != 0) {
            return Solver(sudoku, nextRow, nextCol);
        }

        // Try digits 1 to 9
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;

                if (Solver(sudoku, nextRow, nextCol)) {
                    return true;
                }

                // Backtrack
                sudoku[row][col] = 0;
            }
        }

        // If no valid digit found
        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // Check row
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num) return false;
        }

        // Check column
        for (int x = 0; x < 9; x++) {
            if (board[x][col] == num) return false;
        }

        // Check 3x3 grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    public static void printBoard(int[][] board) {
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0 && r != 0) {
                System.out.println("------+-------+------");
            }
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0 && c != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (Solver(board, 0, 0)) {
            System.out.println("Sudoku Solved:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
