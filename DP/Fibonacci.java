package DP;

import java.util.Arrays;

class Fibonacci {

    public static void main(String[] args){
        
        int n = 5;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(fib(n, dp));
    }

    static int fib(int n, int[] dp) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        if (dp[n] != -1)  //Checking if the value has been previously calculated or not!
            return dp[n];
        
        int ans =  fib(n-1, dp) + fib(n-2, dp); //value of this particular subproblem is stored in 'ans' variable.
        dp[n] = ans;
        return ans;
    }

    static int fibTabulation(int n) {
        int[] dp = new int[n];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

}