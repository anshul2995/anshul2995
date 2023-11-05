package recursion;

import java.util.ArrayList;
import java.util.List;

public class o_keyCombination {

    static String[] codes = {".,", "abc", "def", "ghi", "jkl", "mno","pqrs","tu","vwx", "yz"};

    public static void main(String[] args) {

        String str = "678";
        System.out.println(keywordCombination(str));
    }

    static List<String> keywordCombination (String s) {
        char ch = s.charAt(0);
        int chI = ch - '0';
        String code = codes[chI];

        if (s.length() == 1) {
            List<String> ans = new ArrayList<>();
            for (int i = 0 ; i < code.length(); i++) {
                char c = code.charAt(i);
                ans.add(c+"");
            }
            return ans;
        }

        List<String> ans = keywordCombination(s.substring(1)); //faith.
        List<String> finalAns = new ArrayList<>();

        for (int i = 0 ; i < code.length(); i++) {
            char c = code.charAt(i);
            for (String str : ans) {
                finalAns.add(c + str);
            }
        }

        return finalAns;
    }
}
