package DP.Knapsack;

import java.util.Arrays;

public class B_01Knapsack01Memo {
    static  int[][] dp;
    public static void main(String[] args) {
        
        int profit[] = new int[] { 60, 100, 120 }; 
        int weight[] = new int[] { 10, 20, 30 }; 
        int n = profit.length;
        int W = 50;
        dp = new int[n+1][W+1];

        for (int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(knapsack(profit, weight, W, n));
    }

    static int knapsack(int[] profit, int[] weight, int W, int n){
        if (n == 0 || W == 0)
            return 0;
        
        if (dp[n][W] != -1)
            return dp[n][W];

        if (weight[n-1] <= W) {
           return dp[n][W] = Math.max(profit[n-1] + knapsack(profit, weight, W-weight[n-1], n-1), knapsack(profit, weight, W, n-1));
        } else {
            return dp[n][W] = knapsack(profit, weight, W, n-1);
        }
    }
    
}
