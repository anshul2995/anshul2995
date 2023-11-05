package sorting;

import java.util.Arrays;

public class c_partitionAroundPivot {

    public static void main(String[] args) {

        int[] arr = {7,9,4,8,3,6,2,1};
        int pivot = 5;
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();

        int n = arr.length;

        int i = 0 , j = 0 ;
        while(i < n) {
            if (arr[i] > pivot)
                i++;
            else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}

/**
 * Take two pointers, i and j
 * At starting position
 *           7   9   4   8   3   6   2   1
 *          i,j
 * 1 to end UNKNOWN
 * j to i-1 >PIVOT
 * 0 to j-1 <=PIVOT
 *
 * if arr[i] > pivot -> i++ THIS DECREASES THE UNKNOWN AND INCREASE OF KNOWN AREA WHICH CONTAINS ELEMENT > PIVOT
 * if arr[i]<= pivot -> swap(arr[i], arr[j]), i++ j++. THIS DECREASES THE UNKNOWN INCREASE OF KNOWN AREA WHICH CONTAINS ELEMENT <= PIVOT.
 *          THIS ALSO SHIFTS THE ELEMENT > PIVOT TO THE RIGHT.
 *
 *
 *  Crux: YOU HAVE TO UNDERSTAND THE 3 REGIONS.
 *  ----->>>>>>>'j' will point to the 1st largest element from the left.<<<<<<<<<----------
 *
 *  toh swapping hamesha j se karte hai,
 *  small wala area bhard jata hai and large wala area aisa lagega ki right ki taraf bhard gya.
 *
 * */
