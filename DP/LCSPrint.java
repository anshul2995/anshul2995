package DP;

public class LCSPrint {
    public static void main(String[] args) {
     
        String s1 = "acbcf";
        String s2 = "abcdaf";

        int m = s1.length();
        int n = s2.length();

        int[][] t = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++){
            for (int j = 0 ; j < n+1; j++){
                if (i==0 || j==0)
                    t[i][j] = 0;
            }
        }

        for (int i = 1; i < m+1; i++){
            for (int j = 1; j< n+1; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else 
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);    
            }
        }

        int i = m, j = n;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) { //hit the condition when either of the string is empty, i.e. we are sitting at 0th row or 0th column
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else {
                if (t[i][j-1] > t[i-1][j]){
                    j--;
                } else {
                    i--;
                }
            }
        }
        System.err.println(sb.reverse().toString());
    } 
}
