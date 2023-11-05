package DP;

import java.util.Arrays;

//Recurisve + T matrix = Memoisation. This is topdown Approach. In the the Aditya Verma playlist, its mentioned, bottom down. 
public class LCSMemoisation {

    static int[][] t = new int[1001][1001]; //assuming that the max length of the sting is 1000.

    public static void main(String[] args) {
       for (int[] row: t)
         Arrays.fill(row, -1);

         String s1 = "abcdef";
         String s2 = "bdf";
         
         System.out.println(LCSFn(s1, s2, s1.length(), s2.length()));
    }

    static int LCSFn(String s1, String s2, int n, int m) {

        if (n == 0 || m == 0)
            return 0;

        if (t[n][m] != -1)
            return t[n][m];

        if (s1.charAt(n-1) == s2.charAt(m-1)){
            return t[n][m] = 1 + LCSFn(s1, s2, n-1, m-1);
        } else {
            return t[n][m] = Math.max(LCSFn(s1, s2, n, m-1), LCSFn(s1, s2, n-1, m));
        }
    }
    
}
