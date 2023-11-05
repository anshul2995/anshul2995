package recursion;

public class l_lastOccurence {

    public static void main(String[] args) {
        int[] arr = {2,3,9,8,7,6,4,12,7,3,8};
        System.out.println(lastOccurence(arr, 0,8));
    }

    static int lastOccurence(int[] arr, int index, int n) {

        if (index == arr.length)
            return -1;

        int faith1toN = lastOccurence(arr, index+1, n);

        if (arr[index] == n) {
            if (faith1toN == -1)
                return index;
            else
                return faith1toN;
        } else
            return faith1toN;
    }
}
