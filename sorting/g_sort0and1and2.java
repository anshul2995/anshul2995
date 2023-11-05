package sorting;

import java.util.Arrays;

public class g_sort0and1and2 {

    public static void main(String[] args) {

        //int[] arr = {1,1,2,2,0,1,2,2,1,1,2,0,2,1};
        //int[] arr = {1,0};
        int[] arr = {2,2};

        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();


        int i = 0, j = 0, k = arr.length-1;

        while (i <= k) {
            if (arr[i] == 2){
                swap(arr, i, k);
                k--;
/**
we can swap i and k,
k can be decreased, because its guaranteed that k+1 will contain all the 2s
    arr[i] is guranteed to be 2 because hum yahi check kar rhe h.
but we cannot increase i because, because we dont know from which we are swapping the value.
    what was the value at arr[k], 0 bhi ho sakta h and 1 bhi ho sakta h and 2 bhi ho sakta h.
    we haven't analysed the value of arr[k]. we have analysed only arr[i].
    toh next iteration mai arr[i] ko phr check karo.
*/
            } else if (arr[i] == 0) {
                swap(arr, i, j);
                j++;
                i++;
            } else {
                i++;
            }
        }

       /***
        *
        * NOT WORKING... VERY DISAPPOINTING!!!! YOU HAD TO SEE THE VIDEO.
        *
        * int i = 0, j = 0, k = arr.length-1;

        while(i<=k) {
            if(arr[i]==2){
                while(arr[k] == 2 && k > 0) {
                    k--;
                }
               swap(arr, i, k);
            }

            if(arr[i] == 0) {
                swap(arr, i, j);
                j++;
            }
            i++;
        }
        tum i++ ki chakkar mai reh gye. yeh ni socha ki i++ ni karna tha.
        */
        Arrays.stream(arr).forEach(System.out::print);
    }

    public static void swap(int[]arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * 4 regions:
 * i to k -> unknown
 * 0 to j - 1 -> only 0
 * j to i - 1 -> only 1
 * k+1 to n -> only 2
 *
 * https://youtu.be/MbV26HWqxrs
 *
 * */