package PQ;

import java.util.Collections;
import java.util.PriorityQueue;

class abc {

public static void main(String[] args) {
    
    //PriorityQueue<Integer> pq = new PriorityQueue<>(); //lower value has been assigned the highest priority

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //higher value has been assigned the highest priority

    int[] arr = {22,99,3,11,88,4,1};

    for(int i: arr){  //O(n log n) => n * log n => log n to add and it runs for n elements
        pq.add(i);
    }

    while(pq.size() > 0){   //O(n log n) => n * log n => log n to remove and it runs for n elements
        System.out.println(pq.peek());
        pq.remove();
    }
}

}