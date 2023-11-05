package sorting;

public class i_pivotOfASortedArray {

//Distinct Elements
    public static void main(String[] args) {

        //int[] arr = {10,20,30,40,50};
        //int[] arr = {50, 10, 20, 30, 40};
        //int[] arr = {40, 50, 10, 20, 30};
        //int[] arr = {30, 40, 50,10, 20};
        int[] arr = {20, 30, 40, 50, 10};
        //int[] arr = {10,20,30,40};
        //int[] arr = {40,10,20,30};
        //int[] arr = {30,40,10,20};
        //int[] arr = {20,30,40,10};

        pivotElement(arr, 0, arr.length - 1);
        pivotElement1(arr, 0, arr.length - 1);
        System.out.println(pivotElement2(arr, 0, arr.length-1));

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < arr[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(arr[high]);
    }

    static void pivotElement(int[] arr, int low, int high) {

        if (low >= high) {
            System.out.println(arr[high]);
            return;
        }

        int mid = (low + high) / 2;

        if (arr[mid] < arr[high]) {
            pivotElement(arr, low, mid);
        } else {
            pivotElement(arr, mid + 1, high);
        }
    }

    static void pivotElement1(int[] arr, int low, int high) {

        if (low > high) {
            return;
        }

        int mid = (low + high) / 2;

        if (arr[mid] < arr[high]) {
            pivotElement1(arr, low, mid);
        } else if (arr[mid] > arr[high]) {
            pivotElement1(arr, mid + 1, high);
        } else {
            System.out.println(arr[high]);
            return;
        }
    }

    static int pivotElement2(int[] arr, int low, int high) {

        int mid = (low + high) / 2;

        if (arr[mid] < arr[high]) {
            return pivotElement2(arr, low, mid);
        } else if (arr[mid] > arr[high]) {
            return pivotElement2(arr, mid + 1, high);
        } else {
            return arr[high];
        }
    }
}


//mid se high value bard rhi hai, toh 1st half mai hoga, low-mid
//mid se high value ghat gyi, toh 2nd half mai hoga, mid+1 - high