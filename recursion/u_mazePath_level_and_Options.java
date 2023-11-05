package recursion;

public class u_mazePath_level_and_Options {

    public static void main(String[] args) {

        int n = 3;
        int m = 3;
        printMazePaths(n, m, 1, 1, "");
    }

    static void printMazePaths(int n, int m, int h, int v, String pathSoFar) {

        if (h > m || v > n)
            return;

        if (h == m && v == n){
            System.out.println(pathSoFar);
            return;
        }


        printMazePaths(n, m, h+1, v, pathSoFar+"h");
        printMazePaths(n, m, h, v+1, pathSoFar+"v");
    }

}

