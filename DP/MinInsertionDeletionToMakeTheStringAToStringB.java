package DP;

class MinInsertionDeletionToMakeTheStringAToStringB {
    public static void main(String[] args) {
        
        String s1 = "heap";
        String s2 = "pea";

        int lcs = LCS(s1, s2, s1.length(), s2.length());

        int deletion = s1.length() - lcs;
        int insertion = s2.length() - lcs;

        System.out.println("Deletion:"+deletion);
        System.out.println("Insertion:"+insertion);
    }

    public static int LCS(String s1, String s2, int m, int n){

        int[][] t = new int[m+1][n+1];

        for (int i = 0 ; i < m+1; i++){
            for (int j = 0 ; j < n+1; j++){
                if (i==0 || j==0)
                    t[i][j] = 0;
            }
        }

        for (int i = 1 ; i < m+1; i++){
            for (int j = 1 ; j < n+1; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);

            }
        }
        return t[m][n];
    }

}