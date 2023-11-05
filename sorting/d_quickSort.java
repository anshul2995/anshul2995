package sorting;

import java.util.Arrays;

public class d_quickSort {

    public static void main(String[] args) {
        //int[] arr = {8, 5, 1, 3, 7, 2, 9, 6};
        //int[] arr = {9,8,7,6,5,4,3,2,1,0};
        int[] arr = {5,4,3,2,1};
        Arrays.stream(arr).forEach(System.out::print);

        System.out.print("\n");

        quickSort(arr, 0 , arr.length - 1);

        Arrays.stream(arr).forEach(System.out::print);
    }

    public static void quickSort(int[] arr, int low, int high){

        if (low >= high){
            return;
        }

        int pivotPosition = pivot(arr, low,  high);
        /**
         * main thing: pivot element already sorted hota hai.
         * **/

        quickSort(arr, low, pivotPosition-1); //Faith h ki yeh sort hote hue aayenge
        quickSort(arr, pivotPosition+1, high); //Faith h ki yeh sort hote hue aayenge
    }
    //sorting already ho rhi hai array mai niche jate hue. Pivot Element apne sahi jagah pe aa chuka hota hai.

    static int pivot(int[] arr, int low, int high){

        int i = low;
        int j = low;

        while( i <= high) {

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
        //return i - j + 1; You were not to think for this.  AGAIN VERY DISAPPOINTING
        return j - 1;
    }

    //DISAPPOINTING VERY MUCH... VERY MUCH
/*    static int[] quickSort(int[] arr, int low, int high) {

        if (low >= high) {
            int[] ans = new int[1];
            ans[0] = arr[low];
            return ans;
        }

        int newPivot = toPivotTheArray(arr, low, high);

        int[] right = quickSort(arr, newPivot, arr.length-1);
        int[] left = quickSort(arr, 0, newPivot - 2);

        int[] ans = new int[left.length + right.length];
        int k = 0;
        for (int j : left) {
            ans[k++] = j;
        }
        ans[k++] = arr[newPivot - 1];
        for (int j : right) {
            ans[k++] = j;
        }
        return ans;
    }

    static int toPivotTheArray(int[] arr, int start, int end) {

        int i = start, j = start;
        while (i <= end) {
            if (arr[i] > arr[end])
                i++;
            else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
        return j;
    }*/
}
