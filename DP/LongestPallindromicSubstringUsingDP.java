package DP;

public class LongestPallindromicSubstringUsingDP {

    public static void main(String[] args) {
        
        String s = "abccbc";
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        //Checking for 1 length string -> diagonal k lie
        for (int i = 0 ; i < n; i++){
            dp[i][i] = true;
        }

        //Checking for 2 length string
        int start = 0;
        int length = 0;
        for (int i = 0 ; i < n - 1; i++){
               if (s.charAt(i) == s.charAt(i+1)) {
                    dp[i][i+1] = true;
                    start = i;
                    length = 2;
               }
        }

        //Checking for > 2 length string
        for (int k = 3; k <= n ; k++){
            for (int i = 0 ; i < n - k + 1; i++){
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    
                    if (k > length){
                        start = i;
                        length = k;
                    }
                    
                }
            }
        }

        System.out.println("answer:" + s.substring(start, start+length));
    }
}
