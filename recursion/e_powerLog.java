package recursion;

public class e_powerLog {

    public static void main(String[] args) {

        System.out.println(powerLog(2, 5));
        System.out.println(powerLog(2, 6));
    }

    public static int powerLog (int x, int n) {

        if ( n == 0)
            return 1;

        int faith = powerLog(x, n/2);

        int linkageWithExpectation = faith * faith;
        if (n % 2 != 0)
            linkageWithExpectation = linkageWithExpectation * x;

        return linkageWithExpectation;
    }
}

