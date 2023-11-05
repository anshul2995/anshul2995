package recursion;

import java.util.ArrayList;
import java.util.List;

public class n_allSubsequence {

    public static void main(String[] args) {

        String s = "abc";
        System.out.println(allSubsequence(s));
    }

    static List<String> allSubsequence(String str) {

        if (str.isEmpty()) {
            List<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }

        List<String>  ans = allSubsequence(str.substring(1)); //faith that its going to print the subsequence.

        int len = ans.size();
        char ch = str.charAt(0);

        for (int j= 0; j< len; j++) { //You got concurrentModificationException error.
            ans.add(ch + ans.get(j));
        }
        return ans;
    }
}
