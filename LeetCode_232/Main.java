package LeetCode_232;
import java.util.Stack;

class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek()); // Output: 1
        System.out.println(myQueue.pop());  // Output: 1
        System.out.println(myQueue.empty()); // Output: false
    }
}
