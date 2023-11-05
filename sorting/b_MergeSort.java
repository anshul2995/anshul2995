package sorting;

import java.util.Arrays;

public class b_MergeSort {

    public static void main(String[] args) {

        int[] arr = {9,5,6,2,7,4,1,3,8,0};
        Arrays.stream(arr).forEach(i -> System.out.print(i+","));
        System.out.println();
        Arrays.stream(mergeSort(arr, 0, arr.length-1)).forEach(i -> System.out.print(i+","));
    }

    static int[] mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            int[] a = new int[1];
            a[0] = arr[low];
            return a;
        }

        int mid = (low + high) / 2;

        int[] leftHalf = mergeSort(arr, low, mid);
        int[] rightHalf = mergeSort(arr, mid+1, high);

        int[] ans = new int[leftHalf.length + rightHalf.length];
        int k = 0, i = 0, j = 0;

        while ( i < leftHalf.length && j < rightHalf.length){
            if (leftHalf[i] <= rightHalf[j])
                ans[k++] = leftHalf[i++];
            else
                ans[k++] = rightHalf[j++];
        }

        while( i < leftHalf.length)
            ans[k++] = leftHalf[i++];

        while( j < rightHalf.length)
            ans[k++] = rightHalf[j++];

        return ans;
    }
}
