package DP;

public class LCS {
    
    public static void main(String[] args) {

    }

    int LCSFn(String s1, String s2, int n, int m) {

        /** Template

            //base condition

            //choice condition

        */

        if (n == 0 || m == 0)
            return 0;
        
        if (s1.charAt(n-1) == s2.charAt(m-1)){
            return 1 + LCSFn(s1, s2, n-1, m-1);
        }
        else {
            return Math.max(LCSFn(s1, s2, n, m-1), LCSFn(s1, s2, n-1, m));   
            //yaha 1+ ni karna hai, kyuki abhi common element ni mila hai.
        }
    }
}
