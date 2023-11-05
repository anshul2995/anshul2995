package recursion;

public class i_displayArrReverse {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        displayArrReverse(arr, 0);
    }

    static void displayArrReverse(int[] arr, int index){
        if(index == arr.length)
            return;

        displayArrReverse(arr, index+1); //Faith that it will print from index+1 to n.
        System.out.println(arr[index]);
    }
}
