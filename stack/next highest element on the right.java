package stack;

import java.util.Stack;

// arr : [1 3 2 4]
// o/p : [3 4 4 -1]

class abc{
    public static void main(String[] args) {
            
        int[] arr = {1,3,2,4};
        int[] op = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length-1; i>=0; i--)
        {
            if (stack.isEmpty()) {
                op[i] = -1;
            }
            // yaha tmne else ni lagaya tha, 3ino mai se ek hi condition chalegi, toh else lagao phr. 
            else if (stack.peek() > arr[i]) {
                op[i] = stack.peek();
            }
            else {
                while(stack.size() > 0 && stack.peek() <= arr[i]){  //vaise hamesha size ka check hona chaiyeh.
                    stack.pop();
                }
                if (stack.empty()) {   // 1 5 2 4  -> stack is going to be empty when i is at 5
                    op[i] = -1 ;
                }
                else {                 // 1 3 2 4 -> stack will contain 1 element ie. 4 when i is at 3.
                    op[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }

        for (int i = 0 ; i < op.length; i++){
            System.out.print(op[i] + ", ");
        }
    }
}