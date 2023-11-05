class abc {
    public static void main(String[] args) {
        
        int arr[] = {2,5,1,8,2,9,1};
        int size = arr.length;
        int k = 3; //window size [MAX SUBARRAY OF SIZE K]

        int i=0, j =0, sum = 0, max = Integer.MIN_VALUE;

        while (j < size){
            sum = sum + arr[j];
            
            if(j-i+1 < k){
                j++;
            }
            else {
                max = Math.max(max, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }

        System.out.println("Max sum:"+max);
    }
}
