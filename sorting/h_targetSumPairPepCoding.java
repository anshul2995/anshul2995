package sorting;

import java.util.Arrays;

public class h_targetSumPairPepCoding {

    //Elements are distinct
    //(a, b) one pair <-> (b, a) Should not b printed.
    //(a1, b1), (a2, b2), (a3, b3) Ensure that a1 < a2 < a3
    //(a, b) -> a < b

    //Our algo takes care of this thing.
    public static void main(String[] args) {

//        int[] arr = {7,15,3,18,6,4,19,2,12,11,9};
//        int k = 15;

        int[] arr = {12, 9, -48, 100, 208, 43, 84, 74, 86, 34, -37, 60, -29, 44};
        int k = 160;

        Arrays.sort(arr);  //O(n log n) complexity becuase of this.
        Arrays.stream(arr).forEach(i -> System.out.print(i + ","));

        System.out.println();

        int low = 0;
        int high = arr.length-1;

        while (low <= high) {
            int sum = arr[low] + arr[high];
            if (sum > k)
                high--; //if you do low++ then sum is going to get increased further.
            else if (sum < k)
                low++; //if you do high--, then sum is going to get decreased further.
            else {
                System.out.println(arr[low] + "," + arr[high]);
                low++;
                high--;
            }
        }
    }
}
//-48,-37,-29,9,12,34,43,44,60,74,84,86,100,208,