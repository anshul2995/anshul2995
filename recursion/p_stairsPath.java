package recursion;

import java.util.ArrayList;
import java.util.List;

public class p_stairsPath {

    public static void main(String[] args) {
        int source = 2;
        System.out.println(getStairPaths(source));
    }

    static List<String> getStairPaths(int source) {

        List<String> ans = new ArrayList<>();
        if (source < 0) {
            return ans;
        }

        if (source == 0) {
            ans.add("");
            return ans;
        }

        List<String> pathBy1Steps= getStairPaths(source-1);//Faith that all the stairs path from n-1 to 0 will be given
        for (String s: pathBy1Steps)  //linkage of the faith with the expectation
            ans.add("1"+s);
        List<String> pathBy2Steps= getStairPaths(source-2);//Faith that all the stairs path from n-2 to 0 will be given
        for (String s: pathBy2Steps) //linkage of the faith with the expectation
            ans.add("2"+s);
        List<String> pathBy3Steps= getStairPaths(source-3);//Faith that all the stairs path from n-3 to 0 will be given
        for (String s: pathBy3Steps) //linkage of the faith with the expectation
            ans.add("3"+s);

        return ans;
    }

/**
 * You were not able to think about the FAITH.
 * */
}
