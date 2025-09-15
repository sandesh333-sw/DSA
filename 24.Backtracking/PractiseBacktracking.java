public class PractiseBacktracking{
    public static void nQueens(char[][] board, int row){
        //base case
        if(row == board.length){
            printSol(board);
            System.out.println();
            return;
        }

        for(int j=0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = '.';
            }
        }
    }


    public static void printSol(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.println(board[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static boolean isSafe(char[][] board, int row, int col){
        //checking conditions

        //vertical up
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q') return false;
        }

        //left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }

        //right diagonal
        for(int i=row-1, j=col+1; i>=0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }


    public static void main(String args[]){
        int n = 2;
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }

        nQueens(board, 0);
    }
}