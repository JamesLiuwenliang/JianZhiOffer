import java.util.Stack;
import java.util.Vector;

public class Solution {

    private static class MinStack{

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack_min = new Stack<>();
        public MinStack() {

        }

        public void push(int val){
            if(stack.empty()) {
                stack_min.push(val);
            }
            stack.push(val);
            stack_min.push(Math.min(stack.peek(),stack_min.peek()));


        }

        public void pop(){
            if(stack.empty()){
                return;
            }
            stack_min.pop();
            stack.pop();

        }

        public int top(){
            if(stack.empty()){
                return -1;
            }

            return stack.peek();
        }

        public int min(){
            if(stack.empty()){
                return -1;
            }
            return stack_min.peek();

        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();


        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.min());
        minStack.pop();
        minStack.top();
        System.out.println(minStack.min());
    }
}
