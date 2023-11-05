package sorting;

import java.util.Arrays;

public class f_sort0and1 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1};
        Arrays.stream(arr).forEach(System.out::print);

        int i = 0, j = 0;

        while (i < arr.length) {
            if (arr[i] == 1) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
        System.out.println();
        Arrays.stream(arr).forEach(System.out::print);
    }
}

//'j' contains the position of the 1st occurrence of 1 from the left
//IMPORTANT: 'j' contains the position of the 1st encountered '1' from the left
/**
 * 4 regions:
 * i to n -> unknown
 * 0 to j - 1 -> only 0
 * j to i - 1 -> only 1

 * */