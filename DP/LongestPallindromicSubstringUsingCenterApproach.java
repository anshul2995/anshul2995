package DP;

public class LongestPallindromicSubstringUsingCenterApproach {

    static int startA;
    static int lengthA;

    public static void main(String[] args) {
        
        String s = "forgeeksskeegfor";

        for (int i = 0 ; i < s.length(); i++){
            expand(s, i, i);
            expand(s, i, i+1);
        }

        System.out.println(s.substring(startA, startA+lengthA));

    }

    static void expand(String s, int start, int end){
        
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }

        if (end-start-1 > lengthA){
            startA = start+1;
            lengthA = end-start-1;
        }
    }
}
