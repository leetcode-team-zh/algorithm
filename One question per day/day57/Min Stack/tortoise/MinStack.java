package leetcode.d155;

import java.util.Stack;

public class MinStack {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        data.push(x);
        if(!min.isEmpty()){
            if(min.peek() >= x){
                min.push(x);
            }
        }else{
            min.push(x);
        }
    }

    public void pop() {
        if(data.isEmpty()){
            return;
        }
        int x = data.pop();
        if(min.peek() == x){
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
