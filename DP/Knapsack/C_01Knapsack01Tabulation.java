package DP.Knapsack;

public class C_01Knapsack01Tabulation {

    static int[][] dp;

    public static void main(String[] args) {
        int weight[] = {1, 2, 3}, profit[] = {10, 15, 40};
        int W = 6;

        int n = weight.length;
        dp = new int[n+1][W+1];

        for (int i = 0 ; i < n+1; i++){
            for (int j = 0 ; j < W+1; j++){
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }

        for (int i = 1; i < n+1; i++){
            for (int j = 1; j< W+1; j++){
                if (weight[i-1] <= j){
                    dp[i][j] = Math.max(profit[i-1] + dp[i-1][j - weight[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][W]);
    }
}
