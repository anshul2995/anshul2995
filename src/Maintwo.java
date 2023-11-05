import java.util.*;

public class Maintwo {

    //Input: nums = [1,2,3]
    //Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        res = subset(0, nums);

        System.out.println(res);
    }

    public static List<List<Integer>> subset(int i, int[] arr) {
        if (i == arr.length) {
            List<Integer> temp = new ArrayList<>();
            res.add(temp);
            return res;
        }

/*        3 -> [[]]
        [[], [3]]

        2 -> [[], [3]]
        [[], [3], [2], [2,3]]

        1 -> [[], [3], [2], [2,3]]
        [[], [3], [], [2,3], [[1], [1,3], [1,2], [1,2,3]]]*/
        List<List<Integer>> res =  subset(i+1, arr);
        int size = res.size();
        for (int j = 0 ; j < size; j++){
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[i]);
            for (int k = 0 ; k < res.get(j).size(); k++){
                temp.add(res.get(j).get(k));
            }
            res.add(temp);
        }
        return res;
    }
}
