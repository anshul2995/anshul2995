public class mergeTwoSortedArray {

    public static void main(String[] args) {
        
        int arr1[] = {1,3,5,7};
        int arr2[] = {2,4,6,8,10};
        int n1 = arr1.length;
        int n2 = arr2.length;

        int arr3[] = new int[n1+n2];

        int i=0, j=0, k=0;

        while(i < n1 && j < n2){
            if(arr1[i] <= arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        while(i < n1)
            arr3[k++] = arr1[i++];
        
        while(j < n2)
            arr3[k++] = arr2[j++];

        
        for (int iter : arr3) {
            System.out.println(iter);
        }
    }
}