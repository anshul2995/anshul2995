class abc3  {
    
    public static void main(String[] args) {
        
        int target = 9;
        int[] arr = {4,5,6,7,8,9,0,1,2};
        int low = 0 ;
        int high = arr.length-1;

        while(low<=high){
            int mid = (low+high)/2;

            if (arr[mid]==target){
                System.out.println("Element found at location:"+(mid+1));
                break;
            }

            //to check whether the left half of the middle element is sorted. 
            if (arr[low]<=arr[mid]){
                if(arr[low]<=target && target <=arr[mid]){ //this condition true means the target element lies in the left half  of the middle element and 
                                                                    //discard the right half  of the middle element entirely.
                    high=mid-1;
                }
                else {
                    low=mid+1; //this condition true means the target element lies in the right half  of the middle element and discard the left half 
                                                                    //of the middle element entirely.
                }
            }
            //to check whether the right half of the middle element is sorted. 
            else {
                if(arr[mid]<=target && target<=arr[high]){ //this condition true means the target element lies in the right half of the middle element 
                                                                    //and discard the left half of the middle element entirely.
                    low=mid+1;
                }
                else {
                    high=mid-1;//this condition true means the target element lies in the left half of the middle element and 
                                                                    //discard the right half of the middle element entirely.
                }
            }
        }
        
    }

}
