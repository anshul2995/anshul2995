import java.util.Deque;
import java.util.LinkedList;

class abc20220708 {
    public static void main(String[] args) {
        
        //int arr[] = {1,3,-1,-3,5,3,6,7};
        //int arr[] = {1,3,-1,8,5,3,6,7};
        //int arr[] = {8,7,6,5,4,3,2,1};
        //int arr[] = {1,2,3,4,5,6,7,8};

        int arr[] = {1,3,1,2,0,5};

        int size = arr.length;
        int k = 3;

        Deque<Integer> queue = new LinkedList<>();
        int i=0,j=0;

        while(j < size){
            
            while(queue.size() > 0 && queue.peekLast() < arr[j]){   //kaam ke elements ko queue mai rakhna hai, queue mai wahi elements honge, jo maximum ho skth hai
                queue.removeLast();  //jo jab mai 2 ko add kr rha hu, toh uss samay window hogi [3,1,2], queue mai = [3,1], toh hume 2 ko add 
                                                        //                             krne se pehle 1 ko remove krna hoga, kyuki 1 ka ab koi kaam ni hai. 
            }

            // if (!queue.isEmpty() && queue.peek() < arr[j]) {  //kaam ke elements ko queue mai rakhna hai, queue mai wahi elements honge, jo maximum ho skth hai
            //     queue.clear();
            // }    
            queue.add(arr[j]);

            if (j - i + 1 < k){
                j++;
            }
            else {
                int max = queue.peek();
                System.out.print(max+",");      

                if (max == arr[i]) { //pehli window mai [1,3,-1] mai i=0 -> 1, ka calculation ni hua hai, toh ignore karo from calculation before moving to 2nd window
                                     //2nd window mai [3,-1, -3] mai i=1 -> 3, ka calculation kara hai, toh remove karo from calculation before moving to 3rd window
                    queue.removeFirst();
                }
                
                i++; j++;
            }
        }
    }
}