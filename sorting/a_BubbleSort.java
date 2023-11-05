package sorting;

import java.util.Arrays;

public class a_BubbleSort {

    public static void main(String[] args) {
        int[] arr = {9,5,6,2,7,4,1,3,8,0};
        Arrays.stream(arr).forEach(i -> System.out.print(i+","));
        System.out.println();
        int n = arr.length;

        for (int i = 0 ; i < n-1; i ++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        Arrays.stream(arr).forEach(i -> System.out.print(i+","));
    }
}
