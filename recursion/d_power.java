package recursion;

public class d_power {

    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println(power(x , n));
    }

    public static int power(int x, int n) {
        if (n == 0)
            return 1;

        int faith = power(x, n-1);
        int linkWithExpectation = x * faith;
        return linkWithExpectation;
    }
}
