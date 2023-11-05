package sorting;

import java.util.Arrays;

public class e_kthSmallestElementUsingQuickSelectAlgo {

    public static void main(String[] args) {
        int[] arr = {8, 5, 1, 3, 7, 2, 9, 6};
        //int[] arr = {9,8,7,6,5,4,3,2,1,0};
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
       // int k = 2;
        for (int i = 1 ; i <= 10; i++) {
            kthSmallstElement2ndThinking(arr, 0 , arr.length - 1, i);
        }
    }

    public static void kthSmallstElement2ndThinking(int[] arr, int low, int high, int k){

        /**
        * Agar k ki value <= arr.length k barabar h toh jarurat ni hai niche wala check
        * Agar k ki value > arr.length se upar h toh , jarurat h yeh check, warna Error aayegi, ArrayOutOfBoundException error aayegi.
        * */
        if (low > high) {
            return;
        }

        int pivotPosition = pivot(arr, low, high);

        if (k == pivotPosition + 1)
            System.out.println(k +"th smallest element is:"+ arr[pivotPosition]);
        else if (k < pivotPosition + 1)
            kthSmallstElement2ndThinking(arr, low, pivotPosition-1, k);
        else
            kthSmallstElement2ndThinking(arr, pivotPosition + 1, high, k);
    }

/*    public static int kthSmallstElement1stThinking(int[] arr, int low, int high, int k){ //THIS APPROACH GAVE ERRORS, STACK_OVER_FLOW when tried for all values of k = 1 to arr.length

        if (low >= high) {
            return -1;
        }

        int pivotPosition = pivot(arr, low, high);

        if (pivotPosition + 1 == k)
            return arr[pivotPosition];

        int ans = kthSmallstElement(arr, low, pivotPosition-1, k);
        if (ans == -1)
            ans = kthSmallstElement(arr, low, pivotPosition+1, high);
        return ans;
    }*/

    public static int pivot(int[] arr, int low, int high) {

        int i = low, j = low;

        while (i <= high) {
            if (arr[i] > arr[high])
                i++;
            else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
        return j - 1;
    }
}
