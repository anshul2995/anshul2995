class abc19072022 {

    public static void main(String[] args) {
        
        //int arr[] = {2,3,3,1};
        //int arr[] = {3,1,3,4,2};
        //int arr[] = {1,3,4,2,2};
        //int arr[] = {3,1,4,1,2};
        //int arr[] = {1, 5, 1, 2, 3, 4};
        //int arr[] = {1, 2, 3, 4, 2};
        int arr[] = {2,5,9,6,9,3,8,9,7,1};
        int size = arr.length;

        for (int i = 0; i< size; i++)
        {

            int value = Math.abs(arr[i]);
            if (arr[value] < 0)  {                                    
                System.out.println("duplicate number:"+ value);
                break;
            }
            else {
                arr[value] *= -1;
            }
        }
    }
}
