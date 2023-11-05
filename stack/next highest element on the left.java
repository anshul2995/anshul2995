package stack;

import java.util.Stack;

// arr : [1   3  2  4]
// o/p : [-1 -1  3  -1]

class abc1{
    public static void main(String[] args) {
            
        int[] arr = {1,3,2,4};
        int[] op = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

       for (int i = 0 ; i< arr.length; i++){

            if (stack.isEmpty()){
                op[i] = -1;
            }
            else if (stack.peek() > arr[i]){
                op[i] = stack.peek();
            }
            else {
                while ( stack.size() > 0 && stack.peek() <= arr[i]){
                    stack.pop();
                }
                if (stack.isEmpty()){
                    op[i] = -1;
                } else {
                    op[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
       }
       for(int i = 0 ; i < op.length; i++){
            System.out.print(op[i]+",");
       }
    }
}