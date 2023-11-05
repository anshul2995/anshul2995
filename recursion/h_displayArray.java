package recursion;

public class h_displayArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        displayArray (arr, 0);
    }

    static void displayArray(int[] arr, int index){ // displayArray (arr, 0) <== 1 , displayArray (arr, 1)
        if (index == arr.length)
            return;

        // Exp -> print from 0 to n.
        System.out.println(arr[index]);    // Linkage
        displayArray(arr, index+1);  // Faith -> print from 1 to n

    }
}
