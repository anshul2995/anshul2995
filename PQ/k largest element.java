package PQ;

import java.util.PriorityQueue;

class element {
    public static void main(String[] args) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[] arr = {2,10,5,17,7,18,6,4};
        int size = arr.length;
        int k = 3;

        for(int i = 0 ; i < k; i++){
            pq.add(arr[i]);
        }

        for(int i = k ; i < size; i++) {   
            if (arr[i] > pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }

       while(pq.size() > 0){
            System.out.println(pq.peek());
            pq.remove();
       }
    } 
}
