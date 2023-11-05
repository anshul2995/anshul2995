package PQ;

import java.util.PriorityQueue;

class e {
    public static void main(String[] args) {
        int arr[] = {2,3,1,4,6,7,5,8,9};
        int size = arr.length;
        int k = 2; 

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0 ;
        for(; i < k ; i++){
            pq.add(arr[i]);
        }

        for(; i < size; i++)  //acquire and release
        {
            pq.add(arr[i]);  //funnel mai hamesha k elements bane rahenge.
            arr[i-k] = pq.remove();
        }

        while(pq.size() > 0) {
            arr[i-k] = pq.remove();
            i++;
        }
        
        for(int j : arr) {
            System.out.println(j);
        }
    }
}


