package recursion;

import java.util.Arrays;

public class z_knightsTour {

    public static void main(String[] args) {

        int n = 8;
        int[][] chess = new int[n][n];
        int row = 0;
        int column = 0;

//        for (int i = 0 ; i < n ; i++)
//            for (int j = 0; j < n; j++)
//                knightsTour(chess, "", i, j, 0);

        knightsTour(chess, row, column, 0);
    }

    static void knightsTour(int[][] chess, int row, int column, int move) {

        if (row >= chess.length || column >= chess.length || row < 0 || column < 0)
            return;

        if (chess[row][column] > 0)
            return;

        if (move == chess.length * chess.length) {
            chess[row][column] = move;
            displayBoard(chess);
            chess[row][column] = 0;
            return;
        }
        
        chess[row][column] = move;

        knightsTour(chess,  row-2, column+1, move+1);
        knightsTour(chess,  row-1, column+2, move+1);
        knightsTour(chess,  row+1, column+2, move+1);
        knightsTour(chess,  row+2, column+1, move+1);
        knightsTour(chess,  row+2, column-1, move+1);
        knightsTour(chess,  row+1, column-2, move+1);
        knightsTour(chess,  row-1, column-2, move+1);
        knightsTour(chess,  row-2, column-1, move+1);

        chess[row][column] = 0;
    }

    static void displayBoard(int[][] chess){
        for (int i = 0 ; i < chess.length ; i++) {
            for (int j = 0; j < chess.length; j++)
                System.out.print(chess[i][j] + ",");
            System.out.println();
        }
    }
}
