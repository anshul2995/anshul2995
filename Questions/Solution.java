import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        s.multiply("123", "456");
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int n = num1.length();
        int m = num2.length();

        int[] res = new int[n+m];


        for (int i = n-1; i>=0; i--){
            for (int j = m-1; j>=0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i+j;
                int p2 = i+j+1;
                int sum = res[p2] + mul;

                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < res.length; i++)
            sb.append(res[i]);

        return sb.toString();
    }
}