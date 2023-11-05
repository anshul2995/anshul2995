package recursion;

import java.util.ArrayList;
import java.util.List;

public class w_floodFill {

    static class ListSet {
        int row;
        int column;

        ListSet(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    //static List<ListSet> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},
                          {0,1,0},
                          {0,0,0}};

//        int[][] matrix = {{0,0,0},
//                          {0,0,0},
//                          {1,1,0}};

        floodFill(matrix, 0,0, "", new boolean[matrix.length][matrix[0].length]);
        System.out.println();
        floodFill(matrix, 0,0, new ArrayList<>(), new boolean[matrix.length][matrix[0].length]);
    }

    //down, top, left, right.

    /**
     * You didn't add the visited variable. Draw the path/tree diagram and understand, what are the implications? Its's stuck in a loop.
     *
     * Next you did this, boolean visited and before 1st recursion call, did this visited = true. But this will also not work. Draw the path/tree diagram and understand
     * */
    static void floodFill(int[][] arr, int row, int column, String path, boolean[][] visited) {

        if (row < 0 || row == arr.length || column < 0 || column == arr[0].length)
            return;

        if (arr[row][column] == 1 || visited[row][column])
            return;

        if (row == arr.length-1 && column == arr[0].length-1){
            System.out.println(path);
            return;
        }

        visited[row][column] = true;
        floodFill(arr, row+1, column, path+"d", visited);
        floodFill(arr, row-1, column, path+"t", visited);
        floodFill(arr, row, column-1, path+"l", visited);
        floodFill(arr, row, column+1, path+"r", visited);
        visited[row][column] = false;
    }

    static void floodFill(int[][] arr, int row, int column, List<ListSet> ans, boolean[][] visited) {
        ans.add(new ListSet(row,column));

        if (row < 0 || row == arr.length || column < 0 || column == arr[0].length) {
            ans.remove(ans.size() - 1);
            return;
        }

        if (arr[row][column] == 1 || visited[row][column]) {
            ans.remove(ans.size() - 1);
            return;
        }

        if (row == arr.length-1 && column == arr[0].length-1){
            ans.forEach(obj -> System.out.println(obj.row + ","+ obj.column));
            ans.remove(ans.size() - 1);
            return;
        }

        visited[row][column] = true;
        floodFill(arr, row+1, column, ans, visited);
        floodFill(arr, row-1, column, ans, visited);
        floodFill(arr, row, column-1, ans, visited);
        floodFill(arr, row, column+1, ans, visited);
        visited[row][column] = false;
        ans.remove(ans.size() - 1);
    }
}

//backtracking is basically level and options. Ek level pe khade ho and saare options explore karo.


//tmhri thinking ki -> visitedArray leaf node k lie true/false mark ni ho rha h kya?
//Ans -> ni, kyuki true tabhi mark ho raha h jab node/point pohoch k uske aage bhard rhe hai.
//              Aage bhardna matlab ki uss point pe pohoch ke recursive calls ja rhi hai.



//https://youtu.be/R1URUB6_y2k

/**
 * {0,1,0,0,0,0,0}
 * {0,1,0,1,1,1,0}
 * {0,0,0,0,0,0,0}
 * {1,0,1,1,0,1,1}
 * {1,0,1,1,0,1,1}
 * {1,0,0,0,0,0,0}
 *
 * Try with this combination, you will get all the clarity.
 * */