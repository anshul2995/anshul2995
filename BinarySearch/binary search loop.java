package BinarySearch;

class abc {

    public static void main(String[] args) {

        int elementToSearch = 9;
        
        int arr[] = {1,3,5,6,7,8};

        int low = 0 ; 
        int high =  arr.length-1;  //we have done lenght-1 because we wanted high-pointer to be at 6th index ie. at value 8

        while(low <= high) {

            int mid = (low + high) / 2;
           
            if (elementToSearch == arr[mid]){
                System.out.println("Element found at location: "+ (mid+1));
                break;
            }
            else if (arr[mid] < elementToSearch){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        if (low > high)
            System.out.println("Element not found location -1"); //element not found
    }
}