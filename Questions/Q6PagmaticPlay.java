package Questions;

public class Q6PagmaticPlay {

    public static void main(String[] args) {

        int output = binarySearchSquareRoot(2);
        System.out.println(output);
    }


    public static int squareRoot(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int i = 1, ans = 1;

        while (ans <= x) {
            i++;
            ans = i * i;
        }

        return i - 1;
    }

    public static int binarySearchSquareRoot(int x) {

        long start = 1, end = x;
        int ans = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            if (mid * mid == x)
                return (int) mid;
            if (mid * mid < x) {
                start = mid + 1;
                ans = (int) mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
