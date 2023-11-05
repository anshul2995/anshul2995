package recursion;

import java.util.ArrayList;
import java.util.List;

public class q_mazePaths {

    public static void main(String[] args) {

        int n = 3;
        int m = 3;
        //3 * 3 matrix.
        System.out.println(mazePaths(n, m, 1, 1));
    }

    static List<String> mazePaths(int n, int m, int h, int v) {
        List<String> ans = new ArrayList<>();
        if (h > m || v > n)
            return ans;

        if (h == m && v == n) {
            ans.add("");
            return ans;
        }
        List<String> faithAllHorizontalPaths = mazePaths(n, m, h+1, v);
        for (String s: faithAllHorizontalPaths)
            ans.add("h" + s);

        List<String> faithAllVerticalPaths = mazePaths(n, m, h, v+1);
        for (String s: faithAllVerticalPaths)
            ans.add("v" + s);

        return ans;
    }


}

