class abcd {

    public static void main(String[] args) {
     
//        int[] arr1 = {7,12,14,15,16};//{7,12,14,15};
//        int[] arr2 = {1,2, 34, 9, 11};
        int[] arr1 = {1,3,4,7,10,12};//{7,12,14,15};
        int[] arr2 = {2,3,6,15};

        int m = median(arr1, arr2);
        System.out.println("Median of two sorted arrays is: "+m);
    }

    public static int median(int[] arr1, int[] arr2){

        int n1 = arr1.length;
        int n2 = arr2.length;
        if (n2 < n1) 
            return median(arr2, arr1);  
       int low = 0;
       int high = n1;
       while (low <= high){
            int cut1 = (low+high) / 2;
            int cut2 = (n1+n2+1)/2 - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE :arr1[cut1-1];
            int l2 = cut1 == n1 ? Integer.MAX_VALUE: arr1[cut1];
            int r1 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2-1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE: arr2[cut2];

            if (l1 <= r2 && l2 <= r1){
                if ((n1 + n2) % 2 == 0)  { //even length 
                    int median = (Math.max(l1, l2) + Math.min(r1,r2)) / 2;
                    return median;    
                }
                else  { //odd length
                    int median = (Math.max(l1, l2));
                    return median;  
                }
            }
            else if (l1 > r2) {
                high = cut1 - 1; //in BS -> when we have to go left, then high = mid - 1
            }
            else {
                low = cut1 + 1; //in BS -> when we have to go right, then low = mid + 1
            }
       }
        return -1;
    }
}