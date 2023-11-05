package recursion;

import java.util.ArrayList;
import java.util.List;
public class x_targetSumSubsets {

    public static void main(String[] args) {

        /*int[] arr = {10,20,30};
        int k = 30;*/
        int[] arr = {10,20,30,40,50};
        int k = 60;
        targetSumSubsets(arr,0,new ArrayList<>(), 0, k);
    }

    static void targetSumSubsets(int[] arr, int i, List<Integer> listSofar, int sumSoFar, int k) {

        if (i == arr.length) {
            if (sumSoFar == k)
                System.out.println(listSofar);
            return;
        }


        listSofar.add(arr[i]);
        targetSumSubsets(arr, i+1, listSofar, sumSoFar+arr[i], k);
        listSofar.remove(listSofar.size()-1);
        targetSumSubsets(arr, i+1, listSofar, sumSoFar, k);
    }

//    static void targetSumSubsets (int[] arr, int i, List<Integer> setSoFarCreated, int sumSoFar, int targetSum) { // 'i' is current index.
//
//        if (i == arr.length) {
//            if (sumSoFar == targetSum) {
//                System.out.println(setSoFarCreated);
//            }
//            return;
//        }
//
//        targetSumSubsets(arr, i+1, setSoFarCreated, sumSoFar, targetSum);
//        setSoFarCreated.add(arr[i]);
//        targetSumSubsets(arr, i+1, setSoFarCreated, sumSoFar + arr[i], targetSum);
//        setSoFarCreated.remove(setSoFarCreated.size()-1);
//    }

    /**
     * You were not able to think of the options, When you are sitting at a particular level, what options do you have from that level? Tum yeh soch ni paye.
    /*static void targetSumSubsets(int[] arr, int sum, int k, int i, List<Integer> ans) {

        ans.add(arr[i]);
        sum = sum + arr[i];

        if (i == arr.length) {
            sum = sum - arr[i];
            ans.remove(ans.size()-1);
            return;
        }


        if (sum == k) {
            sum = sum - arr[i];
            ans.forEach(j -> System.out.println(j));
            System.out.println();
            ans.remove(ans.size()-1);
            return;
        }

        targetSumSubsets(arr, sum, k, i+1, ans);
        ans.remove(ans.size()-1);
        sum = sum - arr[i];
    }*/
}
