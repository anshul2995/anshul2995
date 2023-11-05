package DP;

public class Q {
    public static void main(String[] args) {
        //String s = "geeks";
        String s = "forgeeksskeegfor";
        int n = s.length();

        LCS(s,reverse(s), n,n);
    }

    static String reverse(String s) {
        char[] ch = s.toCharArray();
        int i = 0, j = ch.length-1;

        while (i < j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return new String(ch);
    }

    static void LCS(String s1, String s2, int m, int n){
        int[][] t = new int[m+1][n+1];
        int ans = Integer.MIN_VALUE;
        int ansIndexIth = 0 , ansIndexJth = 0;
        
        for (int i = 0 ; i < m+1; i++){
            for (int j = 0 ; j < n+1; j++){
                if (i==0 || j==0)
                    t[i][j] = 0;
            }
        }

        for (int i = 1 ; i < m+1; i++){
            for (int j = 1; j < n+1; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                    if (t[i][j] >= ans) {
                        ans = t[i][j];
                        ansIndexIth = i;
                        ansIndexJth = j;
                    }
                }
                else
                    t[i][j] = 0;
            }
        }

        int i = ansIndexIth, j = ansIndexJth;
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

        System.out.println(sb.reverse().toString());
    }

    
}
