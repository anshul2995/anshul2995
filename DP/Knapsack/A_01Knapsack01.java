package DP.Knapsack;

public class A_01Knapsack01 {
    
    public static void main(String[] args) {
        
        int profit[] = new int[] { 60, 100, 120 }; 
        int weight[] = new int[] { 10, 20, 30 }; 
        int W = 50; 

        System.out.println("max profit: " + knapsack(weight, profit, W, profit.length));
    }

    static int knapsack(int[] wt, int[] val, int W, int n){
        if (n == 0 || W == 0)
            return 0;

        if (wt[n-1] <= W) {
            return Math.max(val[n-1] + knapsack(wt, val, W - wt[n-1], n-1), knapsack(wt, val, W, n-1)); 
        } else {
            return knapsack(wt, val, W, n-1);
        }
    }
}
