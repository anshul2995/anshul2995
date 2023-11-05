package recursion;

import java.util.Arrays;

public class m_allOccurences {

    public static void main(String[] args) {

        int[] arr = {2,3,9,8,7,6,4,12,7,3,8};
        //System.out.println(arr, 0, 3, new int[]);
        System.out.println(Arrays.toString(m_allOccurences(arr, 0, 3, 0)));
    }

    static int[] m_allOccurences (int[] arr, int index, int n, int j) {

        if (index == arr.length)
            return new int[j];

        if (arr[index] == n) {
            j++;
        }

        int[] ans = m_allOccurences(arr, index + 1, n, j);

        if (arr[index] == n) {
            --j;
            ans[j] = index;
        }

//        if (index == arr.length)
//            return ans;
//
//        if (arr[index] == n) {
//            ans[j++] = index;
//        }
//
//        return m_allOccurences(arr, index + 1, n, ans, j);
        return ans;
    }
}
