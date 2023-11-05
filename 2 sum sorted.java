class blah {

    public static void main(String[] args) {
        
        // int[] numbers = {2,7,11,15};
        // int target = 9;
        // int[] numbers = {2,3,4};
        // int target = 6;

        int[] numbers = {-1, 0};
        int target = -1;

        int i = 0 , j = numbers.length-1;
        int[] ans = new int[2];

        while(i < j)
        {
            int ithValue = numbers[i];
            int jthValue = numbers[j];

            if (ithValue + jthValue == target)
            {
                ans[0] = i+1;
                ans[1] = j+1;
                break;
            }
            else if (ithValue + jthValue < target)
                i ++;
            else 
                j -- ;    
        }

        System.out.println("ans:"+ ans[0] + "," + ans[1]);
    }
    
}
