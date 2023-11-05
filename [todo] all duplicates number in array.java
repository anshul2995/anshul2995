class yo {
    
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,6,3,6,1};
        //int arr[] = {2,3,1,2,3};
        //int arr[] = {13, 9, 25, 1, 1, 0, 22, 13, 22, 20, 3, 8, 11, 25, 10, 3, 15, 11, 19, 20, 2, 4, 25, 14, 23, 14};
        //int arr[] = {1,2,1,4,3,1};
        duplicates(arr, arr.length);
    }

    static void duplicates(int arr[], int n) {

        for (int i = 0; i < n; i++)
        {
             int index = arr[i] % n;
            arr[index] += n;
        }

        for (int i = 0; i < n; i++)
        {
            if ((arr[i] / n) >= 2)
                System.out.print(i + " ");
        }
    }
}
