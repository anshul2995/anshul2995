package DP;

public class MinDeletionToMakeStringPallindromic {

    //Find the longest pallindromic subsequence.
    
    public static void main(String[] args)
    {
        String str = "agbcba";
        int n = str.length();
       System.out.println(n - LPS(str, reverse(str), n,n));
    }
    
    static String reverse(String s){
        char[] ch = s.toCharArray();
        int i = 0 , j = s.length()-1;
        while(i<j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        
        return new String(ch);
    }
    
    static int LPS(String s1, String s2, int m, int n) {
        int[][] t = new int[m+1][n+1];
        
        for (int i = 0 ; i < m + 1; i++){
            for (int j = 0 ; j < n + 1; j++){
                if (i==0 || j==0)
                    t[i][j] = 0;
            }
        }
        
        for (int i = 1 ; i < m+1; i++) {
            for (int j = 1; j < n+1; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else 
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
            }
        }
        
        return t[m][n];
    }
}