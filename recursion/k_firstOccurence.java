package recursion;

public class k_firstOccurence {

    public static void main(String[] args) {

        int[] arr = {2,3,9,8,7,6,4,12,7,3,8};
        System.out.println(firstOccurence(arr, 10,0));
        System.out.println(firstOccurenceOptimised(arr, 10, 0));
    }

    static int firstOccurence(int[] arr, int n, int index) {

//        if (index == arr.length)
//            return -1;
//        if (arr[index] == n)
//            return index;
//
//        int indexFrom1toN = firstOccurence(arr, n, index+1);
//        int linkageFrom0ToN = Math.min(index, indexFrom1toN);
//        return linkageFrom0ToN;

        /**
         * You didn't think of properly of the LINKAGE of the faith and the expectation.
        * */

        if (index == arr.length)
            return -1;

        int faithIndexFrom1toN = firstOccurence(arr, n, index+1); // yaha pe mai last tak gya, aakhri tak.
        if (arr[index] == n)  // faith ki expectation ki linkage.
            return index;
        else
            return faithIndexFrom1toN;
    }

    static int firstOccurenceOptimised(int[] arr, int n, int index) {

        if (index == arr.length)
            return -1;
        if (arr[index] == n)
            return index;

        int indexFrom1toN = firstOccurence(arr, n, index+1);
        return indexFrom1toN;

    }
}
