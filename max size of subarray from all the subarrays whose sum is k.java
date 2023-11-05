
class abc09072022{

    public static void main(String[] args) {
        //int arr[] = {4,1,1,1,2,3,5};
        //int k = 5; //sum=5;
        int arr[] = {1,2,3,7,5};
        int k = 12;

        int i=0,j=0, maxSize = 0;
        int sum = 0;

        while(j < arr.length){

            sum = sum + arr[j];
            if (sum < k)
            {
                j++;
            }
            else if (sum == k)
            {
                maxSize = Math.max(maxSize, j-i+1);
                j++;
            } 
            else  //sum > k
            {
                while (sum > k)
                {
                   sum = sum - arr[i];
                   i++;
                }
                if (sum == k) {
                    maxSize = Math.max(maxSize, j-i+1);
                }
                j ++;
            }
        }
        System.out.println("Max subarray size: "+maxSize);
    }


}

