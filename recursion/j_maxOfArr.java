package recursion;

public class j_maxOfArr {

    public static void main(String[] args) {

        //int[] arr = {1,2,3,4,5};
        int[] arr = {22,3,4,19,7};
        int max = maxOfArr(arr, 0);
        System.out.println(max);
    }

    static int maxOfArr(int[] arr, int index){

        if (index == arr.length - 1) //last element is itself the largest.
            return arr[index];

        int maxFrom1ToN = maxOfArr(arr, index+1);
        int linkageMax = Math.max(arr[index], maxFrom1ToN);

        return linkageMax;
    }
}
