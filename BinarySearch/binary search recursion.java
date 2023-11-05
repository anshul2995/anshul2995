package BinarySearch;

class abc1 {

    public static void main(String[] args) {
        
        int elementToSearch = 8;
        
        int arr[] = {1,3,5,6,7,8};

        int pos = binarySearch1(arr, 0 , arr.length-1, elementToSearch);  //we have done lenght-1 because we wanted high-pointer to be at 6th index ie. at value 8

        if (pos!= -1) {
            System.out.println("Element found at position:"+ pos);
        }
        else 
            System.out.println("Element not found");
        
    }

    public static int binarySearch(int[] arr, int low, int high, int elementToSearch){

        int mid = (low + high) / 2;

       
        if (low <= high){
            //base condition
            if (elementToSearch == arr[mid]){
                return mid+1;
            }

            else if (arr[mid] < elementToSearch)
                return binarySearch(arr, mid+1, high, elementToSearch);

            else 
                return binarySearch(arr, low, mid-1, elementToSearch);

        }
        else return -1;
    }

    public static int binarySearch1(int[] arr, int low, int high, int elementToSearch) {

        if (low > high) { //this base case is required, what if element does not exist
            return -1;
        }
        //'=' ni lag skte h kyuki low=high, valid case hai. What if arr.length = 1, ek hi element ho.
String s="";
        s.charAt(0);
        int mid = (low+high)/2;

        if (arr[mid] == elementToSearch)
            return mid+1;

        if(elementToSearch > arr[mid]) {
            return binarySearch1(arr, mid+1, high, elementToSearch);
        } else {
            return binarySearch1(arr, low, mid-1, elementToSearch);
        }
    }
}
