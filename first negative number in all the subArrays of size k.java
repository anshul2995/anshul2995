import java.util.LinkedList;
import java.util.Queue;

class abc290622 {
    public static void main(String[] args) {
        
        int[] arr = {12, -1, -7, 8, -15, 30, 13, 18};
        int size = arr.length;
        int k = 3;

        Queue<Integer> queue = new LinkedList<Integer>();
        int i=0, j=0;

        while (j < size){
            if (arr[j] < 0) {
                queue.add(arr[j]);
            }
            
            if (j-i+1 < k){
                j++;
            } else {
                if (queue.isEmpty()) {
                   System.out.print("0\t");
                } else {
                    int top = queue.peek();
                    System.out.print(top+"\t");

                    if (arr[i] == top) { //purane 'i' ke calculation ko discard karna hai.
                        queue.remove(); 
                    }
                }
                i++;
                j++;
            }
        }
    }
}