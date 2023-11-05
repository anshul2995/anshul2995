package recursion;

public class a_printDecreasingIncresing {
    public static void main(String[] args) {
        int n = 5;
        printDecreasingIncresing(n);
    }

    public static void printDecreasingIncresing (int n) {
        if (n == 0)
            return;
        System.out.println(n);
        printDecreasingIncresing(n-1);
        System.out.println(n);
    }
}
