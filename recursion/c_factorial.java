package recursion;

public class c_factorial {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));
    }

    public static int factorial (int n) {
        if (n == 1) {
            return 1;
        }

        int faith = factorial (n-1);  //faith
        int expectation = n * faith; // linking of the faith with the expectation.
        return expectation;
    }
}
