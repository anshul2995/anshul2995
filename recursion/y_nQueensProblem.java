package recursion;

public class y_nQueensProblem {

    public static void main(String[] args) {
//        int n = 2;
//        int[][] chess = new int [n][n];
//        nQueensStep1(chess, "", 0);

        int n = 4;
        int[][] chess = new int [n][n];

        nQueensStep(chess, "", 0);
    }

    static void nQueensStep(int[][] arr, String queenSoFar, int row) {

        if (arr.length == row) {
            System.out.println(queenSoFar);
            return;
        }

        for (int col = 0 ; col < arr.length; col++) {
            if (isItSafeForTheQueen(arr, row, col)){
                arr[row][col] = 1;
                nQueensStep(arr, queenSoFar + row + "-" + col + ",", row+1);
                arr[row][col] = 0;
            }
        }
    }

    static boolean isItSafeForTheQueen(int[][] chess, int row, int column){

        //Checking horizontally
        for (int i = row-1 ; i >= 0; i--) {
            if (chess[i][column] == 1)
                return false;
        }

        //Checking left diagonal
        for (int i = row - 1, j = column - 1; i >=0 && j >=0; i-- , j--){
            if (chess[i][j] == 1)
                return false;
        }

        //Checking right diagonal
        for (int i = row - 1, j = column + 1; i >= 0 && j < chess.length; i--, j++){
            if (chess[i][j] == 1)
                return false;
        }

        return true;
    }

//    static void nQueensStep1(int[][] arr, String queenSoFar, int row) {
//
//        if (arr.length == row) {
//            System.out.println(queenSoFar);
//            return;
//        }
//
//        for (int col = 0 ; col < arr.length; col++) {
//            arr[row][col] = 1;
//            nQueensStep1(arr, queenSoFar + row + "-" + col + ",", row+1);
//            arr[row][col] = 0;
//        }
//    }
}

//here Level and options are placing at a particular level and going all the rows+1 and all columns from 0 - n.
// Options all the columns from 0-n (left to right jana)
// Levels is all the rows from 0 to n (niche jana)

