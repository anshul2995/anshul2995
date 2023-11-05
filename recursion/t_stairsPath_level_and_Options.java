package recursion;

public class t_stairsPath_level_and_Options {

    public static void main(String[] args) {
        int source = 2;
        printStairPaths(source, "");
    }

    public static void printStairPaths(int n, String pathSoFar) {

        if (n < 0) {
            return;
        }

        if (n == 0) {
            System.out.println(pathSoFar);
            return;
        }


        for (int i = 1; i<=3; i++){
            printStairPaths(n-i, i+pathSoFar);
        }
    }
}
