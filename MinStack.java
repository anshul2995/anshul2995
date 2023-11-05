import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (val <= min){
            stack.add(min);
            min = val;
        }

        stack.add(val);
    }

    public void pop() {
        int top_of_the_stack = stack.pop();
        if (top_of_the_stack == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}