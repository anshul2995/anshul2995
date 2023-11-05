class zxcvb {

    public static void main(String[] args) {
        
        //int arr[] = {2,3,3,1};
        //int arr[] = {3,1,3,4,2};
        //int arr[] = {1,3,4,2,2};
        //int arr[] = {3,1,4,1,2};
        int arr[] = {1, 5, 1, 2, 3, 4};
        //int arr[] = {1, 2, 3, 4, 2};
        //int arr[] = {2,5,9,6,9,3,8,9,7,1};

        int slow = arr[0];
        int fast = arr[0];

        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while(slow!=fast);

        fast = arr[0];
        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }

        System.out.println("Duplicate number: "+slow);
    }
}
