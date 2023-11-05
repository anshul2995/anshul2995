package PQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class blah {

    static class Pair {
        int listIndex; //kis list ke ho tm?
        int dataIndex; //tmhri index kya hai?
        int value; //tmhri value kya hai?
        
        Pair(int listIndex, int dataIndex, int value){   this.listIndex = listIndex;  this.dataIndex = dataIndex;  this.value = value;  }
    }
    
    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();

        List<Integer> list1 = Arrays.asList(10,20,30,40,50);
        List<Integer> list2 = Arrays.asList(5,7,9,11,55,57); 
        List<Integer> list3 = Arrays.asList(1,2,3);  
        List<Integer> list4 = Arrays.asList(32,39);
        
        list.add(list1);list.add(list2);list.add(list3);list.add(list4);
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((i,j) -> i.value - j.value);
        
        for (int i = 0 ; i < list.size(); i++)
            pq.add(new Pair(i, 0, list.get(i).get(0)));

        while(pq.size() > 0) {
                Pair p = pq.peek();
                System.out.print(p.value + ",");

                if (p.dataIndex == list.get(p.listIndex).size() - 1){  // when we reached the last index of a any particular list.
                    pq.remove();
                    continue;
                }
                else {
                    p.dataIndex = p.dataIndex + 1;
                    Pair q = new Pair(p.listIndex, p.dataIndex, list.get(p.listIndex).get(p.dataIndex));

                    pq.remove();
                    pq.add(q);
                }
        }
    }
}
